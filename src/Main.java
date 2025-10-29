import Model.Student;
import Service.StudentService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n=== Student Management System (OOP) ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = input.nextLine();
                    System.out.print("Enter age: ");
                    int age = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter course: ");
                    String course = input.nextLine();
                    service.addStudent(new Student(0, name, age, course));
                    break;

                case 2:
                    for (Student s : service.getAllStudents()) {
                        System.out.println("\nID: " + s.getId());
                        System.out.println("Name: " + s.getName());
                        System.out.println("Age: " + s.getAge());
                        System.out.println("Course: " + s.getCourse());
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter new course: ");
                    String newCourse = input.nextLine();
                    service.updateStudent(id, newCourse);
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = input.nextInt();
                    service.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.println(" Exiting program..");
                    return;

                default:
                    System.out.println(" Invalid choice!");
            }
        }
    }
}
