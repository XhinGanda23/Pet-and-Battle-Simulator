import java.util.Scanner;

public class GameConsoleUI {
    private Scanner scanner = new Scanner(System.in);

    public int getUserChoice() {
        try {
            System.out.print("Enter choice: ");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number.");
            return -1;
        }
    }

    public String getPetName() {
        System.out.print("Enter pet name: ");
        return scanner.nextLine();
    }

    public void displayMenu() {
        System.out.println("Welcome to PawPal!");
        System.out.println("\n=== PawPal Menu ===");
        System.out.println("1. Add Pet");
        System.out.println("2. View Pets");
        System.out.println("3. Interact with Pet");
        System.out.println("4. Pet Battle"); 
        System.out.println("5. Exit");
       

    }

        // NEW METHOD: Displays all core and battle stats for a pet
    public void displayPetStats(Pet pet) {
        System.out.println("------------------------------------------");
        System.out.println("-- " + pet.getName().toUpperCase() + " STATS --");
        System.out.println("------------------------------------------");
        System.out.println("Health (HP):  " + pet.getHealth());
        System.out.println("Strength (STR): " + pet.getStrength());
        System.out.println("Defense (DEF):  " + pet.getDefense());
        System.out.println("Speed (SPD):    " + pet.getSpeed());
        System.out.println("--- Vitals ---");
        System.out.println("Energy: " + pet.getEnergy() + "/100");
        System.out.println("Mood:   " + pet.getMood() + "/100");
        System.out.println("Hunger: " + pet.getHunger() + "/100");
        System.out.println("------------------------------------------");
    }
}
