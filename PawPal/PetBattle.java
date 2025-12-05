public class PetBattle {

    // Helper method to get user input for battle actions
    private int getBattleChoice(GameConsoleUI ui) {
        System.out.println("\nSelect Action:");
        System.out.println("1. Basic Attack (Strength)");
        System.out.println("2. Defend (Boost the DEF of the pet)");
        System.out.println("3. Special Move (Unique Ability)");
        return ui.getUserChoice();
    }
    
    // Helper method to display pet stats
    private void displayBattleStats(Pet pet) {
        System.out.println(pet.getName() + " | HP: " + pet.getHealth() + " | STR: " + pet.getStrength() + " | DEF: " + pet.getDefense());
    }
    
    // Helper method to reset pet stats after battle or defense
    private void resetStats(Pet pet, int initialDefense) {
        pet.setDefense(initialDefense);
    }


    public void startBattle(Pet pet1, Pet pet2, GameConsoleUI ui) {
        System.out.println("\n*** Interactive Battle Arena: " + pet1.getName() + " vs. " + pet2.getName() + " ***");

        // Setup and Initial Stats
        displayBattleStats(pet1);
        displayBattleStats(pet2);
        System.out.println("------------------------------------------");
        
        // Store initial stats for defense buffs and post-battle reset
        int p1InitialDefense = pet1.getDefense();
        int p2InitialDefense = pet2.getDefense();
        
        // Determine initial attacker based on Speed
        Pet currentPet = (pet1.getSpeed() >= pet2.getSpeed()) ? pet1 : pet2;
        Pet opponentPet = (currentPet == pet1) ? pet2 : pet1;
        
        System.out.println(currentPet.getName() + " is faster and starts the battle!");

        int turn = 1;

        // Battle Loop
        while (pet1.getHealth() > 0 && pet2.getHealth() > 0) {
            
            System.out.println("\n--- Turn " + turn + " | " + currentPet.getName() + "'s Turn ---");
            displayBattleStats(currentPet);
            displayBattleStats(opponentPet);

            // Reset defense buff from opponent's previous "Defend" action
            if (opponentPet.getName().equals(pet1.getName())) {
                resetStats(opponentPet, p1InitialDefense);
            } else {
                resetStats(opponentPet, p2InitialDefense);
            }
            // Exception HAndling for invalid input
            int choice = -1;
            while (choice < 1 || choice > 3) {
                choice = getBattleChoice(ui);
                if (choice < 1 || choice > 3) {
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
                }
            }

            // Execute Action based on user choice
            switch (choice) {
                case 1: // Basic Attack
                    if (currentPet instanceof Dog) {
                        ((Dog) currentPet).bite();
                    } else if (currentPet instanceof Cat) {
                        ((Cat) currentPet).catScratch();
                    } else if (currentPet instanceof Bird) {
                        ((Bird) currentPet).peck();
                    }
                    // Damage calculator
                    int damage = currentPet.calculateDamage(opponentPet);
                    opponentPet.setHealth(opponentPet.getHealth() - damage);
                    System.out.println("Dealt " + damage + " damage to " + opponentPet.getName() + ".");
                    break;
                    
                case 2: // Defend
                    if (currentPet instanceof Dog) {
                        ((Dog) currentPet).bark();
                    } else if (currentPet instanceof Cat) {
                        ((Cat) currentPet).growl();
                    } else if (currentPet instanceof Bird) {
                        ((Bird) currentPet).chirpDefend();
                    }
                    
                    int initialDef = currentPet.getDefense();
                    currentPet.setDefense(initialDef + 5); 
                    System.out.println(currentPet.getName() + "'s Defense boosted to " + currentPet.getDefense() + " for this turn.");
                    break;
                    
                case 3: // Special Move
                    int specialDamage = currentPet.getStrength() + 5; 
                    
                    if (currentPet instanceof Dog) {
                        System.out.println(currentPet.getName() + " uses **Fetch Attack**!");
                        specialDamage = (int)(currentPet.getStrength() * 1.5);
                    } else if (currentPet instanceof Cat) {
                        System.out.println(currentPet.getName() + " uses **Pounce**!");
                        specialDamage = currentPet.getStrength() + 7; 
                    } else if (currentPet instanceof Bird) {
                        System.out.println(currentPet.getName() + " uses **Wind Blast**!");
                        specialDamage = currentPet.getStrength() + 5;
                    } else {
                        System.out.println("No unique special move available. Using enhanced attack.");
                    }
                    
                    specialDamage = Math.max(1, specialDamage - opponentPet.getDefense());
                    opponentPet.setHealth(opponentPet.getHealth() - specialDamage);
                    System.out.println("Special Move dealt " + specialDamage + " damage to " + opponentPet.getName() + ".");
                    break;

                default:
                    System.out.println("No action taken.");
            }

            // Check for defeat
            if (opponentPet.getHealth() <= 0) 
                break;

            // Swap roles for the next turn
            Pet temp = currentPet;
            currentPet = opponentPet;
            opponentPet = temp;
            
            turn++;
        }

        //Battle Conclusion
        System.out.println("\n------------------------------------------");
        
        Pet winner = (pet1.getHealth() > 0) ? pet1 : pet2;
        Pet loser = (winner == pet1) ? pet2 : pet1;

        if (pet1.getHealth() > 0 || pet2.getHealth() > 0) {
            System.out.println(winner.getName() + " is victorious!");
            winner.setMood(winner.getMood() + 20); 
            loser.setMood(loser.getMood() - 10);
        } else {
            System.out.println("Both pets collapsed! It's a draw!");
        }
        
        // Reset of stats
        resetStats(pet1, p1InitialDefense);
        resetStats(pet2, p2InitialDefense);
        pet1.setHealth(100); 
        pet2.setHealth(100);
        System.out.println("Pet health and temporary stats restored.");
    }
}