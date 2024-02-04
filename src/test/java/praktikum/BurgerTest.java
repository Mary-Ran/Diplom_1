package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

public class BurgerTest {
    private Burger burger;
    private List<Ingredient> ingredients;
    Ingredient firstIngredient = mock(Ingredient.class);
    Ingredient secondIngredient = mock(Ingredient.class);
    Ingredient thirdIngredient = mock(Ingredient.class);
    Bun bun = mock(Bun.class);

    @Before
    public void setup() {
        burger = new Burger();
        ingredients = new ArrayList<>();
        burger.ingredients = ingredients;
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(firstIngredient);
        Assert.assertEquals(1, ingredients.size());
    }

    @Test
    public void removeIngredient() {
        ingredients.add(firstIngredient);
        burger.removeIngredient(0);
        Assert.assertTrue(ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        ingredients.add(firstIngredient);
        ingredients.add(secondIngredient);
        ingredients.add(thirdIngredient);
        burger.moveIngredient(1, 2);
        List<Ingredient> expectedIngredientsList = Arrays.asList(firstIngredient, thirdIngredient, secondIngredient);
        Assert.assertEquals(expectedIngredientsList, ingredients);
    }

    @Test
    public void getPrice() {
        ingredients.add(firstIngredient);
        ingredients.add(secondIngredient);
        burger.bun = bun;
        Mockito.when(bun.getPrice()).thenReturn(5.5f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(3.3f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(16.7f);
        Assert.assertEquals(31.0f, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        ingredients.add(firstIngredient);
        ingredients.add(secondIngredient);
        burger.bun = bun;
        Mockito.when(bun.getName()).thenReturn("Булочка");
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(firstIngredient.getName()).thenReturn("Сырный");
        Mockito.when(secondIngredient.getName()).thenReturn("Котлета");
        Mockito.when(burger.getPrice()).thenReturn(153.3f);
        String expectedReceipt =
                String.format("(==== Булочка ====)%n") +
                String.format("= sauce Сырный =%n") +
                String.format("= filling Котлета =%n") +
                String.format("(==== Булочка ====)%n") +
                String.format("%nPrice: %f%n", 153.3f);
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}