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

    public void testPerimeter() {
        FileResource fr = new FileResource("example2.txt");
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }

    public static void main(String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
