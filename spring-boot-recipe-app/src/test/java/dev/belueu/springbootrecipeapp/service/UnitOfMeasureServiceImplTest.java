package dev.belueu.springbootrecipeapp.service;

import dev.belueu.springbootrecipeapp.command.UnitOfMeasureCommand;
import dev.belueu.springbootrecipeapp.converter.UnitOfMeasureToUnitOfMeasureCommand;
import dev.belueu.springbootrecipeapp.model.UnitOfMeasure;
import dev.belueu.springbootrecipeapp.repository.UnitOfMeasureRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UnitOfMeasureServiceImplTest {


    @Mock
    UnitOfMeasureRepo unitOfMeasureRepo;

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    UnitOfMeasureServiceImpl service;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
        service = new UnitOfMeasureServiceImpl(unitOfMeasureRepo, unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    public void listUoms() throws Exception {
        //given
        Set<UnitOfMeasure> unitsOfMeasure = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        unitsOfMeasure.add(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2L);
        unitsOfMeasure.add(uom2);


        when(unitOfMeasureRepo.findAll()).thenReturn(new ArrayList<>(unitsOfMeasure));

        //when
        Set<UnitOfMeasureCommand> commands = service.listUoms();

        //then
        assertEquals(2, commands.size());
        verify(unitOfMeasureRepo, times(1)).findAll();
    }
}