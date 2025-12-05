public abstract class Pet {
    private String name;
    private int hunger;
    private int energy;
    private int mood;

    // Battle Stats
    private int health;
    private int strength;
    private int defense;
    private int speed;

    // Stat Maximums 
    private final int MAX_HEALTH = 1000;
    private final int MAX_STRENGTH = 500;
    private final int MAX_DEFENSE = 500;
    private final int MAX_SPEED = 100;

    public Pet(String name) {
        this.name = name;
        this.hunger = 50;
        this.energy = 50;
        this.mood = 50;
        // Base Battle Stats
        this.health = 100;
        this.strength = 10;
        this.defense = 5;
        this.speed = 5;
    }

    // Getters and Setters (Encapsulation)
    public String getName() { return name; }
    public int getHunger() { return hunger; }
    public int getEnergy() { return energy; }
    public int getMood() { return mood; }
    // Getters/Setters
    public int getHealth() { return health; }
    public int getStrength() { return strength; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }

    public void setHunger(int hunger) { this.hunger = Math.min(100, Math.max(0, hunger)); } 
    public void setEnergy(int energy) { this.energy = Math.min(100, Math.max(0, energy)); } 
    public void setMood(int mood) { this.mood = Math.min(100, Math.max(0, mood)); } 
    // Setters
    public void setHealth(int health) { this.health = Math.min(MAX_HEALTH, Math.max(0, health)); }
    public void setStrength(int strength) { this.strength = Math.min(MAX_STRENGTH, strength); }
    public void setDefense(int defense) { this.defense = Math.min(MAX_DEFENSE, defense); }
    public void setSpeed(int speed) { this.speed = Math.min(MAX_SPEED, speed); }

    // Shared behaviors
    public void feed() {
        setHunger(getHunger() - 10);
        setMood(getMood() + 5);
        setDefense(getDefense() + 10);
        System.out.println(getName() + "'s Defense increased by 10!");
    }

    public void play() {
        setEnergy(getEnergy() - 10);
        setMood(getMood() + 10);
        setStrength(getStrength() + 100);
        System.out.println(getName() + "'s Strength increased by 10!");
    }

    public void rest() {
        setEnergy(getEnergy() + 20);
        setMood(getMood() - 5);
        setHealth(getHealth() + 20);
        System.out.println(getName() + "'s Health (Max HP) increased by 20!");
    }

    // Polymorphism
    public abstract void makeSound();
    public int calculateDamage(Pet defender) {
        // Simple damage calculation: Attacker Strength - Defender Defense
        return Math.max(1, this.strength - defender.defense);

        
    }

    public int getMaxHealth() {
        return MAX_HEALTH;
    }
}