package dev.belueu.springbootrecipeapp.service;

import dev.belueu.springbootrecipeapp.command.UnitOfMeasureCommand;
import dev.belueu.springbootrecipeapp.converter.UnitOfMeasureToUnitOfMeasureCommand;
import dev.belueu.springbootrecipeapp.repository.UnitOfMeasureRepo;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {
    private final UnitOfMeasureRepo unitOfMeasureRepo;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepo unitOfMeasureRepo, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureRepo = unitOfMeasureRepo;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listUoms() {
        return unitOfMeasureRepo.findAll().stream()
                .map(unitOfMeasureToUnitOfMeasureCommand::convert)
                .collect(Collectors.toSet());
    }
}
