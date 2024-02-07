package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    private final String testIngredientName = "hot sauce";
    private final float testIngredientPrice = 100;
    private final IngredientType testIngredientType = IngredientType.SAUCE;
    @Spy
    private Ingredient ingredient = new Ingredient(testIngredientType, testIngredientName, testIngredientPrice);

    @Test
    public void getPrice() {
        float expectedResult = testIngredientPrice;
        float actualResult = ingredient.getPrice();
        assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void getName() {
        String expectedResult = testIngredientName;
        String actualResult = ingredient.getName();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getType() {
        IngredientType expectedResult = testIngredientType;
        IngredientType actualResult = ingredient.getType();
        assertEquals(expectedResult, actualResult);
    }
}