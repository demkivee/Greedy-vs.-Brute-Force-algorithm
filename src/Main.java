import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Yurii on 30.06.2018
 */
public class Main {

    public Main() {
        List<Point> points = new ArrayList<>();
        getCoordinates(points);
        //Starting with random point
        Point startPoint = getInintialPoint(points);

        System.out.println("Brute force algorithm takes some time to give the result");
        //Greedy Algorithm
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm(points, startPoint);

        //Brute Force Algorithm
        BruteForceAlgorithm bruteForceAlgorithm = new BruteForceAlgorithm(points);

        System.out.println("\nTotal greedy algorithm length = "+greedyAlgorithm.pathLength
                +" for path "+greedyAlgorithm.pathName.toString());
        System.out.println("\nTotal brute force algorithm length = "+bruteForceAlgorithm.shortestLength
                +" for path "+bruteForceAlgorithm.pathName);
    }

    //Fill the points with random coordinates within (-10,10)
    private void getCoordinates(List<Point> points) {
        Random ran = new Random();
//        for (int i = 0; i < 20; i++) {
        for (int i = 0; i < 20; i++) {
            points.add(new Point(
                    (char) ('A' + i),
                    new Coordinate(ran.nextInt(20) - 10, ran.nextInt(20) - 10))
            );
        }
    }

    private Point getInintialPoint(List<Point> points) {
        return points.get((int) (Math.random() * points.size()));
    }

    public static void main(String[] args) {
        new Main();
    }
}
