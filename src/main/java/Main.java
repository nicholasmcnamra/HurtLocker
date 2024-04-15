import org.apache.commons.io.IOUtils;
import java.io.IOException;



public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        CountItems cI = new CountItems();
        GroceryItems groceryItems = new GroceryItems();

        groceryItems.itemsList();
        cI.countItems(groceryItems.allItems);
        System.out.println(cI);

    }
}
