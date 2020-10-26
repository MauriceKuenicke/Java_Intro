import java.io.File;

import edu.duke.FileResource;

public class App {
    public void runHello() {
        FileResource f;
        f = new FileResource("file.txt");
        for (String line : f.lines()) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        App hw = new App();
        hw.runHello();
    }

}