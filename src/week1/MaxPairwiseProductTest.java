package week1;


import org.junit.Assert;
import org.junit.Test;

public class MaxPairwiseProductTest {

    @Test
    public void getMaxPairwiseProduct() {
        long expected = 9_000_000_000L;
        int[] input = {100_000, 90_000};
        long actual = MaxPairwiseProduct.getMaxPairwiseProduct(input);
        Assert.assertEquals(expected, actual);

    }
}