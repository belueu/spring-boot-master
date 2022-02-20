package dev.belueu.springbootdependencyinjection.service.pets;

//@Profile({"dog"})
//@Service
public class DogPetService implements PetService {

    @Override
    public String getPetType() {
        return "Dogs are the best!";
    }
}
