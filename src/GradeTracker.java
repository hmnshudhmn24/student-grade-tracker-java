import java.util.*;

class Student {
    String name;
    List<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    @Override
    public String toString() {
        return "Student: " + name + " | Grades: " + grades + " | Average: " + calculateAverage();
    }
}

public class GradeTracker {
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nStudent Grade Tracker");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. View Students");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> addGrade(scanner);
                case 3 -> viewStudents();
                case 4 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        students.add(new Student(name));
        System.out.println("Student added successfully!");
    }

    private static void addGrade(Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("No students available. Add a student first.");
            return;
        }
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.name.equalsIgnoreCase(name)) {
                System.out.print("Enter grade: ");
                int grade = scanner.nextInt();
                scanner.nextLine();
                student.addGrade(grade);
                System.out.println("Grade added successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students recorded.");
        } else {
            System.out.println("\nStudent List:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
