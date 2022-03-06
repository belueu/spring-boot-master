package dev.belueu.springbootrecipeapp.converter;

import dev.belueu.springbootrecipeapp.command.NoteCommand;
import dev.belueu.springbootrecipeapp.model.Note;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NoteCommandToNote implements Converter<NoteCommand, Note> {

    @Override
    public Note convert(NoteCommand source) {
        if (source == null) {
            return null;
        }

        final Note note = new Note();
        note.setId(source.getId());
        note.setRecipeNote(source.getRecipeNotes());

        return note;
    }
}
