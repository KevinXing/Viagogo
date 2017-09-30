/**
 * Created by uestc on 9/29/2017.
 */

import BasicInfo.Event;
import BasicInfo.Pool;
import Query.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    private static final int UBOUND = 10, LBOUND = -10;

    static public String usage() {
        return "Usage: Test seed_num, coord_x, coord_y;\n" +
                "seed_num: the number of seeds\n" +
                "coord_x, coord_y: the coordinate of the input position[-10,10]";
    }
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.out.println(usage());
        }
        int N, x, y;
        int maxPrice = 10000;
        try {
            N = Integer.parseInt(args[0]);
            x = Integer.parseInt(args[1]);
            y = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println(usage());
            e.printStackTrace();
            return;
        }
        if (x > UBOUND || x < LBOUND || y > UBOUND || y < LBOUND) {
            System.out.println(usage());
            return;
        }
        /**
         * Generate the data.txt file contains N random items.
         */
        try {
            PrintWriter writer = new PrintWriter("data.txt", "UTF-8");
            Random r = new Random();
            for (int i = 0; i < N; i++) {
                int xx = r.nextInt(21) - 10;
                int yy = r.nextInt(21) - 10;
                double price = r.nextDouble() * maxPrice;
                writer.print("" + xx + "," +  yy + "," + i + "," + String.format("%.2f", price) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Pool pool = new Pool();
        ArrayList<String[]> list = new ArrayList<String[]>();

        /**
         * Read the data.txt file, and add new items into the pool
         */
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        try {
            String line = br.readLine();
            while (line != null) {
                String[] a = line.split(",");
                if (a.length == 4) {
                    list.add(a);
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        for (String[] a : list) {
            pool.addItem(a);
        }
        /**
         * Add create an EventQuery
         */
        EventQuery eq = new EventQuery(x, y);
        /**
         * Query
         */
        List<Event> resList = eq.showNearestN(pool);
        if (resList == null) return;
        for (Event e : resList) {
            System.out.printf("Event %03d - $%.2f, Distance %d\n", e.getId(), e.getCheapestTicket(), e.getCoord().disTo(eq.getPos()));
        }
    }
}
