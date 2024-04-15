import com.fasterxml.jackson.databind.deser.DataFormatReaders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
public class GroceryItems{

    private String name;
    private String price;
    private String type;
    private String expiration;
    Main main = new Main();
    public String data = main.readRawDataToString();
    String[] items = data.split("##");
    ArrayList<GroceryItems> allItems= new ArrayList<>();

    public GroceryItems() throws Exception {
    }
    public GroceryItems(String name, String price, String type, String expiration) throws Exception {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }
    //get each line as an element in array
    public String[] printAsList() {
        return items;
    }

    //create object list
    public boolean itemsList() throws Exception {
        name = "";
        price = "";
        type = "";
        expiration = "";

        String propertySplitRegEx = "[;@^*%!]";
        String kvSplitRegEx = "[a-zA-Z]+:";
        Pattern colon = Pattern.compile(kvSplitRegEx);

        String group = "";

        for (String item : items) {
            String[] lineArray = item.split(propertySplitRegEx);
            GroceryItems groceryItem = new GroceryItems();
            for(String element : lineArray) {

                Matcher matcher = colon.matcher(element);
                while (matcher.find()) {
                    if (element.substring(0, matcher.end()).matches("\\bn...\\b+:")) {
                        name = element.substring(matcher.end()).trim();
                        groceryItem.setName(name);
                    }
                    if (element.substring(0, matcher.end()).matches("\\bp....\\b+:")) {
                        price = element.substring(matcher.end()).trim();
                        groceryItem.setPrice(price);
                    }
                    if (element.substring(0, matcher.end()).matches("\\bt...\\b+:")) {
                        type = element.substring(matcher.end()).trim();
                        groceryItem.setType(type);
                    }
                    if (element.substring(0, matcher.end()).matches("\\be.........\\b+:")) {
                        expiration = element.substring(matcher.end()).trim();
                        groceryItem.setExpiration(expiration);
                    }
                }
            }
            allItems.add(groceryItem);
        }
        return false;
    }

    public int matchPatterns() {
        String regEx = "\\bM..k\\b";
        Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(data);
        String group = "";
        int count = 0;

        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s\n%s\n%s\n", this.getName(), this.getPrice(), this.getType(), this.getExpiration());
    }
}


//main task is to parse through the RawData and return a count of each item
//at a specific price -- so if milk shows up 4 times and 2 have a price of $2 and
//the other two have a price of $3, it should look like this:

//name:    Milk 		 seen: 6 times
//============= 	 	 =============
//Price: 	 3.23		 seen: 5 times
//-------------		     -------------
//Price:   1.23		     seen: 1 time


//most key value pairs are separated by (;, @, ^, *, %, !)
//but there may be other symbols to look out for
//on one line naMe:;price:3.23;type:Food;expiration:1/04/2016
//naMe:MiLK;priCe:;type:Food;expiration:1/11/2016

//each object will be separated by a ##