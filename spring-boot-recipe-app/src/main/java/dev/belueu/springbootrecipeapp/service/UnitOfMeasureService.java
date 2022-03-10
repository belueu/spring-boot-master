package dev.belueu.springbootrecipeapp.service;

import dev.belueu.springbootrecipeapp.command.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listUoms();
}
