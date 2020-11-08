import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter(Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints(Shape s) {
        Integer number_of_points = 0;
        for (Point p : s.getPoints()) {
            number_of_points += 1;
        }
        return number_of_points;
    }

    public double getAverageLength(Shape s) {
        // Put code here
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

    public double getLargestX(Shape s) {
        // Put code here
        return 0.0;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double LargestPerimeter = 0;
        String FileWithLargestPeri = "None";
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            FileResource fr = new FileResource(file);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if (length > LargestPerimeter) {
                LargestPerimeter = length;
                FileWithLargestPeri = file.getName();
            }
        }
        System.out.println("\nPerimeterlength: " + LargestPerimeter);
        System.out.println(FileWithLargestPeri);

        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null; // replace this code
        return temp.getName();
    }

    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        Integer numberPoints = getNumPoints(s);
        double length = getPerimeter(s);
        double avg_len = getAverageLength(s);
        double largest_side = getLargestSide(s);
        System.out.println("Number of Points: " + numberPoints);
        System.out.println("Perimeter: " + length);
        System.out.println("Average Length: " + avg_len);
        System.out.println("Largest Side: " + largest_side);
    }

    public void testPerimeterMultipleFiles() {
        getLargestPerimeterMultipleFiles();
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle() {
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0, 0));
        triangle.addPoint(new Point(6, 0));
        triangle.addPoint(new Point(3, 6));
        for (Point p : triangle.getPoints()) {
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = " + peri);
    }

    // This method prints names of all files in a chosen folder that you can use to
    // test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main(String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.getLargestPerimeterMultipleFiles();
    }
}
