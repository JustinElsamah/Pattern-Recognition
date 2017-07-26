import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by justinelsemah on 2017-07-21.
 */
public class BruteCollinearPoints {

    private List<LineSegment> lineSegments;
    private int numOfLineSegments;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {

        lineSegments = new ArrayList<>();
        this.numOfLineSegments = 0;

        if (points == null) {
            throw new IllegalArgumentException();
        }
        for (int m = 0; m < points.length; m++) {
            if (points[m] == null) {
                throw new IllegalArgumentException();
            }
            for (int y = m + 1; y < points.length; y++) {
                if (points[m].slopeTo(points[y]) == Double.NEGATIVE_INFINITY) {
                    throw new IllegalArgumentException();
                }
            }
        }

        Arrays.sort(points);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                       if(points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]) && points[i].slopeTo(points[j]) == points[i].slopeTo(points[l])){
                           if(points[i].compareTo(points[j]) < 1 && points[j].compareTo(points[k]) < 1 && points[k].compareTo(points[l]) < 1) {
                               lineSegments.add(new LineSegment(points[i], points[l]));
                               numOfLineSegments++;
                           }
                       }
                    }
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return this.numOfLineSegments;
    }

    // the line segments
    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }
}
