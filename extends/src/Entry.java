public class Entry {
    public static void main(String[] args) {
        Person A = new Person("Chung","Bac Ninh");
        System.out.println(A.toString());
        Student b = new Student("Chung","Bac Ninh","CNTT", 2002, 1904);
        System.out.println(b.toString());
        Staff c = new Staff("Chung", "Bac Ninh", "UET", 100);
        System.out.println(c.toString());
    }
}
