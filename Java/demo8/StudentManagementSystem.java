package demo8;
import java.util.Arrays;
import java.util.Scanner;

public class StudentManagementSystem {
    private static final int MAX_STUDENTS = 100;
    private Student[] students;
    private int studentCount;

    public StudentManagementSystem() {
        students = new Student[MAX_STUDENTS];
        studentCount = 0;
    }

    public void addStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Reached maximum number of students.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student details:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Date of Birth: ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("GPA: ");
        double gpa = scanner.nextDouble();

        Student student = new Student(id, name, dateOfBirth, address, gpa);
        students[studentCount] = student;
        studentCount++;

        System.out.println("Student added successfully.");
    }

    public void editStudentById() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to edit: ");
        int id = scanner.nextInt();

        int index = findStudentIndexById(id);
        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }

        Student student = students[index];

        System.out.println("Enter new student details:");
        System.out.print("Name: ");
        scanner.nextLine(); //
        String name = scanner.nextLine();

        System.out.print("Date of Birth: ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("GPA: ");
        double gpa = scanner.nextDouble();

        student.setName(name);
        student.setDateOfBirth(dateOfBirth);
        student.setAddress(address);
        student.setGpa(gpa);

        System.out.println("Student information updated successfully.");
    }

    public void deleteStudentById() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();

        int index = findStudentIndexById(id);
        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }

        for (int i = index; i < studentCount - 1; i++) {
            students[i] = students[i + 1];
        }

        students[studentCount - 1] = null;
        studentCount--;

        System.out.println("Student deleted successfully.");
    }

    public void sortStudentsByGpa() {
        Arrays.sort(students, 0, studentCount, (s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
        System.out.println("Students sorted by GPA.");
        displayStudents();
    }

    public void sortStudentsByName() {
        Arrays.sort(students, 0, studentCount, (s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
        System.out.println("Students sorted by name.");
        displayStudents();
    }

    public void displayStudents() {
        if (studentCount == 0) {
            System.out.println("No students to display.");
            return;
        }

        System.out.println("List of students:");
        for (int i = 0; i < studentCount; i++) {
            Student student = students[i];
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Date of Birth: " + student.getDateOfBirth());
            System.out.println("Address: " + student.getAddress());
            System.out.println("GPA: " + student.getGpa());
            System.out.println("-------------------------");
        }
    }

    private int findStudentIndexById(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

}