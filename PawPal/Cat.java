public class Cat extends Pet {

    public Cat(String name) {
        super(name);
        setHealth(100);
        setStrength(15);
        setDefense(15);
        setSpeed(12);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow!");
    }

    public void scratch() {
        System.out.println(getName() + " is scratching!");
        setMood(getMood() + 3);
        setStrength(getStrength() + 1);
        System.out.println(getName() + "'s Strength increased by 10!");
    }
    
    
    public void catScratch() {
        System.out.println(getName() + " uses **Scratch Attack**!");
    }
    

    public void growl() {
        System.out.println(getName() + " uses **Growl** to fortify its position!");
    }
}