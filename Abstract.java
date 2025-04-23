/* Implementation of abstraction using abstract class
abstract class Animal {
     abstract void makeSound();
     void sleep() {
         System.out.println("Sleeping...");
     }
 }

 class Dog extends Animal {
     @Override
     void makeSound() {
         System.out.println("Bark");
     }
 }

 public class Abstract {
     public static void main(String[] args) {
         Animal myDog = new Dog();
         myDog.makeSound();
         myDog.sleep();
     }
 }  */

// Implementation of abstraction using interface
interface Vehicle {
    void start();
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car starting...");
    }
}

public class Abstract {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start();
    }
}