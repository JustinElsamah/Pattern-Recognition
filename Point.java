import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

/**
 * Created by justinelsemah on 2017-07-21.
 */

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public double slopeTo(Point that) {
        if(this.y == that.y && this.x != that.x){
            return 0.0;
        }
        if(this.y != that.y && this.x == that.x){
            return Double.POSITIVE_INFINITY;
        }
        if(this.y == that.y){
            return Double.NEGATIVE_INFINITY;
        }
        return ((double)(that.y-this.y)/(that.x-this.x));

    }

    public int compareTo(Point that) {
        if(this.y < that.y) return -1;
        if(this.y > that.y) return 1;
        if(this.x < that.x) return -1;
        if(this.x > that.x) return 1;
        return 0;
    }

    public Comparator<Point> slopeOrder() {
        return new Point.PointsComparator(this);
    }

    // inner class implements comparator
    private static class PointsComparator implements Comparator<Point>{
        private Point point;

        private PointsComparator(Point point){
            this.point = point;
        }

        @Override
        public int compare(Point point1, Point point2) {
            if(point.slopeTo(point1) - point.slopeTo(point2) < 0) return -1;
            if(point.slopeTo(point1) - point.slopeTo(point2) > 0) return 1;
            return 0;
        }
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}