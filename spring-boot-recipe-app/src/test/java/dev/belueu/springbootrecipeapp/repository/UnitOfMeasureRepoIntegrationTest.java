package dev.belueu.springbootrecipeapp.repository;

import dev.belueu.springbootrecipeapp.model.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UnitOfMeasureRepoIntegrationTest {

    @Autowired
    UnitOfMeasureRepo unitOfMeasureRepo;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findByDescriptionTeaspoon() throws Exception {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepo.findByUom("Teaspoon");

        assertEquals("Teaspoon", uomOptional.get().getUom());
    }

    @Test
    void findByDescriptionCup() throws Exception {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepo.findByUom("Cup");

        assertEquals("Cup", uomOptional.get().getUom());
    }
}