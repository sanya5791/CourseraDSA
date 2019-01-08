package week2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class GCDTest {
    public static final int STRESS_TEST_DURATION = 30;
    boolean isRunning;

    @Before
    public void init() {
        isRunning = true;
    }

    @Test
//    @Ignore
    public void gcdStressTest() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                isRunning = false;
            }
        }, TimeUnit.SECONDS.toMillis(30));

        while (isRunning) {
            int randomA = ThreadLocalRandom.current().nextInt(1,1000);
            int randomB = ThreadLocalRandom.current().nextInt(1,1000);
            long expected = GCD.gcdNaive(randomA, randomB);
            long actual = GCD.gcdFast(randomA, randomB);;
            System.out.println(String.format("inputA=%d, inputB=%d, fibExpected=%d, fibActual=%d", randomA, randomB, expected, actual));
            if (expected != actual) {
                System.out.println("ERROR");
                return;
            }
            System.out.println("OK");
        }

        if(isRunning)
            System.out.println(String.format("=========== Stress Test '%d' sec is Passed =======", STRESS_TEST_DURATION));
        Assert.assertFalse(isRunning);

    }

    @Test
    public void gcdReturn_1() {
        int expected = 1;
        int a = 18;
        int b = 35;
        long actual = GCD.gcdFast(a, b);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void gcdReturn_17657() {
        int expected = 17657;
        int a = 28851538;
        int b = 1183019;
        long actual = GCD.gcdFast(a, b);
        Assert.assertEquals(expected, actual);
    }
}