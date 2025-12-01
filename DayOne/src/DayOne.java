import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayOne {

    public static void main(String[] args) {
        int start = 50;
        int countOne = 0;
        int countTwo = 0;

        try {
            Scanner scanner = new Scanner(new File("./src/rotations.txt"));

            while (scanner.hasNextLine()) {
                String rotation = scanner.nextLine();
                int turns = Integer.parseInt(rotation.substring(1));
                String direction = rotation.substring(0, 1);
                int current = 0;

                while (current < turns) {
                    current++;
                    if (direction.equals("L")) {
                        start--;

                        if (start < 0) {
                            start = 99;
                            continue;
                        }
                    }

                    if (direction.equals("R")) {
                        start++;
                        if (start > 99) {
                            start = 0;
                            countTwo++;
                            continue;
                        }
                    }

                    if (start == 0) {
                        countTwo++;
                    }
                }

                if(start == 0) {
                    countOne++;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(countOne);
        System.out.println(countTwo);
    }
}

