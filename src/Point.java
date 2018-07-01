/**
 * Created by Yurii on 30.06.2018
 */
public class Point {
    private char name;
    private Coordinate coordinates;

    public Point(char name, Coordinate coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinate coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Point "+name+" "+coordinates;
    }
}
