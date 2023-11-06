package sample;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class database_manage {
    static Connection c = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    public static void set_database() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/dict_avva.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static void close_database() throws SQLException {
        rs.close();
        stmt.close();
        c.close();
    }

    public static String[] list_word() throws SQLException {
        rs = stmt.executeQuery(String.format("select * from av"));
        Set<String> a = new LinkedHashSet<>();
        while(rs.next()) {
            a.add(rs.getString("word"));
        }
        String[] result = new String [a.size()];
        result = a.toArray(result);
        rs.close();
        return result;
    }

    public static String search(String br) throws SQLException{
        String s="Phát âm: ";
        if(br == null) {
            return "";
        } else {
                rs = stmt.executeQuery(String.format("select * from av where word = '%s'", br.toLowerCase()));
                if (rs == null) {
                    return "This word doesn't exist";
                }
                String prc = rs.getString("pronounce");
                s = s + prc + "\n";
                while (rs.next()) {
                    String drc = rs.getString("html");
                    s = s + drc + "\n";
                }
                rs.close();
                return s;
        }
    }


}

