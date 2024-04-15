import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountItems {
Pattern milk = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
Pattern bread = Pattern.compile("bread", Pattern.CASE_INSENSITIVE);
Pattern cookies = Pattern.compile("c[o0][o0]kies", Pattern.CASE_INSENSITIVE);
Pattern apples = Pattern.compile("apples", Pattern.CASE_INSENSITIVE);

int milkCount;
int breadCount;
int cookiesCount;
int applesCount;
int nullCount;

int mp1;
int mp2;
int bp1;
int cp1;
int ap1;
int ap2;

    public CountItems() throws Exception {
    }

    public void countItems(ArrayList<GroceryItems> allItems) {
        double tempM = 0.0;
        double tempB = 0.0;
        double tempC = 0.0;
        double tempA = 0.0;
        for (int i = 0; i < allItems.size(); i++) {
            try {
                GroceryItems item = allItems.get(i);
                if (item.getPrice() != null ) {
                    Matcher milkMatcher = milk.matcher(item.getName());
                    while (milkMatcher.find()) {
                        milkCount++;
                        if (Double.parseDouble(item.getPrice()) < tempM) {
                            mp2++;
                        }
                        else {
                            mp1++;
                        }
                        tempM = Double.parseDouble(allItems.get(i).getPrice());
                    }
                    Matcher breadMatcher = bread.matcher(item.getName());
                    while (breadMatcher.find()) {
                        breadCount++;
                        if (Double.parseDouble(item.getPrice()) >= tempB) {
                            bp1++;
                        }
                        tempB = Double.parseDouble(allItems.get(i).getPrice());
                    }
                    Matcher cookiesMatcher = cookies.matcher(item.getName());
                    while (cookiesMatcher.find()) {
                        cookiesCount++;
                        if (Double.parseDouble(item.getPrice()) >= tempC) {
                            cp1++;
                        }
                        tempC = Double.parseDouble(allItems.get(i).getPrice());
                    }
                    Matcher applesMatcher = apples.matcher(item.getName());
                    while (applesMatcher.find()) {
                        applesCount++;
                        if (Double.parseDouble(item.getPrice()) < tempA) {
                            ap2++;
                        }
                        else {
                            ap1++;
                        }
                        tempA = Double.parseDouble(allItems.get(i).getPrice());
                    }
                }
                else {
                    nullCount ++;
                }
            }
            catch (NullPointerException e) {
                nullCount++;
            }
        }
    }

    @Override
    public String toString() {
        String outputString = String.format
                ("name:    Milk \t\t seen: %d times\n" +
                "============= \t \t =============\n" +
                "Price: \t 3.23\t\t seen: %d times\n" +
                "-------------\t\t -------------\n" +
                "Price:   1.23\t\t seen: %d time\n" +
                "\n" +
                "name:   Bread\t\t seen: %d times\n" +
                "=============\t\t =============\n" +
                "Price:   1.23\t\t seen: %d times\n" +
                "-------------\t\t -------------\n" +
                "\n" +
                "name: Cookies     \t seen: %d times\n" +
                "=============     \t =============\n" +
                "Price:   2.25        seen: %d times\n" +
                "-------------        -------------\n" +
                "\n" +
                "name:  Apples     \t seen: %d times\n" +
                "=============     \t =============\n" +
                "Price:   0.25     \t seen: %d times\n" +
                "-------------     \t -------------\n" +
                "Price:   0.23  \t \t seen: %d times\n" +
                "\n" +
                "Errors         \t \t seen: %d times",

                        milkCount,mp1, mp2, breadCount, bp1, cookiesCount, cp1, applesCount, ap1, ap2, nullCount);
        return outputString;
    }
}
