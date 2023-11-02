import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Basic {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/test"));

        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        String line = "";
        int maxLength = 0;

        while ((line = reader.readLine()) != null) {
            String[] array = line.split(" ");
            for (String world : array) {
                if (map.containsKey(world)) {
                    map.put(world, map.get(world) + 1);
                } else {
                    map.put(world, 1);
                }
                if (map.get(world) > maxLength) {
                    maxLength = map.get(world);
                }
            }
        }
        reader.close();

        for (String world : map.keySet()
        ) {
            System.out.println("key = " + world + " count = " + map.get(world));
        }

        System.out.print("Слово(а) с самым большим количеством повторений:");
        int i = 0;
        for (String world : map.keySet()) {
            if (map.get(world) == maxLength) {
                if (i > 0) {
                    System.out.print(",");
                }
                System.out.print(" \"" + world + "\"");
                i = i + 1;
            }
        }
        System.out.print(" встречается(ются) " + maxLength + " раз");
    }
}
