//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1= new Student("AHmed@Gmail.com","903830","AHemd",3);
        System.out.println(s1.id());
        Student s2= new Student("AHmed@Gmail.com","903830","AHemd",3);
        System.out.println(s2.id());
        Student s3= new Student("AHmed@Gmail.com","903830","AHemd",3);
        System.out.println(s3.id());

        s1.addCourse("Arabic");
        s1.addCourse("E");
        s1.addCourse("Math");
        s1.addCourse("Math");
        s1.addCourse("Math");
        s1.addCourse("Math");
        s1.addCourse("Math");
        s1.addCourse("Math");
        s1.getCoursesAssinged();
    }
}