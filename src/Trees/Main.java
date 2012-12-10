package Trees;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        SpeedTest speed = new SpeedTest();
        for (int i = 0; i < 10; i++) {
            speed.addValues(10000);
            speed.searchValues(10000);
            speed.deleteValues(10000);
        }
        speed.testausValmis();
    }
}