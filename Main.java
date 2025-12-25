/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectt;

import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student student = new Student("ahmedhanyahmed537@gmail.com", "kajcsu232", "Ahmed", "01055388910", 3);
        Teacher t = new Teacher("teacher1@school.edu", "Teach123", "Mr. Ahmed", 5000, "Math");
        Admin admin = new Admin("ahmed@gmail.com", "1234", "Ahmed mohamed");


        Array<Classroom> classrooms = new Array<>(2);
        Classroom c1 = new Classroom("1233", "Class 2A", "Grade 1");
        c1.addStudent(new Student("ali@school.edu", "Ali123", "Ali Mohamed", "01020304050", 50));
        c1.addStudent(new Student("sarah@school.edu", "Sarah123", "Sarah Ahmed", "01050505050", 30));
        c1.addStudent(new Student("omar@school.edu", "Omar123", "Omar Adel", "01060708090", 40));
        c1.addStudent(new Student("alaa@school.edu", "Alaa123", "Alaa Ali", "01122334455", 12));
        c1.addStudent(new Student("ahmed@school.edu", "Ahmed123", "Ahmed Ali", "01233445566", 9));
        c1.addStudent(new Student("mona@school.edu", "Mona123", "Mona Hassan", "01099887766", 35));
        c1.addStudent(new Student("youssef@school.edu", "Youssef123", "Youssef Samir", "01155667788", 45));
        c1.addStudent(new Student("nour@school.edu", "Nour123", "Nour Khaled", "01266778899", 28));
        c1.addStudent(new Student("hassan@school.edu", "Hassan123", "Hassan Mahmoud", "01033445566", 33));
        c1.addStudent(new Student("rana@school.edu", "Rana123", "Rana Adel", "01188990011", 26));

        Classroom c2 = new Classroom("1234", "Class 3B", "Grade 2");
        c2.addStudent(new Student("maha@school.edu", "Maha123", "Maha Ahmed", "01011223344", 40));
        c2.addStudent(new Student("sarahs@school.edu", "SarahS123", "Sarah Samy", "01055667788", 20));
        c2.addStudent(new Student("karim@school.edu", "Karim123", "Karim Adel", "01122335544", 38));
        c2.addStudent(new Student("nada@school.edu", "Nada123", "Nada Mohamed", "01233446655", 42));
        c2.addStudent(new Student("ziad@school.edu", "Ziad123", "Ziad Hassan", "01066554433", 31));
        c2.addStudent(new Student("salma@school.edu", "Salma123", "Salma Ahmed", "01177889900", 27));
        c2.addStudent(new Student("tarek@school.edu", "Tarek123", "Tarek Samir", "01255667788", 36));
        c2.addStudent(new Student("heba@school.edu", "Heba123", "Heba Fathy", "01099884422", 29));
        c2.addStudent(new Student("mostafa@school.edu", "Mostafa123", "Mostafa Ali", "01144556677", 41));
        c2.addStudent(new Student("aya@school.edu", "Aya123", "Aya Mahmoud", "01288990011", 34));

        classrooms.append(c1);
        classrooms.append(c2);
   

        boolean exitProgram = false;

        while (!exitProgram) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1: Student");
            System.out.println("2: Teacher");
            System.out.println("3: Admin");
            System.out.println("0: Exit");
            System.out.print("Choose your role: ");

            String roleInput = sc.nextLine().trim();

            switch (roleInput) {
                case "1": // Student
                    boolean studMenuFlag = true; 
                    do {
                        System.out.println("\n--- Student Menu ---");
                        System.out.println("1: View your profile information");
                        System.out.println("2: Open your timetable");
                        System.out.println("3: View your grades");
                        System.out.println("4: View subjects list");
                        System.out.println("0: Back to main menu");
                        System.out.print("Insert your choice: ");

                        try {
                            int choice = sc.nextInt();
                            sc.nextLine(); 
                            System.out.println("--------------------------------------");

                            switch (choice) {
                                case 1 -> student.viewProfileInfo();
                                case 2 -> student.openTimeTable();
                                case 3 -> student.viewGrades();
                                case 4 -> student.getSubjectsAssigned();
                                case 0 -> studMenuFlag = false;
                                default -> System.out.println(" Invalid choice (0 - 4 only)");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println(" Invalid input! Please enter a number.");
                            sc.nextLine();
                        }

                    } while (studMenuFlag);
                    break;

                case "2": // Teacher
                    t.showMenu(classrooms);
                    break;

                case "3": // Admin
                    boolean exitAdmin = false;
                    
                    do {
                        try {
                            System.out.println("\n--- Admin Menu ---");
                            System.out.println("1: Add student");
                            System.out.println("2: Add teacher");
                            System.out.println("3: Add subject");
                            System.out.println("4: Create timetable for student and add subjects");
                            System.out.println("5: Display all students");
                            System.out.println("6: Display all teachers");
                            System.out.println("7: Display all subjects");
                            System.out.println("8: Back to main menu");
                            System.out.print("Choice: ");

                            int choice = Integer.parseInt(sc.nextLine().trim());

                            switch (choice) {
                                case 1: // Add Student
                                    System.out.print("Enter student name: ");
                                    String name = sc.nextLine();
                                    System.out.print("Enter student email: ");
                                    String email = sc.nextLine();
                                    System.out.print("Enter password: ");
                                    String pass = sc.nextLine();
                                    System.out.print("Enter parent phone: ");
                                    String phone = sc.nextLine();
                                    System.out.print("Enter grade: ");
                                    int grade = Integer.parseInt(sc.nextLine());
                                    Student s = new Student(email, pass, name, phone, grade);
                                    admin.addStudent(s);
                                    System.out.println("Student added: " + s);
                                    break;

                                case 2: // Add Teacher
                                    System.out.print("Enter teacher name: ");
                                    String tName = sc.nextLine();
                                    System.out.print("Enter teacher email: ");
                                    String tEmail = sc.nextLine();
                                    System.out.print("Enter password: ");
                                    String tPass = sc.nextLine();
                                    System.out.print("Enter subject taught: ");
                                    String subject = sc.nextLine();
                                    System.out.print("Enter salary: ");
                                    double salary = Double.parseDouble(sc.nextLine());
                                    Teacher teacher = new Teacher(tEmail, tPass, tName, salary, subject);
                                    admin.addTeacher(teacher);
                                    System.out.println("Teacher added: " + teacher);
                                    break;

                                case 3: // Add Subject
                                    System.out.print("Enter subject id: ");
                                    String subjectId = sc.nextLine();
                                    System.out.print("Enter subject name: ");
                                    String subjectName = sc.nextLine();
                                    Subject sub = new Subject(subjectId, subjectName);
                                    admin.addSubject(sub);
                                    System.out.println("subject added: " + sub);
                                    break;

                                case 4: // Create Timetable
                                    System.out.print("Enter student ID: ");
                                    String stId = sc.nextLine();
                                    Student selectedStudent = admin.searchStudentById(stId);

                                    if (selectedStudent != null) {
                                        Timetable timetable = admin.getOrCreateTimetable(selectedStudent);
                                        System.out.println("Timetable ready for " + selectedStudent.getName());

                                        boolean addMore = true;
                                        while (addMore) {
                                            admin.displaySubjects();
                                            System.out.print("Enter subject ID to add: ");
                                            String subId = sc.nextLine();
                                            Subject subjectToAdd = admin.searchSubjectById(subId);

                                            if (subjectToAdd != null) {
                                                admin.addSubjectToTimetable(timetable, subjectToAdd);
                                                System.out.println("subject added: " + subjectToAdd.getSubjectName());
                                            } else {
                                                System.out.println("subject not found!");
                                            }

                                            System.out.print("Do you want to add another subject? (y/n): ");
                                            String answer = sc.nextLine().trim().toLowerCase();
                                            addMore = answer.equals("y");
                                        }

                                        System.out.println("Student Timetable:");
                                        admin.showStudentTimetable(timetable);

                                    } else {
                                        System.out.println("Student not found!");
                                    }
                                    break;

                                case 5:
                                    admin.displayStudents();
                                    break;
                                case 6:
                                    admin.displayTeachers();
                                    break;
                                case 7:
                                    admin.displaySubjects();
                                    break;
                                case 8:
                                    exitAdmin = true;
                                    break;
                                default:
                                    System.out.println("Invalid choice!");
                                    break;
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a valid number.");
                        } catch (Exception e) {
                            System.out.println("An error occurred: " + e.getMessage());
                        }

                    } while (!exitAdmin);
                    break;

                case "0":
                    System.out.println("Exiting program...");
                    exitProgram = true;
                    break;

                default:
                    System.out.println("Invalid choice! Enter 0-3.");
                    break;
            }
        }

        sc.close();
    }

}

