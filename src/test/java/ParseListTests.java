import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;

public class ParseListTests {

    @Test
    public void viewListTest() throws Exception {
        GroceryItems groceryItems = new GroceryItems();
        Main main = new Main();
        String data = main.readRawDataToString();
        String[] lines = groceryItems.printAsList();
        for (String line : lines)
            System.out.println(line);
    }

    @Test
    public void countMilkTest() throws Exception {
        GroceryItems groceryItems = new GroceryItems();
        Main main = new Main();
        Assert.assertEquals(8, groceryItems.matchPatterns());
    }

    @Test
    public void lineToArrTest() throws Exception {
        GroceryItems groceryItems = new GroceryItems();

        groceryItems.itemsList();

        for (GroceryItems item : groceryItems.allItems) {
            System.out.println(item.toString());
        }
    }
}
