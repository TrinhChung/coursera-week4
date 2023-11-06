import java.util.Scanner;

public class EnTry {
    public static void main(String[] args) {
        Student[] sts = new Student[5];
        for( int j=0;j<5;j++){
            sts[j] = new Student();
        }
        sts[4].setId("20020370");
        sts[4].setGroup("K65B");
        sts[0].setGroup("K65B");
        sts[3].setId("20020369");
        StudentManagement s = new StudentManagement();

        for(int j=0;j<5;j++){
            s.addStudent(sts[j]);
        }
       // s.removeStudent("20020370");
        System.out.println(s.studentsByGroup());
    }
}
