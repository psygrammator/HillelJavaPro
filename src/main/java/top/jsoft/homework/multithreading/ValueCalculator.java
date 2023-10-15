package top.jsoft.homework.multithreading;

import top.jsoft.commons.util.PrintManager;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class ValueCalculator {
    private final float[] array = new float[1000000];
    private final int arraySize = array.length;
    private final int arrayHalfSize = arraySize / 2;

    public void start()
    {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arraySize; i++) {
            array[i] = 1;
        }
        float[] a1 = new float[arrayHalfSize];
        float[] a2 = new float[arrayHalfSize];

        System.arraycopy(array, 0, a1, 0, arrayHalfSize);
        System.arraycopy(array, arrayHalfSize, a2, 0, arrayHalfSize);

        new Thread(() -> arrayRecalc(a1)).start();
        new Thread(() -> arrayRecalc(a2)).start();

        System.arraycopy(a1, 0, array, 0, arrayHalfSize);
        System.arraycopy(a2, 0, array, arrayHalfSize, arrayHalfSize);

        PrintManager.info("Time millis: " + (System.currentTimeMillis() - start));
    }

    private void arrayRecalc(float[] array)
    {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void main(String[] args) {
        ValueCalculator valueCalculator = new ValueCalculator();
        valueCalculator.start();
    }
}
