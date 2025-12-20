public class StudentIDGenerator {
private static final int BASE=2406;
private static int count=1;

public static int IDGenerator(){
    return Integer.parseInt(BASE+String.format("%03d",count++));
}

    }
