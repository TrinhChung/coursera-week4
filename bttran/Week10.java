import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Week10 {

    /**
     * check lang.
     */
    public static boolean checkLang(String a) {
        if (a.equals("String") || a.equals("Class<?>")
                || a.equals("Object") || a.equals("Integer") || a.equals("Iterable")) {
            return true;
        }
        return false;
    }

    /**
     * check kieu nguyen thuy.
     */
    public static boolean checkInt(String a) {
        if (a.equals("int") || a.equals("long") || a.equals("double") || a.equals("boolean")) {
            return true;
        }
        return false;
    }

    /**
     * check thu vien.
     */
    public static boolean checkLb(String k, String a) {
        String[] name = k.split("\\.");
        if (name[name.length - 1].substring(0, name[name.length - 1].length() - 1).equals(a)) {
            return true;
        }
        return false;
    }

    /**
     * ham main chinih.
     */
    public static List<String> getAllFunctions(String fileContent) {
        List<String> lb = new ArrayList<>();
        List<String> func = new ArrayList<>();
        String pack = "";
        List<String> classGroup = new ArrayList<>();
        boolean check = true;
        Scanner r = new Scanner(fileContent).useDelimiter("\\A");
        while (r.hasNextLine()) {
            String s = r.nextLine().trim().replaceAll("\\s+", " ");
            String[] a = s.trim().split(" ");
            if (s.contains("/**") || a[0].contains("//") || s.contains("/*")) {
                if (a[0].contains("//")) {
                    continue;
                }
                if (a[0].contains("/**") && a[a.length - 1].contains("*/")) {
                    continue;
                }
                while (true) {
                    s = r.nextLine().trim();
                    a = s.split(" ");
                    if (s.contains("*/")) {
                        break;
                    }
                }
                if (a[a.length - 1].contains("*/")) {
                    continue;
                }
            }
            if (a.length >= 2 && a[0].equals("import")) {
                lb.add(a[a.length - 1]);
                continue;
            }
            if (a.length >= 2 && a[0].equals("package")) {
                pack = a[1];
            }
            if (a.length >= 3 && a[1].equals("class") && a[a.length - 1].equals("{")) {
                classGroup.add(a[2]);
            }
            if (s.contains("static") && s.contains("(")
                    && (a[a.length - 1].contains("{")
                    || a[a.length - 1].charAt(a[a.length - 1].length() - 1) == '(')) {
                if (a[a.length - 1].charAt(a[a.length - 1].length() - 1) == '(') {
                    s = s + r.nextLine().trim().replaceAll("\\s+", " ");
                    a = s.split(" ");
                }
                int start = 3;
                String v = "";
                int n = 0;
                boolean c = false;
                for (int i = 0; i < a.length - 1; i++) {
                    if (a[i].contains(")")) {
                        n = i;
                    }
                    if (a[i].contains("(")) {
                        start = i;
                    }
                }
                for (int i = start; i <= n; i += 2) {
                    if (i == start) {
                        String[] t = a[i].split("\\(");
                        v = v + t[0] + "(";
                        if (t.length > 1) {
                            if (t[1].contains("T[]")) {
                                v += t[1];
                            }
                            if (t[1].contains("...")) {
                                t[1] = t[1].substring(0, t[1].length() - 3);
                            }
                            for (String k : classGroup) {
                                if (t[1].contains(k)) {
                                    v = v + pack + "." + a[i];
                                    break;
                                }
                            }
                            if (checkLang(t[1])) {
                                v = v + "java.lang." + t[1];
                            }
                            if (checkInt(t[1])) {
                                v = v + t[1];
                            }
                            if (t[1].equals("QueryAPI") || t[1].equals("SProcAPI")) {
                                v += "com.nordstrom.common.jdbc.utils." + t[1];
                            }
                            for (String k : lb) {
                                if (checkLb(k, t[1])) {
                                    v += k.substring(0, k.length() - 1);
                                    break;
                                }
                            }
                            if (t[1].contains("<") && !t[1].equals("Class<?>")) {
                                String[] k = t[1].split("<");
                                if (k[k.length - 1].equals("T>")) {
                                    check = true;
                                    for (String j : lb) {
                                        if (checkLb(j, k[0])) {
                                            v += j.substring(0, j.length() - 1) + "<T>";
                                            check = false;
                                            break;
                                        }
                                    }
                                    if (check) {
                                        if (checkLang(k[0])) {
                                            v += "java.lang." + k[0] + "<T>";
                                        } else {
                                            v += t[1];
                                        }
                                    }
                                } else {
                                    for (String j : lb) {
                                        if (j.contains(k[0])) {
                                            k[0] = j.substring(0, j.length() - 1);
                                        }
                                        if (j.contains(k[1].substring(0, k[1].length() - 1))) {
                                            v += k[0] + "<" + j.substring(0, j.length() - 1) + ">";
                                            break;
                                        }
                                    }
                                    if (checkLang(k[1].substring(0, k[1].length() - 1))) {
                                        v = v + k[0] + "<" + "java.lang." + k[1];
                                    } else if (checkInt(k[1].substring(0, k[1].length() - 1))) {
                                        v = v + t[1];
                                    }
                                }
                            }
                        }
                        if (i + 2 <= n) {
                            v += ",";
                        }
                    } else {
                        if (a[i].contains("...")) {
                            a[i] = a[i].substring(0, a[i].length() - 3);
                        }
                        for (String k : classGroup) {
                            if (a[i].contains(k)) {
                                v = v + pack + "." + a[i];
                                break;
                            }
                        }
                        if (a[i].contains("[]")) {
                            v += a[i];
                        }
                        if (a[i].equals("QueryAPI") || a[i].equals("SProcAPI")) {
                            v += "com.nordstrom.common.jdbc.utils." + a[i];
                        }
                        if (checkLang(a[i])) {
                            v = v + "java.lang." + a[i];
                        } else if (checkInt(a[i])) {
                            v = v + a[i];
                        } else if (a[i].contains("<") && !a[i].equals("Class<?>")) {
                            String[] k = a[i].split("<");
                            if (k[k.length - 1].equals("T>")) {
                                check = true;
                                for (String j : lb) {
                                    if (checkLb(j, k[0])) {
                                        v += j.substring(0, j.length() - 1) + "<T>";
                                        check = false;
                                        break;
                                    }
                                }
                                if (check) {
                                    if (checkLang(k[0])) {
                                        v += "java.lang." + k[0] + "<T>";
                                    } else {
                                        v += a[i];
                                    }
                                }
                            } else {
                                for (String j : lb) {
                                    if (j.contains(k[0])) {
                                        k[0] = j.substring(0, j.length() - 1);
                                    }
                                    if (j.contains(k[1].substring(0, k[1].length() - 1))) {
                                        v += k[0] + "<" + j.substring(0, j.length() - 1) + ">";
                                        break;
                                    }
                                }
                                if (checkLang(k[1].substring(0, k[1].length() - 1))) {
                                    v = v + k[0] + "<" + "java.lang." + k[1];
                                } else if (checkInt(k[1].substring(0, k[1].length() - 1))) {
                                    v = v + a[i];
                                }
                            }
                        }
                        for (String k : lb) {
                            if (checkLb(k, a[i])) {
                                v = v + k.substring(0, k.length() - 1);
                                break;
                            }
                        }
                        if (i + 2 <= n) {
                            v += ",";
                        }
                    }
                }
                v = v + ")";
                func.add(v);
            }
        }
        return func;
    }

}