/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectt;

public class Timetable {
    
    private Student student;
    private Array<Subject> subjects;

    
    public Timetable() {
        this.subjects = new Array<>(10);
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    // number of assigned subjects
    public int getTotalSubjects() {
        return subjects.getCount();   
    }

    public void addSubject(Subject subject) {

        int allowedSubjects = student.getNumberOfSubjectsAllowed();
        int currentSubjects = getTotalSubjects();

        if (currentSubjects >= allowedSubjects) {
            System.out.println( "You can not add this Subject: " + subject.toString() + " (Maximum allowed Subjects: " + allowedSubjects + ")");
        } else {
            subjects.append(subject);
            System.out.println("Course added successfully: " + subject.toString() +" (Total courses: " + (currentSubjects + 1) +
                    " / " + allowedSubjects + ")");
        }
    }

    public void showTimetable() {

        System.out.println("Timetable For " + student.getName() +" (ID: " + student.getId() + ")");


        if (subjects.isEmpty()) {
            System.out.println("No Courses Added Yet.");
        } else {
            subjects.traverse();
            System.out.println("Total courses: " +getTotalSubjects() +" / " + student.getNumberOfSubjectsAllowed());
        }

    }
}

    

