/**
 * ITSC 1213 - 004
 * @Eli McCall
 * 4/2/2023
 */

import java.util. *;

public class PetStore implements PetStoreSpecification {

    private String storeName;

    private ArrayList<Dog> availableDogs = new ArrayList();
    private ArrayList<Cat> availableCats = new ArrayList();
    private ArrayList<ExoticPet> availableExoticPets = new ArrayList();
    private ArrayList<Pet> inventory = new ArrayList();
    private ArrayList<Member> memberList = new ArrayList();
    private ArrayList<PremiumMember> premiumMemberList = new ArrayList();
    private static int nextPetID = 1;
    private static int nextMemberID = 1;
    Scanner scnr = new Scanner(System.in);


    public PetStore(String storeName) {
        this.storeName = storeName;
        Dog dog1 = new Dog(
            "Waffle",
            "German Shepherd",
            "Female",
            12,
            85,
            getNextPetID(),
            500
        );
        Dog dog2 = new Dog("Poe", "Corgi", "Male", 3, 35, getNextPetID(), 450);
        Cat cat1 = new Cat(
            "Karma",
            "Orange Tabby",
            "Female",
            6,
            15,
            getNextPetID(),
            200
        );
        Cat cat2 = new Cat("Kit", "Maine Coon", "Male", 6, 18, getNextPetID(), 150);
        ExoticPet ep1 = new ExoticPet(
            "Pancake",
            "Bearded Dragon",
            "Male",
            6,
            0.8,
            getNextPetID(),
            75
        );
        ExoticPet ep2 = new ExoticPet(
            "Noodle",
            "Ball Python",
            "Male",
            4,
            2,
            getNextPetID(),
            95
        );

        availableDogs.add(dog1);
        availableDogs.add(dog2);
        availableCats.add(cat1);
        availableCats.add(cat2);
        availableExoticPets.add(ep1);
        availableExoticPets.add(ep2);

        Member member1 = new Member("Jo", getNextMemberID(), true);
        member1.addCat(new Cat("Valjean", "White tabby", "Male", 1, 10, 0, 0));
        memberList.add(member1);

        PremiumMember member2 = new PremiumMember("Sage", getNextMemberID(), false, false);
        premiumMemberList.add(member2);
        member2.addExoticPet(
            new ExoticPet("Smaug", "Bearded Dragon", "Male", 5, 1, 0, 0)
        );

    }

    public static int getNextPetID() {
        nextPetID++;
        return nextPetID - 1;
    }
    
    public static int getNextMemberID() {
        nextMemberID++;
        return nextMemberID - 1;
    }


    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public ArrayList<Dog> getAvailableDogs() {
        return availableDogs;
    }

    public void setAvailableDogs(ArrayList<Dog> availableDogs) {
        this.availableDogs = availableDogs;
    }

    public ArrayList<Cat> getAvailableCats() {
        return availableCats;
    }

    public void setAvailableCats(ArrayList<Cat> availableCats) {
        this.availableCats = availableCats;
    }

    public ArrayList<ExoticPet> getAvailableExoticPets() {
        return availableExoticPets;
    }

    public void setAvailableExoticPets(ArrayList<ExoticPet> availableExoticPets) {
        this.availableExoticPets = availableExoticPets;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }



    public void setMemberList(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    public ArrayList<PremiumMember> getPremiumMemberList() {
        return premiumMemberList;
    }

    public void setPremiumMemberList(ArrayList<PremiumMember> premiumMemberList) {
        this.premiumMemberList = premiumMemberList;
    }

    public void removePet(String type, int index) {
        if (type.equals("dog")) 
            availableDogs.remove(index);
        else if (type.equals("cat")) 
            availableCats.remove(index);
        else if (type.equals("exoticPet")) 
            availableExoticPets.remove(index);

    }

     public void addNewMember(String name, boolean premium) {
        if (premium) {
            premiumMemberList.add(new PremiumMember(name,getNextMemberID(),false,false));
        } else {
            memberList.add(new Member(name,getNextMemberID(), false));
        }
    }

    //asks for the species and information of the object to add to the inventory
    public ArrayList<Pet> addPet(){
        ArrayList<Pet> tempPets = new ArrayList();
        boolean repeat = true;
        while (repeat == true){
        System.out.println("What type of pet would you like to add? 1.Dog 2.Cat 3.Other");
        int decide = scnr.nextInt();
        scnr.nextLine();
        //Dog
        if(decide == 1){
            System.out.println("What is the name of the dog");
            String tempName = scnr.nextLine();
            System.out.println("What is the breed of dog?");
            String tempBreed = scnr.nextLine();
            System.out.println("Is the dog male or female?");
            String tempSex = scnr.nextLine();
            System.out.println("How old is the dog?");
            int tempAge = scnr.nextInt();
            System.out.println("How much does the dog weigh?");
            double tempWeight = scnr.nextDouble();
            System.out.println("How much does this dog cost?");
            double tempPrice = scnr.nextDouble();
            Dog temp = new Dog(tempName, tempBreed, tempSex, tempAge, tempWeight, getNextPetID(), tempPrice);
            tempPets.add(temp);
        }
        //Cat
        else if(decide == 2){
            System.out.println("What is the name of the cat");
            String tempName = scnr.nextLine();
            System.out.println("What is the breed of cat?");
            String tempBreed = scnr.nextLine();
            System.out.println("Is the cat male or female?");
            String tempSex = scnr.nextLine();
            System.out.println("How old is the cat?");
            int tempAge = scnr.nextInt();
            System.out.println("How much does the cat weigh?");
            double tempWeight = scnr.nextDouble();
            System.out.println("How much does this cat cost?");
            double tempPrice = scnr.nextDouble();
            Cat temp = new Cat(tempName, tempBreed, tempSex, tempAge, tempWeight, getNextPetID(), tempPrice);
            tempPets.add(temp);
        }
        //Exotic
        else{
            System.out.println("What is the name of the animal");
            String tempName = scnr.nextLine();
            System.out.println("What is the species of animal?");
            String tempBreed = scnr.nextLine();
            System.out.println("Is the animal male or female?");
            String tempSex = scnr.nextLine();
            System.out.println("How old is the animal?");
            int tempAge = scnr.nextInt();
            System.out.println("How much does the animal weigh?");
            double tempWeight = scnr.nextDouble();
            System.out.println("How much does this animal cost?");
            double tempPrice = scnr.nextDouble();
            ExoticPet temp = new ExoticPet(tempName, tempBreed, tempSex, tempAge, tempWeight, getNextPetID(), tempPrice);
            tempPets.add(temp);
        }
            System.out.println("Would you like to add another pet? 1.Yes 2.No");
            decide = scnr.nextInt();
            if(decide == 1){
                repeat = true;
            }
            else{
                repeat = false;
            }
        }
        return tempPets;
    }

    //Goes through the list and adds them to the inventory
    public void adoptionDrive(ArrayList<Pet> temp, double price){

        for(int i = 0; i < temp.size(); i++){
            temp.get(i).setPrice(price);
            if (temp.get(i) instanceof Dog){
                availableDogs.add(((Dog)temp.get(i)));
                temp.remove(i);
                i--;
            }
            else if (temp.get(i) instanceof Cat){
                availableCats.add(((Cat)temp.get(i)));
                temp.remove(i);
                i--;
            }
            else if (temp.get(i) instanceof ExoticPet){
                availableExoticPets.add(((ExoticPet)temp.get(i)));
                temp.remove(i);
                i--;
            }
            
        }

    }
    //make one arraylist for everything
    public void singleInventory(){

        inventory.clear();

        for (Pet p : availableDogs){
            inventory.add(p);
        }

        for (Pet p : availableCats){
            inventory.add(p);
        }

        for (Pet p : availableExoticPets){
            inventory.add(p);
        }

    }
    //gets the total price of everything in the inventory
    public double inventoryValue(){

        double total = 0;

        for(Pet p : inventory){
            total = total + p.getPrice();
        }

        return total;
        
    }

    public void display(){
        System.out.println();
        for (Pet p : inventory){
            System.out.println("$" + p.getPrice() + " " + p.getName() + ": " + p.getSpecies());
        }
        System.out.println();
    }

    public void displayMember(){
        System.out.println();
        for (int i = 0; i < memberList.size(); i++){
            System.out.println(i + ". " + memberList.get(i).getName());
        }
        System.out.println();
    }

    public void displayPremiumMember(){
        System.out.println();
        for (int i = 0; i < premiumMemberList.size(); i++){
            System.out.println(i + ". " + premiumMemberList.get(i).getName());
        }
        System.out.println();
    }

    public void order(){
        System.out.println();
        this.singleInventory();
        for (int i = 0; i < inventory.size(); i++){
            System.out.println(i+1 + ". " + inventory.get(i).getName() + ": " + inventory.get(i).getSpecies());
        }
        System.out.println();
    }

    //All of the code for comparing two objects come together here
    public void comparison(){
        this.order();
        System.out.println("Pick the first pet you want to compare prices with");
        int pet1 = scnr.nextInt();
        System.out.println("Pick the second pet you want to compare prices with");
        int pet2 = scnr.nextInt();
        //Minus one to account for index value
        int difference = inventory.get(pet1-1).compareTo(inventory.get(pet2-1));
        if (difference == -1){
            System.out.println();
            System.out.println(inventory.get(pet1-1).getName() + " is cheaper than " + inventory.get(pet2-1).getName());
            System.out.println();
        }
        else if (difference == 1){
            System.out.println();
            System.out.println(inventory.get(pet1-1).getName() + " is more expensive than " + inventory.get(pet2-1).getName());
            System.out.println();
        }
        else if (difference == 0){
            System.out.println();
            System.out.println(inventory.get(pet1-1).getName() + " is the same price as " + inventory.get(pet2-1).getName());
            System.out.println();
        }

        

    }

    public void linkPet(){
        Scanner scnr = new Scanner(System. in);
        boolean repeat = true;
        while (repeat == true){
        System.out.println("What type of pet would you like to link? 1.Dog 2.Cat 3.Other");
        int decide = scnr.nextInt();
        scnr.nextLine();
        //Dog
        if(decide == 1){
            System.out.println("What is the name of the dog");
            String tempName = scnr.nextLine();
            System.out.println("What is the breed of dog?");
            String tempBreed = scnr.nextLine();
            System.out.println("Is the dog male or female?");
            String tempSex = scnr.nextLine();
            System.out.println("How old is the dog?");
            int tempAge = scnr.nextInt();
            System.out.println("How much does the dog weigh?");
            double tempWeight = scnr.nextDouble();
            System.out.println("How much does this dog cost?");
            double tempPrice = scnr.nextDouble();
            Dog temp = new Dog(tempName, tempBreed, tempSex, tempAge, tempWeight, getNextPetID(), tempPrice);
            System.out.println("Are you a premium member? 1.No 2.Yes");
        int prem = scnr.nextInt();
        if (prem == 1){
            displayMember();
            System.out.println("Which number is your member?");
            int num = scnr.nextInt();
            Member mem = memberList.get(num);
            mem.addDog(temp);
            System.out.println("You are currently linked with these pets: ");
            mem.getDogsOwned();
            mem.getCatsOwned();
            mem.getExoticPetsOwned();
        }
        else{
            displayPremiumMember();
            System.out.println("Which number is your member?");
            int num = scnr.nextInt();
            PremiumMember preMem = premiumMemberList.get(num);
            preMem.addDog(temp);
            System.out.println("You are currently linked with these pets: ");
            preMem.getDogsOwned();
            preMem.getCatsOwned();
            preMem.getExoticPetsOwned();
        }
        }
        else if(decide == 2){
            System.out.println("What is the name of the cat");
            String tempName = scnr.nextLine();
            System.out.println("What is the breed of cat?");
            String tempBreed = scnr.nextLine();
            System.out.println("Is the cat male or female?");
            String tempSex = scnr.nextLine();
            System.out.println("How old is the cat?");
            int tempAge = scnr.nextInt();
            System.out.println("How much does the cat weigh?");
            double tempWeight = scnr.nextDouble();
            System.out.println("How much does this cat cost?");
            double tempPrice = scnr.nextDouble();
            Cat temp = new Cat(tempName, tempBreed, tempSex, tempAge, tempWeight, getNextPetID(), tempPrice);
            System.out.println("Are you a premium member? 1.No 2.Yes");
        int prem = scnr.nextInt();
        if (prem == 1){
            displayMember();
            System.out.println("Which number is your member?");
            int num = scnr.nextInt();
            Member mem = memberList.get(num);
            mem.addCat(temp);
            System.out.println("You are currently linked with these pets: ");
            mem.getDogsOwned();
            mem.getCatsOwned();
            mem.getExoticPetsOwned();
        }
        else{
            displayPremiumMember();
            System.out.println("Which number is your member?");
            int num = scnr.nextInt();
            PremiumMember preMem = premiumMemberList.get(num);
            preMem.addCat(temp);
            System.out.println("You are currently linked with these pets: ");
            preMem.getDogsOwned();
            preMem.getCatsOwned();
            preMem.getExoticPetsOwned();
        }
        }
        else{
            System.out.println("What is the name of the animal");
            String tempName = scnr.nextLine();
            System.out.println("What is the species of animal?");
            String tempBreed = scnr.nextLine();
            System.out.println("Is the animal male or female?");
            String tempSex = scnr.nextLine();
            System.out.println("How old is the animal?");
            int tempAge = scnr.nextInt();
            System.out.println("How much does the animal weigh?");
            double tempWeight = scnr.nextDouble();
            System.out.println("How much does this animal cost?");
            double tempPrice = scnr.nextDouble();
            ExoticPet temp = new ExoticPet(tempName, tempBreed, tempSex, tempAge, tempWeight, getNextPetID(), tempPrice);
            System.out.println("Are you a premium member? 1.No 2.Yes");
        int prem = scnr.nextInt();
        if (prem == 1){
            displayMember();
            System.out.println("Which number is your member?");
            int num = scnr.nextInt();
            Member mem = memberList.get(num);
            mem.addExoticPet(temp);
            System.out.println("You are currently linked with these pets: ");
            mem.getDogsOwned();
            mem.getCatsOwned();
            mem.getExoticPetsOwned();
        }
        else{
            displayPremiumMember();
            System.out.println("Which number is your member?");
            int num = scnr.nextInt();
            PremiumMember preMem = premiumMemberList.get(num);
            preMem.addExoticPet(temp);
            System.out.println("You are currently linked with these pets: ");
            preMem.getDogsOwned();
            preMem.getCatsOwned();
            preMem.getExoticPetsOwned();
        }
        }
        System.out.println("Would you like to link another pet to owner? 1.Yes 2.No");
        int x = scnr.nextInt();
        if (x == 2){
            repeat = false;
        }
        //While statement end
        }
    //method end
    }

}
