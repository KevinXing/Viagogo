package BasicInfo;
import java.util.*;

/**
 * Location class, which may contains some events
 * Created by uestc on 9/29/2017.
 */
public class Location {
    private Coord coord;
    private HashMap<Integer, Event> events;

    /**
     * Constructs a new Location
     * @param i x coordinate
     * @param j y coordinate
     */
    public Location(int i, int j) {
        coord = new Coord(i, j);
        events = new HashMap<Integer, Event>();
    }

    /**
     * Update the coordinate of the location
     * @param i x coordinate
     * @param j y coordinate
     */
    public void setCoord(int i, int j) {
        coord.set(i, j);
    }

    /**
     * Get the coordinate of the location
     * @return the coordinate of the location
     */
    public Coord getCoord() {
        return coord;
    }

    /**
     * Return the number of events the location has
     * @return the number of events
     */
    public int eventsNum() {
        return events.size();
    }

    /**
     * Add a new event to the location
     * @param e new event
     */
    public void addEvent(Event e) {
        events.put(e.getId(), e);
    }

    /**
     * Get a event with an event id
     * @param id event id
     * @return event, or null if not exist
     */
    public Event getEvent(int id) {
        if (events.containsKey(id)) {
            return events.get(id);
        } else {
            return null;
        }
    }

    /**
     * Get a list of events' id
     * @return an ArrayList which contains the id of all the events, or null if no events
     */
    public ArrayList<Integer> getEventsList() {
        if (eventsNum() == 0) {
            return null;
        }
        return new ArrayList<Integer>(events.keySet());
    }
}
