package top.jsoft.homework.task3;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class Car {
    public static void start()
    {
        System.out.println("Start the Car.");
        startElectricity();
        startCommand();
        startFuelSystem();
    }
    private static void startElectricity()
    {
        System.out.println("startElectricity");
    }
    private static void startCommand()
    {
        System.out.println("startCommand");
    }
    private static void startFuelSystem()
    {
        System.out.println("startFuelSystem");
    }
}
