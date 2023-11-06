import  java.lang.Object;

public class StudentManagement {
    Student[] students = new Student[99];
    private int i = 0;

    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    public void addStudent(Student newStudent) {
        students[i] = newStudent;
        i++;
    }

    /**Sap xep. */
    public String studentsByGroup() {
        if (i == 0) {
            return "";
        } else {
            String[] g = new String[99];
            int t = 1;
            g[0] = students[0].getGroup();
            for (int j = 1; j < i; j++) {
                boolean check = true;
                for (int k = 0; k < t; k++) {
                    if (students[j].getGroup().equals(g[k])) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    g[t] = students[j].getGroup();
                    t++;
                }
            }
            String s = "";
            for (int j = 0; j < t; j++) {
                s = s + g[j] + "\n";
                for (int k = 0; k < i; k++) {
                    if (students[k].getGroup().equals(g[j])) {
                        s = s + students[k].getInfo() + "\n";
                    } else {
                        continue;
                    }
                }
            }
            return s;
        }
    }

    /** Xoa id. */
    public void removeStudent(String id) {
        for (int j = 0; j < i;) {
            if (students[j].getId().equals(id)) {
                for (int k = j; k < i ; k++) {
                    students[k] = students[k + 1];
                }
                i--;
            } else {
                j++;
            }
        }
    }
}
