package BasicInfo;

/**
 * Event ticket class
 * Created by uestc on 9/29/2017.
 */
public class Ticket implements Comparable<Ticket> {
    private double price;

    /**
     * Constructs a ticket with an initial price
     * @param p the price of the ticket
     */
    public Ticket(double p) {
        price = p;
    }

    /**
     * Get the price of the ticket in dollar
     * @return the price of the ticket
     */
    public double get() {
        return price;
    }

    /**
     * Set the price of the ticket
     * @param p the price of the ticket
     */
    public void set(double p) {
        price = p;
    }
    @Override
    public int compareTo(Ticket other) {
        return (int)(price - other.price);
    }
}
