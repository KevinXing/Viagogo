package Query;
/**
 * Class contains a set of functions, which contains different queries
 * Created by uestc on 9/29/2017.
 */

import java.util.*;
import BasicInfo.*;

public class EventQuery {
    private int N;
    private Coord pos;
    private PriorityQueue<Event> pq;

    /**
     * Constructs a query object, with an input coordinate
     * @param x x coordinate
     * @param y y coordinate
     */
    public EventQuery(int x, int y) {
        N = 5;
        pos = new Coord(x, y);
        pq = new PriorityQueue<Event>(N, new Comparator<Event>() {
            public int compare(Event a, Event b) {
                int disA = a.getCoord().disTo(pos);
                int disB = b.getCoord().disTo(pos);
                if (disA != disB) {
                    return disB - disA;
                }
                if (a.getCheapestTicket() != b.getCheapestTicket()) {
                    return (a.getCheapestTicket() < b.getCheapestTicket()) ? 1 : -1;
                }
                return 0;
            }
        });
    }

    /**
     * Get the input position
     * @return Coord object of the position
     */
    public Coord getPos() {
        return pos;
    }

    /**
     * Get a list(max length 5) contains the closest events.
     * @param pool the events pool
     * @return list events, or null if no events in the pool
     */
    public List<Event> showNearestN(Pool pool) {
        System.out.printf("Closest Events to (%s):\n", pos.toString());
        ArrayList<Coord> locationsList = pool.getLocationsList();
        if (locationsList == null) {
            return null;
        }
        for (int i = 0; i < pool.locationsNum(); i++) {
            Location loc = pool.getLocation(locationsList.get(i));
            if (pq.size() == N && loc.getCoord().disTo(pos) > pq.peek().getCoord().disTo(pos)) {
                continue;
            }
            if (loc.eventsNum() == 0) {
                continue;
            }
            ArrayList<Integer> eventsList = loc.getEventsList();
            for (int j = 0; j < loc.eventsNum(); j++) {
                Event e = loc.getEvent(eventsList.get(j));
                if (!e.hasTicket()) {
                    continue;
                }
                pq.offer(e);
                if (pq.size() > N) {
                    pq.poll();
                }
            }
        }
        LinkedList<Event> res = new LinkedList<Event>();
        while (!pq.isEmpty()) {
            res.addFirst(pq.poll());
        }
        return res;
    }
}


