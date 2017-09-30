package BasicInfo;
import java.util.*;
/**
 * Event class, which may contain some tickets
 * Created by uestc on 9/29/2017.
 */
public class Event {
    private int id;
    private Coord coord;
    private PriorityQueue<Ticket> tickets;

    /**
     * Constructs a new event with an id
     * @param i event id
     * @param c coordinate of the event
     */
    public Event(int i, Coord c) {
        id = i;
        coord = c;
        tickets = new PriorityQueue<Ticket>();
    }

    /**
     * Get the event id
     * @return event id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the event id
     * @param i event id
     */
    public void setId(int i) {
        id = i;
    }

    /**
     * get coordinate of the event
     * @return Coord object
     */
    public Coord getCoord() {
        return coord;
    }

    /**
     * Return true if the event has tickets
     * @return ture if event contains tickets
     */
    public boolean hasTicket() {
        return tickets.size() != 0;
    }

    /**
     * Add a new ticket to the event
     * @param t new ticket
     */
    public void addTicket(Ticket t) {
        tickets.offer(t);
    }

    /**
     * Return the cheapest ticket of the event
     * @return the price of the cheapest ticket, or -1 if event hsa no ticket
     */
    public double getCheapestTicket() {
        if (hasTicket()) {
            return tickets.peek().get();
        } else {
            return -1;
        }
    }
}
