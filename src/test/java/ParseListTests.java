import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
    public void lineToArrTest() throws Exception {
        GroceryItems groceryItems = new GroceryItems();

        groceryItems.itemsList();

        for (GroceryItems item : groceryItems.allItems) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void countTest() throws Exception {
        CountItems countItems = new CountItems();
        GroceryItems groceryItems = new GroceryItems();

        groceryItems.itemsList();
        countItems.countItems(groceryItems.allItems);
        Assert.assertEquals(8, countItems.milkCount);
        Assert.assertEquals(6, countItems.breadCount);
        Assert.assertEquals(7, countItems.cookiesCount);
        Assert.assertEquals(4, countItems.applesCount);
    }

    @Test
    public void toStringTest() throws Exception {
        CountItems countItems = new CountItems();
        GroceryItems groceryItems = new GroceryItems();

        groceryItems.itemsList();
        countItems.countItems(groceryItems.allItems);
        System.out.println(countItems);
    }
}
