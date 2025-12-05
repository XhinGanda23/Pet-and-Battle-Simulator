public class Dog extends Pet {

    public Dog(String name) {
        super(name);
        setHealth(110);
        setStrength(20);
        setDefense(10);
        setSpeed(8);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof! Woof!");
    }

    public void fetch() {
        System.out.println(getName() + " is fetching the ball!");
        setEnergy(getEnergy() - 5);
        setMood(getMood() + 5);
        setSpeed(getSpeed() + 1);
        System.out.println(getName() + "'s Speed increased by 10!");
    }
    
    public void bite() {
        System.out.println(getName() + " uses **Bite**!");
    }
    
    public void bark() {
        System.out.println(getName() + " uses **Bark** to prepare for impact!");
    }
}