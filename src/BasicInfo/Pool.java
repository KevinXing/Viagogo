package BasicInfo;
import java.util.*;

/**
 * A pool which contains all the locations
 * Created by uestc on 9/29/2017.
 */
public class Pool {
    private HashMap<Coord, Location> locations;
    private final int UBOUND = 10, LBOUND = -10;

    /**
     * Construct a new pool
     */
    public Pool() {
        locations = new HashMap<Coord, Location>();
    }

    /**
     * Return the number of locations in the pool
     * @return the number of locations
     */
    public int locationsNum() {
        return locations.size();
    }

    /**
     * Get a Location object by a coordinate
     * @param pos location coordinate
     * @return Location object, or null if not exists
     */
    public Location getLocation(Coord pos) {
        if (!locations.containsKey(pos)) {
            return null;
        }
        return locations.get(pos);
    }

    /**
     * Get a list which contains all the coordinates of locations in the pool
     * @return a list of all the coordinates of locations, or null if no locations in the pool
     */
    public ArrayList<Coord> getLocationsList() {
        if (locationsNum() == 0) {
            return null;
        }
        ArrayList<Coord> res = new ArrayList<Coord>(locations.keySet());
        return res;
    }

    /**
     * Add a new ticket into the pool
     * @param args the length must be 4, args[0]: x coordinate, args[1]: y coordinate, args[2]: event id, args[3]: ticket price in dollar
     */
    public void addItem(String[] args) {
        int x, y, id;
        double price;
        try {
            x = Integer.parseInt(args[0]);
            y = Integer.parseInt(args[1]);
            id = Integer.parseInt(args[2]);
            price = Double.parseDouble(args[3]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }
        if (x > UBOUND || x < LBOUND || y > UBOUND || y < LBOUND) return;
        Coord pos = new Coord(x, y);
        Location loc = null;
        if (locations.containsKey(pos)) {
            loc = locations.get(pos);
        } else {
            loc = new Location(x, y);
            locations.put(loc.getCoord(), loc);
        }
        Event event = loc.getEvent(id);
        if (event == null) {
            event = new Event(id, loc.getCoord());
            loc.addEvent(event);
        }
        Ticket t = new Ticket(price);
        event.addTicket(t);
    }
}
