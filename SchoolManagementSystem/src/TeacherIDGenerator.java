public class TeacherIDGenerator {
    private static int  count=1;

    public static int IDGenerator(){
        return Integer.parseInt(String.format("%02d",count++));
    }
}
