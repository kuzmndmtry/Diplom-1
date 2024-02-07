package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    Database database = new Database();
    List<Ingredient> ingredients = database.availableIngredients();
    List<Bun> buns = database.availableBuns();

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        Bun bun = buns.get(0);
        burger.setBuns(bun);
        String expectedResult = bun.name;
        String actualResult = burger.bun.name;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = ingredients.get(0);
        burger.addIngredient(ingredient);
        String expectedResult = ingredient.name;
        String actualResult = burger.ingredients.get(0).name;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = ingredients.get(0);
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.indexOf(ingredient));
        int expectedResult = 0;
        int actualResult = burger.ingredients.size();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient_0 = ingredients.get(0);
        Ingredient ingredient_1 = ingredients.get(1);
        burger.addIngredient(ingredient_0);
        burger.addIngredient(ingredient_1);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient_0, burger.ingredients.get(1));
        Assert.assertEquals(ingredient_1, burger.ingredients.get(0));
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedResult = 300f;
        float actalResult = burger.getPrice();
        Assert.assertEquals(expectedResult, actalResult, 0);

    }

    @Test
    public void getReceipt() {
        String bunName = "bunName";
        float bunPrice = 10f;
        String ingredientName = "ingredientName";
        float ingredientPrice = 10f;
        IngredientType ingredientType = IngredientType.SAUCE;
        float burgerPrice = bunPrice * 2 + ingredientPrice;
        String expectedResult =
                "(==== " + bunName + " ====)\n" +
                        "= " + ingredientType.toString().toLowerCase() + " " + ingredientName + " =\n" +
                        "(==== " + bunName + " ====)\n" +
                        "\nPrice: " + String.format("%f", burgerPrice) + "\n";

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actualResult = burger.getReceipt();
        Assert.assertEquals(expectedResult, actualResult);
    }
}