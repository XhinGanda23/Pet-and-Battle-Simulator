# Pet-and-Battle-Simulator
# 🐾 PawPal - Interactive Pet Management and Battle Simulator 🐾

## Description/Overview
**PawPal** is a text-based, turn-based battle and simulation game implemented entirely in Java. The console application allows users to manage a roster of virtual pets, interact with them through activities like **Feed**, **Play**, and **Rest** to boost their core and battle stats, and initiate a **turn-based battle** between any two pets in the arena.

**Main features** include pet creation (Dog, Cat, Bird), stat tracking (Health, Strength, Defense, Vitals), and interactive combat where pets take turns attacking, defending, or using a unique special move.

**Problem it solves:** This project is designed to demonstrate and practice fundamental **Object-Oriented Programming (OOP)** concepts, specifically focusing on how to use **Inheritance** and **Polymorphism** to structure a simple, extensible game.

---

## OOP Concepts Applied
The **PawPal** application effectively utilizes the following OOP principles:

* **Encapsulation:** All pet characteristics, including vital stats (`hunger`, `energy`, `mood`) and battle stats (`health`, `strength`, `defense`, `speed`), are declared as `private` fields within the `Pet` class. Access and modification are strictly controlled through public **Getter** and **Setter** methods.
* **Inheritance:** The specialized pet classes (`Dog`, `Cat`, `Bird`) extend the abstract base class `Pet`. They inherit common functionality (`feed()`, `play()`, `rest()`) and specialize their initial stats and unique non-battle actions.
* **Polymorphism:** The `makeSound()` method is defined as `abstract` in `Pet` and is implemented uniquely in each subclass (e.g., `Dog` barks, `Cat` meows). Similarly, battle actions like Basic Attack call unique methods (`bite()`, `catScratch()`, `peck()`) based on the pet's runtime type.
* **Abstraction:** The `Pet` class is declared as `abstract`, defining the contract and essential structure (like the abstract `makeSound()` method) for all pets without fully implementing them, thereby hiding internal complexity from the `Main` application logic.

---

## Program Structure
The application is organized into several key classes to ensure modularity and clear responsibility:

| Class | Role |
| :--- | :--- |
| `Main` | The application entry point and main game controller. Manages the primary menu, user flow, and initiates interactions and battles. |
| `GameConsoleUI` | Handles all console input/output (I/O). Includes `displayMenu()`, `getUserChoice()`, and `displayPetStats()`. |
| `PetManager` | Manages the array storage of `Pet` objects. Handles adding pets, retrieving pets, and checking storage capacity. |
| `Pet` (abstract) | The base class for all pets. Defines all core attributes, common interaction methods, and the `calculateDamage()` logic. |
| `Dog`, `Cat`, `Bird` | Concrete classes inheriting from `Pet`. They define unique initial stats, special non-battle actions (`fetch()`, `scratch()`, `sing()`), and named battle moves. |
| `PetBattle` | Contains the core logic for the turn-based battle simulation. Manages turn order (based on Speed), action execution, and post-battle stat cleanup. |

**Text-Based Class Diagram:**
```
Main <-> GameConsoleUI
  │
  ├── PetManager <-> Pet (abstract)
  │                      ├── Dog
  │                      ├── Cat
  │                      └── Bird
  └── PetBattle
```
## How to Run the Program
1.  **Compile the Java source files.**
    * Ensure all `.java` files are in the same directory.
    * Run the following command in your terminal:
        ```bash
        javac *.java
        ```
2.  **Run the application:**
    * Execute the main class:
        ```bash
        java Main
        ```
    * Follow the on-screen menu prompts to add pets, interact with them, and start a battle.

## Sample Output
The following demonstrates adding a Dog and then viewing its stats:
```
Welcome to PawPal!

=== PawPal Menu ===

1. Add Pet
2. View Pets
3. Interact with Pet
4. Pet Battle
5. Exit
Enter choice: 1

Choose a pet type:
1. Dog
2. Cat
3. Bird
Enter choice: 1
Enter pet name: Bolt
Bolt has been added!

=== PawPal Menu ===
...
Enter choice: 2

=== Your Pets ===

1. Bolt

-- BOLT STATS --
Health (HP): 110
Strength (STR): 20
Defense (DEF): 10
Speed (SPD): 8
--- Vitals ---
Energy: 50/100
Mood: 50/100
Hunger: 50/100
```
---
The following demonstrates how to interact with pets:
```
Welcome to PawPal!

=== PawPal Menu ===
1. Add Pet
2. View Pets
3. Interact with Pet
4. Pet Battle
5. Exit
Enter choice: 3

Select a pet to interact with:
1. Bolt
Enter choice: 1

Interacting with Bolt!
1. Feed
2. Play
3. Rest
4. Make Sound
5. Special Action
Enter choice: 4
Bolt says: Woof! Woof!
```
---
The following demonstrates the battle between 2 pets:
```
Welcome to PawPal!

=== PawPal Menu ===
1. Add Pet
2. View Pets
3. Interact with Pet
4. Pet Battle
5. Exit
Enter choice: 4

=== Choose Pets for Battle ===
1. Bolt
------------------------------------------
-- BOLT STATS --
------------------------------------------
Health (HP):  110
Strength (STR): 20
Defense (DEF):  10
Speed (SPD):    8
--- Vitals ---
Energy: 50/100
Mood:   50/100
Hunger: 50/100
------------------------------------------
2. Flo
------------------------------------------
-- FLO STATS --
------------------------------------------
Health (HP):  100
Strength (STR): 15
Defense (DEF):  15
Speed (SPD):    12
--- Vitals ---
Energy: 50/100
Mood:   50/100
Hunger: 50/100
------------------------------------------
Select Pet 1:
Enter choice: 1
Select Pet 2:
Enter choice: 2

*** Interactive Battle Arena: Bolt vs. Flo ***
Bolt | HP: 110 | STR: 20 | DEF: 10
Flo | HP: 100 | STR: 15 | DEF: 15
------------------------------------------
Flo is faster and starts the battle!

--- Turn 1 | Flo's Turn ---
Flo | HP: 100 | STR: 15 | DEF: 15
Bolt | HP: 110 | STR: 20 | DEF: 10

Select Action:
1. Basic Attack (Strength)
2. Defend (Boost the DEF of the pet)
3. Special Move (Unique Ability)
Enter choice: 3
Flo uses **Pounce**!
Special Move dealt 12 damage to Bolt.

--- Turn 2 | Bolt's Turn ---
Bolt | HP: 98 | STR: 20 | DEF: 10
Flo | HP: 100 | STR: 15 | DEF: 15

Select Action:
1. Basic Attack (Strength)
2. Defend (Boost the DEF of the pet)
3. Special Move (Unique Ability)
Enter choice: 2
Bolt uses **Bark** to prepare for impact!
Bolt's Defense boosted to 15 for this turn.

--- Turn 3 | Flo's Turn ---
Flo | HP: 100 | STR: 15 | DEF: 15
Bolt | HP: 98 | STR: 20 | DEF: 15

Select Action:
1. Basic Attack (Strength)
2. Defend (Boost the DEF of the pet)
3. Special Move (Unique Ability)
Enter choice: 1
Flo uses **Scratch Attack**!
Dealt 5 damage to Bolt.

...

--- Turn 16 | Bolt's Turn ---
Bolt | HP: 21 | STR: 20 | DEF: 10
Flo | HP: 10 | STR: 15 | DEF: 15

Select Action:
1. Basic Attack (Strength)
2. Defend (Boost the DEF of the pet)
3. Special Move (Unique Ability)
Enter choice: 3
Bolt uses **Fetch Attack**!
Special Move dealt 15 damage to Flo.

------------------------------------------
Bolt is victorious!
Pet health and temporary stats restored.

```

## Authors and Acknowledgements

**Authors:**
* Christian Joseph A. Caraig (24-02989@g.batstate-u.edu.ph)
* Angel Loraine D. Laureta
* Fransis Emanuel C. Lucero
* Marcus James Anthony A. Madayag (24-01549@g.batstate-u.edu.ph)

**Acknowledgements:**
We express our sincere gratitude to the following contributors and resources:

* **Instructor:** For their invaluable guidance and constructive feedback throughout the development of this project.
* **Team Members:** For their effective collaboration and support, ensuring the successful completion of all modules.
* **Official Documentation:** Including official Java documentation, academic tutorials, and online resources such as Programiz and W3Schools.
* **External Tools:** Including external resources like YouTube videos and AI large language models (e.g., ChatGPT) used for supplementary knowledge and troubleshooting.
---

## Future Enhancements
* **Advanced Battle Mechanics:** Introduce status effects, critical hits, and energy management for special moves.
* **Pet Leveling System:** Implement a mechanism for pets to gain experience and permanently improve their base stats.
* **Persistent Data:** Implement a save/load system to retain pet data across program executions.
* **GUI Interface:** Develop a graphical user interface (e.g., using JavaFX or Swing) for improved user experience.

---

## References
* Java Documentation : [Oracle](https://docs.oracle.com/en/java/)
* OOP Concepts Overview : [Programiz](https://www.programiz.com/java-programming/object-oriented-programming)
* Sample tutorials : [w3schools.com](https://www.w3schools.com/), [Programiz](https://www.programiz.com/java-programming/object-oriented-programming)
* Youtube Tutorial/s : [YouTube Video](https://youtu.be/OFnFHjzbUVI?si=azjRLnBJtzfWxveg)
* AI's : [ChatGPT](https://chatgpt.com/)
