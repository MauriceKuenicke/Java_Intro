import edu.duke.*;

public class PerimeterRunner {

    public double getPerimeter(Shape s) {
        // start with totalPerim = 0
        double totalPerim = 0;
        // start with prevPt = last point
        Point prevPoint = s.getLastPoint();
        // For each point currPt in the calc distance and update
        for (Point currPt : s.getPoints()) {
            double currDist = prevPoint.distance(currPt);
            totalPerim += currDist;
            prevPoint = currPt;
        }
        return totalPerim;
    }

    public Integer getNumPoints(Shape s) {
        Integer number_of_points = 0;
        for (Point p : s.getPoints()) {
            number_of_points += 1;
        }
        return number_of_points;
    }

    public double getAverageLength(Shape s) {
        double avg_len = getPerimeter(s) / getNumPoints(s);
        return avg_len;
    }

    public double getLargestSide(Shape s) {
        double currLongestDist = 0;
        Point prevPoint = s.getLastPoint();
        // For each point currPt in the calc distance and update
        for (Point currPt : s.getPoints()) {
            double currDist = prevPoint.distance(currPt);
            if (currDist > currLongestDist) {
                currLongestDist = currDist;
            }
        }
        return currLongestDist;
    }

    public void testPerimeter() {
        FileResource fr = new FileResource("example2.txt");
        Shape s = new Shape(fr);
        Integer numberPoints = getNumPoints(s);
        double length = getPerimeter(s);
        double avg_len = getAverageLength(s);
        double largestSide = getLargestSide(s);
        System.out.println("\nThis shape is constructed by " + numberPoints + " points,");
        System.out.println(
                "has a perimeter of " + length + " and therefore an average length of " + avg_len + " per side.");
        System.out.println("The largest side is: " + largestSide);
    }

    public static void main(String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
