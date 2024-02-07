package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String ingredientTypeTest;

    public IngredientTypeTest(String ingredientTypeTest) {
        this.ingredientTypeTest = ingredientTypeTest;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTypeTest() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void ingredientTypeValueOf() {
        String expectedResult = ingredientTypeTest;
        String actualResult = String.valueOf(IngredientType.valueOf(ingredientTypeTest));
        Assert.assertEquals(actualResult, expectedResult);
    }
}