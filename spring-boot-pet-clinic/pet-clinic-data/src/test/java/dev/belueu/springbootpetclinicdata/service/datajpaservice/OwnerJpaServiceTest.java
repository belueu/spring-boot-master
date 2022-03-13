package dev.belueu.springbootpetclinicdata.service.datajpaservice;

import dev.belueu.springbootpetclinicdata.model.Owner;
import dev.belueu.springbootpetclinicdata.repository.OwnerRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @Mock
    OwnerRepo ownerRepo;
    @InjectMocks
    OwnerJpaService ownerJpaService;

    final String lastName = "Smith";
    final Long ownerId = 1L;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(ownerId).lastName(lastName).build();
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());

        when(ownerRepo.findAll()).thenReturn((ownerSet.stream().toList()));

        Set<Owner> owners = ownerJpaService.findAll();

        Assertions.assertNotNull(owners);
        Assertions.assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepo.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerJpaService.findById(ownerId);

        Assertions.assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepo.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerJpaService.findById(ownerId);

        Assertions.assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepo.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerJpaService.save(ownerToSave);

        Assertions.assertNotNull(savedOwner);

        verify(ownerRepo).save(any());
    }

    @Test
    void delete() {
        ownerJpaService.delete(any());

        // default is 1 times
        verify(ownerRepo, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerJpaService.deleteById(ownerId);

        verify(ownerRepo, times(1)).deleteById(anyLong());
    }

//    @Test
//    void findByLastName() {
//
//        when(ownerRepo.findByLastName(any())).thenReturn(Optional.ofNullable(returnOwner));
//
//        Owner smith = ownerJpaService.findByLastName(lastName);
//
//        Assertions.assertEquals(lastName, smith.getLastName());
//
//        verify(ownerRepo).findByLastName(any());
//    }
}