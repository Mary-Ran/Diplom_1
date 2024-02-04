package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    public String name;
    public float price;
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);
    @Test
    public void getPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 0);
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