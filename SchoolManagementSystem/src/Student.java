import java.util.ArrayList;

public class Student {
  private  int id;
    private String name;
    private int grade;
    private int numberOfCoursesAllowed=7;
    private int numberOfCoursesAssigned;
    private Array<String> coursesAssigned;
    private String email;
    private String password;


//    constructor
public Student(String email , String password , String name , int grade){
    this.email=email;
    this.password=password;
    this.name=name;
    this.grade=grade;
    this.id= StudentIDGenerator.IDGenerator();
    this.coursesAssigned=new Array<>(numberOfCoursesAllowed);
}

//Method to Add course
public void addCourse(String courseName){
 if(numberOfCoursesAssigned<numberOfCoursesAllowed){
     coursesAssigned.append(courseName.toLowerCase());
     numberOfCoursesAssigned++;
 }else {
     System.out.println("You can not take more than 7 courses ! ");
 }

}

// Remove course by its name
    public void removeCourse(String courseName){
int idx=coursesAssigned.search(courseName.toLowerCase());
    if (idx!=-1){
    coursesAssigned.deleteByPosition(idx);
}else {
        System.out.println("This subject is not assigned to you");
    }
}


// getter to the courses assigned
    public void getCoursesAssinged(){
    coursesAssigned.traverse();
    }

    public String email() {
        return email;
    }

    public int grade() {
        return grade;
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public int numberOfCoursesAllowed() {
        return numberOfCoursesAllowed;
    }

    public int numberOfCoursesAssigned() {
        return numberOfCoursesAssigned;
    }

    public String password() {
        return password;
    }

    public void reSetPassword(String newPassword){
    this.password=newPassword;
    }

}
