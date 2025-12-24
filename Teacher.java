/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectt;


import java.util.Scanner;

public class Teacher extends Person {

    private double salary;
    private String subjectTaught;

    public Teacher(String email, String password, String name,double salary, String subjectTaught) {
        super(email, password, name);
        this.salary = salary;
        this.subjectTaught = subjectTaught;
        this.id = String.valueOf(TeacherIDGenerator.IDGenerator());
    }

    private int readInt(Scanner in) {
        while (true) {
            try {
                return Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a valid integer: ");
            }
        }
    }

    private double readGrade(Scanner in, int max) {
        while (true) {
            try {
                double grade = Double.parseDouble(in.nextLine().trim());

                if (grade < 0 || grade > max) {
                    System.out.print("Grade must be between 0 and " + max + ": ");
                } else {
                    return grade;
                }

            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Enter a number: ");
            }
        }
    }

    //Teacher Menu 
    public void showMenu(Array<Classroom> classrooms) {
        Scanner in = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Teacher Menu ---");
            System.out.println("1- Show Classrooms");
            System.out.println("0- Exit");
            System.out.print("Choice: ");

            choice = readInt(in);

            if (choice == 0) {
                break;
            }

            if (choice == 1) {
                displayClassrooms(classrooms);
                System.out.print("Enter Classroom ID: ");
                String classId = in.nextLine().trim();

                Classroom c = classrooms.searchById(classId);
                if (c == null) {
                    System.out.println("Classroom not found!");
                } else {
                    classroomMenu(c);
                }
            }

        } while (true);
    }

    private void displayClassrooms(Array<Classroom> classrooms) {
        System.out.println("\nAvailable Classrooms:");
        for (int i = 0; i < classrooms.getCount(); i++) {
            Classroom c = classrooms.get(i);
            System.out.println(c.getClassId() + " - "
                    + c.getClassName() + " - "
                    + c.getGrade());
        }
    }

    // Classroom Menu
    public void classroomMenu(Classroom c) {
        Scanner in = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Classroom: " + c.getClassName() + " ---");
            System.out.println("1- View Students");
            System.out.println("2- Take Attendance");
            System.out.println("3- Add Grades");
            System.out.println("4- View Student By ID");
            System.out.println("0- Back");
            System.out.print("Choice: ");

            choice = readInt(in);

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    c.displayStudents();
                    break;

                case 2:
                    takeAttendance(c);
                    break;

                case 3:
                    addGrades(c);
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    String sid = in.nextLine().trim();
                    Student s = c.getStudents().searchById(sid);
                    if (s == null) {
                        System.out.println("Student not found!");
                    } else {
                        System.out.println("\n--- Student Info ---");
                        System.out.println("ID: " + s.getId());
                        System.out.println("Name: " + s.getName());
                        System.out.println("Email: " + s.getEmail());
                        System.out.println("Parent Phone: "
                                + s.getParentPhoneNumber());
                    }
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (true);
    }

    //Attendance 
    public void takeAttendance(Classroom c) {
        Scanner in = new Scanner(System.in);
        SLL.Node<Student> temp = c.getStudents().getHead();

        System.out.println("\n--- Taking Attendance for "
                + c.getClassName() + " ---");

        while (temp != null) {
            Student s = temp.data;

            while (true) {
                System.out.print("Is " + s.getName() + " present? (y/n): ");
                String input = in.nextLine().trim().toLowerCase();

                if (input.equals("y")) {
                    break;
                }
                if (input.equals("n")) {
                    s.setAbsences(s.getAbsences() + 1);
                    break;
                }
                System.out.println("Invalid input! Enter y or n.");
            }

            temp = temp.next;
        }

        displayAbsencePercentage(c);
    }

    public void displayAbsencePercentage(Classroom c) {
        SLL.Node<Student> temp = c.getStudents().getHead();
        int totalAbsences = 0;
        int totalStudents = 0;

        while (temp != null) {
            totalAbsences += temp.data.getAbsences();
            totalStudents++;
            temp = temp.next;
        }

        double percentage
                = totalStudents > 0 ? (totalAbsences * 100.0) / totalStudents : 0;

        System.out.println("\n--- Absence Report ---");
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Total Absences: " + totalAbsences);
        System.out.println("Absence Percentage: " + Math.round(percentage) + "%");

    }

    //Grades
    public void addGrades(Classroom c) {
        Scanner in = new Scanner(System.in);

        System.out.println("\n--- Choose Grade Type ---");
        System.out.println("1-Quiz (Max: 10)");
        System.out.println("2-Mid (Max: 20)");
        System.out.println("3- Final (Max: 70)");
        System.out.print("Choice: ");

        int gradeType = readInt(in);

        SLL.Node<Student> temp = c.getStudents().getHead();
        double total = 0, count = 0;

        while (temp != null) {
            Student s = temp.data;
            double grade = 0;

            if (gradeType == 1) {
                System.out.print("Quiz for " + s.getName() + ": ");
                grade = readGrade(in, 10);
                s.setQuiz(grade);
            } else if (gradeType == 2) {
                System.out.print("Mid for " + s.getName() + ": ");
                grade = readGrade(in, 20);
                s.setMid(grade);
            } else if (gradeType == 3) {
                System.out.print("Final for " + s.getName() + ": ");
                grade = readGrade(in, 70);
                s.setFinalExam(grade);
            }

            total += grade;
            count++;
            temp = temp.next;
        }

        if (count > 0) {
            double mean = (double) total / count;
            System.out.println("Average Grade: " + Math.round(mean));

        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    public void setSubjectTaught(String subjectTaught) {
        this.subjectTaught = subjectTaught;
    }

}
