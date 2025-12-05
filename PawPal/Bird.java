public class Bird extends Pet {

    public Bird(String name) {
        super(name);
        setHealth(100);
        setStrength(12);
        setDefense(18);
        setSpeed(15);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " chirps happily!");
    }

    public void sing() {
        System.out.println(getName() + " is singing beautifully!");
        setMood(getMood() + 7);
        setDefense(getDefense() + 1);
        System.out.println(getName() + "'s Defense increased by 10!");
    }
    
    public void peck() {
        System.out.println(getName() + " uses **Peck**!");
    }
    

    public void chirpDefend() {
        System.out.println(getName() + " uses **Chirp** to distract and defend!");
    }
}