package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    public String name;
    public float price;
    Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getNameAndPrice() {
        return new Object[][] {
                {"Булочка", 13.5f},
                {"", -14.2f},
                {null, 0},
                {"Я Булочка Я Булочка Я Булочка Я Булочка Я Булочка Я Булочка Я Булочка Я Булочка", Float.MIN_VALUE},
                {".%Булочка?!", Float.MAX_VALUE}
        };
    }

    @Test
    public void getName() {
        bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPrice() {
        bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(),0);
    }
}