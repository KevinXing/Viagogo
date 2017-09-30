package BasicInfo;
import java.util.*;

/**
 * A class for Coordinate (x, y)
 * Created by uestc on 9/29/2017.
 */
public class Coord {
    private int x, y;

    /**
     * Constructs a new coordinate with x and y coordinates
     * @param i x coordinate
     * @param j y coordinate
     */
    public Coord(int i, int j) {
        x = i;
        y = j;
    }

    /**
     * Set the x and y coordinates
     * @param i x coordinate
     * @param j y coordinate
     */
    public void set(int i, int j) {
        x = i;
        y = j;
    }

    /**
     * Get x coordinate
     * @return x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Get y coordinate
     * @return y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Calculates the manhattan distance between the coordinate with the other coordinate
     * @param p the other coordinate
     * @return the manhattan distance
     */
    public int disTo(Coord p) {
        return Math.abs(x - p.x) + Math.abs(y - p.y);
    }
    @Override
    public String toString() {
        return x + "," + y;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Coord)) {
            return false;
        }
        Coord coord = (Coord)o;
        return x == coord.x && y == coord.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
