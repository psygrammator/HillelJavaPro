package top.jsoft.homework.multithreading2;

import top.jsoft.commons.util.PrintManager;
import top.jsoft.commons.util.Rnd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class PetrolStation {
    private static final AtomicInteger amount = new AtomicInteger(1000);
    private static final int THREAD_POOL_SIZE = 3;
    private static final int MIN_DELAY = 3000;
    private static final int MAX_DELAY = 10000;
    private static final int MIN_REFILL = 10;
    private static final int MAX_REFILL = 50;

    private static final int MINIMAL_FUEL_AMOUNT = MAX_REFILL * (THREAD_POOL_SIZE + 1);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        IntStream.range(0, THREAD_POOL_SIZE).forEach(i ->
                executorService.submit(() -> {
                    while (amount.get() >= MINIMAL_FUEL_AMOUNT) {
                        int delay = Rnd.get(MIN_DELAY, MAX_DELAY);
                        int fuelAmount = Rnd.get(MIN_REFILL, MAX_REFILL);
                        PrintManager.info("ID: " + i + " delay: " + delay + " fuelAmount: " + fuelAmount + " start fuel to car");
                        try {
                            Thread.sleep(delay);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        doRefuel(fuelAmount);
                        PrintManager.info("ID: " + i + " delay=" + delay + ", fuelAmount=" + fuelAmount + " end fuel to car [after amount: " + amount.get() + "]");
                    }
                }));
        executorService.shutdown();
    }

    public static void doRefuel(int refillAmount) {
        amount.addAndGet(-1 * refillAmount);
    }
}