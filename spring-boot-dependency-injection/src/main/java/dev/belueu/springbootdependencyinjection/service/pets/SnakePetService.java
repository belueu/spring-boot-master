package dev.belueu.springbootdependencyinjection.service.pets;

public class SnakePetService implements PetService {

    @Override
    public String getPetType() {
        return "Snakes are the best!";
    }
}
