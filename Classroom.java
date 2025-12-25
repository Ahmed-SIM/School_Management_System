/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectt;

public class Classroom {
   private String classId;
    private String className;
    private String grade;
    private SLL<Student> students;

    public Classroom(String id, String name, String grade) {
        this.classId = id;
        this.className = name;
        this.grade = grade;
        this.students = new SLL<>();
    }

    public String getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public String getGrade() {
        return grade;
    }

    public SLL<Student> getStudents() {
        return students;
    }

    public void addStudent(Student s) {
        students.append(s);
    }

    public Student searchStudentById(String id) {
        return students.searchById(id);
    }

    public void displayStudents() {
        students.traverse();
    } 
}
