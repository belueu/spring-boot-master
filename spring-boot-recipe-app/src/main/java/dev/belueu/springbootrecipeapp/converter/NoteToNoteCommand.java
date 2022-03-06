package dev.belueu.springbootrecipeapp.converter;

import dev.belueu.springbootrecipeapp.command.NoteCommand;
import dev.belueu.springbootrecipeapp.model.Note;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NoteToNoteCommand implements Converter<Note, NoteCommand> {

    @Override
    public NoteCommand convert(Note source) {
        if (source == null) {
            return null;
        }

        final NoteCommand noteCommand = new NoteCommand();
        noteCommand.setId(source.getId());
        noteCommand.setRecipeNotes(source.getRecipeNote());

        return noteCommand;
    }
}
