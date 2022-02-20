package dev.belueu.springbootdependencyinjection.service.pets;

public class PetServiceFactory {

    public PetService getPetService(String petType) {
        return switch (petType) {
            case "dog" -> new DogPetService();
            case "snake" -> new SnakePetService();
            default -> new CatPetService();
        };
    }
}
