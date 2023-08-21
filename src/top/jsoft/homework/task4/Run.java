package top.jsoft.homework.task4;

import top.jsoft.homework.task4.actor.Animal;
import top.jsoft.homework.task4.actor.Cat;
import top.jsoft.homework.task4.actor.Dog;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class Run {
    public static void main(String[] args) {
        // Running
        System.out.println("Running...");
        final Cat catRun = new Cat();
        final Dog dogRun = new Dog();

        catRun.run(200);
        dogRun.run(500);

        // Swimming
        System.out.println("Swimming...");
        final Cat catSwim = new Cat();
        final Dog dogSwim = new Dog();

        catSwim.swim();
        dogSwim.swim(10);

        // Total animals
        System.out.println(System.lineSeparator());
        System.out.println("Total animals: " + Animal.getAnimalsCount());
    }
}
