package top.jsoft.homework.task9;

import top.jsoft.commons.util.PrintManager;
import top.jsoft.homework.task9.model.Apple;
import top.jsoft.homework.task9.model.Container;
import top.jsoft.homework.task9.model.Orange;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class RunApp {

    public static void main(String[] args) {
        Container<Orange> orangeContainer = new Container<>();
        orangeContainer.add(new Orange());
        orangeContainer.add(new Orange());
        orangeContainer.addAll(new Orange(), new Orange());
//        orangeContainer.addAll(new Orange(), new Orange(), new Apple()); // error
//        orangeContainer.add(new Apple()); // error

        PrintManager.info("Orange weight: " + orangeContainer.getWeight());

        Container<Apple> appleContainer = new Container<>();
        appleContainer.add(new Apple());
        appleContainer.add(new Apple());
        appleContainer.addAll(new Apple(), new Apple(), new Apple());
//        appleContainer.addAll(new Apple(), new Apple(), new Orange()); // error
//        appleContainer.add(new Apple()); // error

        PrintManager.info("Apple weight: " + appleContainer.getWeight());

        // Compare
        PrintManager.info("Compare: " + orangeContainer.compare(appleContainer.getWeight()));

        Container<Apple> appleContainer1 = new Container<>();
        appleContainer1.addAll(new Apple(), new Apple());
        appleContainer.merge(appleContainer1);

        PrintManager.info("Apple weight after merge: " + appleContainer.getWeight());
    }
}
