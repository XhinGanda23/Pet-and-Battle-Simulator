public class PetManager {
    private Pet[] pets;
    private int count;

    public PetManager(int size) {
        pets = new Pet[size];
        count = 0;
    }

    public void addPet(Pet pet) {
        if (count < pets.length) {
            pets[count++] = pet;
        } else {
            System.out.println("Pet storage is full!");
        }
    }

    public Pet getPet(int index) {
        try {
            return pets[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid pet index!");
            return null;
        }
    }

    public void showAllPets(GameConsoleUI ui) {
        for (int i = 0; i < count; i++) {
            System.out.println((i+1) + ". " + pets[i].getName());
            ui.displayPetStats(pets[i]);
        }
    }

    public void zeroPets(int count) {
        if ( count <= 0){
            System.out.println("You have 0 pets added.");
        }
    }

    public int getCount() {
        return count;
    }
}
