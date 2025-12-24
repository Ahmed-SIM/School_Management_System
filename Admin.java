/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectt;


public class Admin extends Person{
    
    private SLL<Student> students = new SLL<>();
    private SLL<Teacher> teachers = new SLL<>();
    private SLL<Subject> subjects = new SLL<>();
    private SLL<Timetable> timetables = new SLL<>();

    public Admin(String email, String password, String name) {
        super(email, password, name);
    }

    public Timetable getOrCreateTimetable(Student s) {
        for (int i = 0; i < timetables.count(); i++) {
            Timetable t = timetables.get(i);
            if (t.getStudent().getId().equals(s.getId())) {
                return t;
            }
        }
        return createTimetableForStudent(s);
    }

    //students management
    public void addStudent(Student student) {
        students.append(student);
    }

    public void deleteStudent(String id) {
        Student s = students.searchById(id);
        if (s != null) {
            students.delete(s);
        }
    }

    public Student searchStudentById(String id) {
        return students.searchById(id);
    }

    public void displayStudents() {
        students.traverse();
    }

    //teachers management
    public void addTeacher(Teacher teacher) {
        teachers.append(teacher);
    }

    public void deleteTeacher(String id) {
        Teacher t = teachers.searchById(id);
        if (t != null) {
            teachers.delete(t);
        }
    }

    public Teacher searchTeacherById(String id) {
        return teachers.searchById(id);
    }

    public void displayTeachers() {
        teachers.traverse();
    }

    //subjects management
    public void addSubject(Subject subject) {
        subjects.append(subject);
    }

    public void deleteSubject(Subject subject) {
        subjects.delete(subject);
    }

    public Subject searchSubjectById(String id) {
        return subjects.searchById(id);
    }

    public void displaySubjects() {
        subjects.traverse();
    }

    //timetable managemen
    public Timetable createTimetableForStudent(Student student) {
        Timetable timetable = new Timetable();
        timetable.setStudent(student);
        timetables.append(timetable);
        return timetable;
    }

    public void addSubjectToTimetable(Timetable timetable, Subject subject) {
        timetable.addSubject(subject);
    }

    public void showStudentTimetable(Timetable timetable) {
        timetable.showTimetable();
    }

    public void displayAllTimetables() {
        timetables.traverse();
    }

    //edit
    public void editStudentLevel(String id, int newGrade) {
        Student student = students.searchById(id);
        if (student != null) {
            student.setGrade(newGrade);
        }
    }

    public void editTeacherSalary(String id, double newSalary) {
        Teacher teacher =  teachers.searchById(id);
        if (teacher != null) {
            teacher.setSalary(newSalary);
        }
    }

    
}
