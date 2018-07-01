import java.util.*;

/**
 * Created by Yurii on 30.06.2018
 */
public class GreedyAlgorithm {
    double pathLength;
    Point finalPoint;
    StringBuilder pathName = new StringBuilder();

    public GreedyAlgorithm(List<Point> originalPoints, Point initialPoint) {
        List<Point> points = new ArrayList<>();
        points.addAll(originalPoints);
        getRoute(points, initialPoint);
        //return to the first point
        pathLength += getDistance(finalPoint.getCoordinates(), initialPoint.getCoordinates());
    }

    private void getRoute(List<Point> points, Point point) {
        if (points.size() > 1) {
            pathName.append(point.getName());
            point = getClosestPoint(points, point);

            getRoute(points, point);
        } else {
            pathName.append(point.getName());
            finalPoint = point;
        }
    }

    private Point getClosestPoint(List<Point> points, Point point) {
        //remove a point that is already visited
        points.remove(point);
        //calculating the shortest distance
        Point closestPoint =
                points.stream().min((point1, point2) -> {
                            int flag = 0;
                            if (getDistance(point1.getCoordinates(), point.getCoordinates()) <
                                    getDistance(point2.getCoordinates(), point.getCoordinates())) flag = -1;
                            else if (getDistance(point1.getCoordinates(), point.getCoordinates()) >
                                    getDistance(point2.getCoordinates(), point.getCoordinates())) flag = 1;
                            return flag;
                        }

                ).get();

        pathLength += getDistance(point.getCoordinates(), closestPoint.getCoordinates());
        return closestPoint;
    }


    //Euclidean distance
    private double getDistance(Coordinate a, Coordinate b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }
}
