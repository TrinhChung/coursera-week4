public class Person {
    private String name;
    private int age;
    private String address;

    /**khoi tao 3 tham so.*/
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * so sanh.
     */
    public int compareTo(Person p1) {
        if (getName().compareTo(p1.getName()) != 0) {
            return getName().compareTo(p1.getName());
        } else {
            return getAge() - p1.getAge();
        }
    }

}
