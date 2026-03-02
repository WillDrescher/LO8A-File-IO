import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Julia Kolomiitseva and Will Drescher
// The ScoreTrakker class reads student names and scores from text files,
// stores them in an ArrayList, and prints them in alphabetical order.
// It handles two types of errors: missing files and non-numeric scores.
// If a score is not a valid number, it prints an error message and continues.
// The main method runs the program by processing multiple files.
public class ScoreTrakker {

    private ArrayList<Student> students = new ArrayList<Student>();

    private String[] files = { "scores.txt", "badscore.txt", "nofile.txt" };

    public void loadDataFile(String filename) throws FileNotFoundException {

        students.clear();

        File file = new File(filename);
        Scanner in = new Scanner(file);

        String name = "";
        String scoreLine = "";

        while (in.hasNextLine()) {
            try {
                name = in.nextLine().trim();

                if (!in.hasNextLine()) {
                    break;
                }

                scoreLine = in.nextLine().trim();

                int score = Integer.parseInt(scoreLine);

                Student s = new Student(name, score);
                students.add(s);

            } catch (NumberFormatException e) {
                System.out.println("Non-numeric score for " + name + ": " + scoreLine);
            }
        }

        in.close();
    }

    public void printInOrder() {
        Collections.sort(students);
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println(); 
    }

    public void processFiles() {
        for (String filename : files) {
            try {
                System.out.println("Reading from file: " + filename);
                loadDataFile(filename);
                printInOrder();
            } catch (FileNotFoundException e) {
                System.out.println("Cannot find file " + filename);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ScoreTrakker tracker = new ScoreTrakker();
        tracker.processFiles();
    }
}