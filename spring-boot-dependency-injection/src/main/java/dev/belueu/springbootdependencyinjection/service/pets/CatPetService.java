package dev.belueu.springbootdependencyinjection.service.pets;

//@Profile({"cat", "default"})
//@Service
public class CatPetService implements PetService {

    @Override
    public String getPetType() {
        return "Cats are the best!";
    }
}
