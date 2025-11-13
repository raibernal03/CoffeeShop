package logic.fileManager;

import logic.OrderManager;
import logic.menu.Item;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileManager {
    private static final DateTimeFormatter FILE_TS =
            DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");


    public static void checkOut(List<Item> cart, String name) {
        String fileName = FILE_TS.format(LocalDateTime.now())+".txt";
        String filePath = "src/main/receipts/" + fileName;
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Galileo's Coffee Shop 😸☕\n");
            bw.write("Customer Name: " + name + "\n");

            var count = cart.stream()
                            .count();
            bw.write(String.format("Items count: %d\n", count));
            for(Item item : cart) {
                bw.write(String.format("""
                        -------------------------
                        $%.2f - %s
                        """,item.cost(),item.description()));
            }
            var total = cart.stream()
                    .mapToDouble(Item::cost)
                    .sum();


            bw.write(String.format("""
                    -------------------------
                    Total cost: $%.2f
                    
                    """, total));
            bw.write("Thank You for Visiting Us? 😸☕🍵");
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
