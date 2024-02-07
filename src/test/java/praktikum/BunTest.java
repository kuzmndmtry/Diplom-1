package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    private final String testBunName = "test bun";
    private final float testBunPrice = 10.00F;
    @Spy
    private Bun bun = new Bun(testBunName, testBunPrice);

    @Test
    public void getBunName() {
        String expectedResult = testBunName;
        String actualResult = bun.getName();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getBunPrice() {
        float expectedResult = testBunPrice;
        float actualResult = bun.getPrice();
        assertEquals(expectedResult, actualResult, 0);
    }
}