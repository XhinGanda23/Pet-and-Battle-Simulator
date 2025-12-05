public class Main {
    public static void main(String[] args) {

        GameConsoleUI ui = new GameConsoleUI();
        PetManager manager = new PetManager(10); 
        PetBattle battle = new PetBattle();

        boolean running = true;

        while (running) {
            ui.displayMenu(); 
            int choice = ui.getUserChoice();

            switch (choice) {

                case 1: // Add Pet
                    System.out.println("\nChoose a pet type:");
                    System.out.println("1. Dog");
                    System.out.println("2. Cat");
                    System.out.println("3. Bird");

                    int type = ui.getUserChoice();

                    String name = ui.getPetName();

                    Pet newPet = null;

                    if (type == 1) {
                        newPet = new Dog(name);
                    } else if (type == 2) {
                        newPet = new Cat(name);
                    } else if (type == 3) {
                        newPet = new Bird(name);
                    } else {
                        System.out.println("Invalid pet type!");
                        break;
                    }

                    manager.addPet(newPet);
                    System.out.println(name + " has been added!");
                    break;

                case 2: // Show all pets
                    System.out.println("\n=== Your Pets ===");
                    manager.showAllPets(ui);
                    manager.zeroPets(manager.getCount()); 
                    break;

                case 3: // Interact with a pet
                    System.out.println("\nSelect a pet to interact with:");
                    manager.showAllPets(ui);
                    int petIndex = ui.getUserChoice() - 1;

                    Pet selectedPet = manager.getPet(petIndex);

                    if (selectedPet == null) {
                        System.out.println("Unable to interact with this pet.");
                        break;
                    }

                    System.out.println("\nInteracting with " + selectedPet.getName() + "!");
                    System.out.println("1. Feed");
                    System.out.println("2. Play");
                    System.out.println("3. Rest");
                    System.out.println("4. Make Sound");
                    System.out.println("5. Special Action");

                    int action = ui.getUserChoice();
                    
                    // Interaction
                    switch (action) {
                        case 1:
                            selectedPet.feed();
                            System.out.println(selectedPet.getName() + " has been fed!");
                            break;

                        case 2:
                            selectedPet.play();
                            System.out.println(selectedPet.getName() + " played!");
                            break;

                        case 3:
                            selectedPet.rest();
                            System.out.println(selectedPet.getName() + " is resting.");
                            break;

                        case 4:
                            selectedPet.makeSound();
                            break;

                        case 5:
                            if (selectedPet instanceof Dog) {
                                ((Dog) selectedPet).fetch();
                            } else if (selectedPet instanceof Cat) {
                                ((Cat) selectedPet).scratch();
                            } else if (selectedPet instanceof Bird) {
                                ((Bird) selectedPet).sing();
                            } else {
                                System.out.println("No special action available.");
                            }
                            break;

                        default:
                            System.out.println("Invalid action!");
                    }
                    break;

                
                
                // Pet Battle
                case 4:
                    System.out.println("\n=== Choose Pets for Battle ===");
                    manager.showAllPets(ui);

                    if (manager.getCount() < 2) { 
                        System.out.println("You need at least 2 pets to start a battle!");
                        break;
                    }

                    System.out.println("Select Pet 1:");
                    int pet1Index = ui.getUserChoice() - 1;
                    Pet pet1 = manager.getPet(pet1Index);

                    if (pet1 == null) {
                        System.out.println("Invalid Pet 1 selection.");
                        break;
                    }

                    System.out.println("Select Pet 2:");
                    int pet2Index = ui.getUserChoice() - 1;
                    Pet pet2 = manager.getPet(pet2Index);

                    // Ensures that Pet 2 is valid and not the same as Pet 1
                    if (pet2 == null || pet1 == pet2) {
                        System.out.println("Invalid Pet 2 selection or the same pet was chosen. Battle cancelled.");
                        break;
                    }

                    
                    battle.startBattle(pet1, pet2, ui); 
                    break;
                
                    // Exception Handling
                default:
                    System.out.println("Invalid choice! Try again.");
                    
                case 5: // Exit
                    System.out.println("Exiting PawPal... Goodbye!");
                    running = false;
                    break;
            }
        }
    }
}