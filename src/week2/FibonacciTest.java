package week2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FibonacciTest {

    boolean isRunning = true;

    @Test
    public void calcFibStressTest() {
        int duration = 30;
        isRunning = true;
        new Timer().schedule(new TimerTask() {
                                 @Override
                                 public void run() {
                                     isRunning = false;
                                 }
        }, TimeUnit.SECONDS.toMillis(duration));

        while (isRunning) {
            int random = ThreadLocalRandom.current().nextInt(10);
            long fibNaiv = Fibonacci.calcFibNaive(random);
            long fibFast = Fibonacci.calcFibFast(random);
            System.out.println(String.format("input=%d, fibNaive=%d, fibFast=%d", random, fibNaiv, fibFast));
            if (fibNaiv != fibFast) {
                System.out.println("ERROR");
                break;
            }
            System.out.println("OK");
        }

        System.out.println(String.format("=========== Stress Test '%d' sec is Passed =======", duration));
        Assert.assertFalse(isRunning);
    }

    @Test
    public void calcFibLastDigitStressTest() {
        final int duration = 30;
        isRunning = true;
        new Timer().schedule(new TimerTask() {
                                 @Override
                                 public void run() {
                                     isRunning = false;
                                 }
        }, TimeUnit.SECONDS.toMillis(30));

        while (isRunning) {
            int random = ThreadLocalRandom.current().nextInt(10);
            long expected = Fibonacci.calcFibFast(random) % 10;
            long actual = FibonacciLastDigit.getFibonacciLastDigitNaive(random);
            System.out.println(String.format("input=%d, fibExpected=%d, fibActual=%d", random, expected, actual));
            if (expected != actual) {
                System.out.println("ERROR");
                break;
            }
            System.out.println("OK");
        }

        System.out.println(String.format("=========== Stress Test '%d' sec is Passed =======", duration));
        Assert.assertFalse(isRunning);
    }

}