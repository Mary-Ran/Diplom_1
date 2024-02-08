package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    private String name;
    private float price;
    private final float DELTA = 0;
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);

    @Test
    public void getPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), DELTA);
    }

    @Test
    public void getName() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getType() {
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}