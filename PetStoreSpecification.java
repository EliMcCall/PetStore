import java.util.*;

public interface PetStoreSpecification {

    //Goes through the array list of Pets and overrides them all to be the given double price and add them into the inventory
    public void adoptionDrive(ArrayList<Pet> p, double price);

    //goes through a list of all the pets and adds the prices for all of them
    public double inventoryValue();

}