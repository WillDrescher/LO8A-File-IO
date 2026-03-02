// Julia Kolomiitseva, Will Drescher
// Student Class
// The Student class represents a student with a name and a score.
// It implements Comparable so Student objects can be sorted.
// In this case, students are compared alphabetically by their name.
// The toString method formats the student’s name and score neatly for printing.

public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return String.format("%-15s %3d", name, score);
    }
}