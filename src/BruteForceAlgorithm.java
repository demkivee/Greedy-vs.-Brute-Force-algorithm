import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yurii on 30.06.2018
 */
public class BruteForceAlgorithm {
    //set the length initially to maximum, so the first path becomes the shortest
    double shortestLength = Double.MAX_VALUE;
    private int originalSize;
    String pathName;
    private List<Point> shortestPath = new ArrayList<>();


    public BruteForceAlgorithm(List<Point> originalPoints) {
        shortestPath.addAll(originalPoints);
        originalSize = shortestPath.size();
        calculateLength(shortestPath);
        //getting the path of all possible paths to take
        List<List<Point>> allPermutations = listPermutations(shortestPath);
        //Finding the shortest one
        for (List<Point> path :
                allPermutations) {
            calculateLength(path);
        }
    }

    private static List<List<Point>> listPermutations(List<Point> path) {
        
        if (path.size() == 0) {
            List<List<Point>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Point>> allPermutations = new ArrayList<>();
        Point currentPoint = path.remove(0);

        List<List<Point>> recursiveReturn = listPermutations(path);
        for (List<Point> tmpPath : recursiveReturn) {

            for (int i = 0; i <= tmpPath.size(); i++) {
                List<Point> tmpList = new ArrayList<>(tmpPath);
                tmpList.add(i, currentPoint);
                allPermutations.add(tmpList);
            }

        }
        return allPermutations;
    }

    private void calculateLength(List<Point> pathToCheck) {
        double currentLength = 0;
        StringBuilder pathName = new StringBuilder();
        int pathSize = pathToCheck.size();
        for (int i = 0; i < pathSize; i++) {
            currentLength += getDistance(pathToCheck.get(i % pathSize).getCoordinates(),
                    pathToCheck.get((i + 1) % pathSize).getCoordinates());
            pathName.append(pathToCheck.get(i).getName());
        }
        //If the length of the current path is shorter than all the previous ones - it becomes the shortest path
        if (currentLength < shortestLength) {
            changeShortestPath(pathToCheck, currentLength, pathName.toString());
        }
    }

    private void changeShortestPath(List<Point> path, double length, String pathName) {
        shortestLength = length;
        shortestPath = path;
        this.pathName = pathName;
    }

    //Euclidean distance
    private double getDistance(Coordinate a, Coordinate b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }
}
