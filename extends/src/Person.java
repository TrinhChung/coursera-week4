public class Person {
    private String name;
    private String address;

    /**Khoi tao co tham so .*/
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**chuoi. */
    public String toString() {
        return "Person[name=" + getName() + ",address=" + getAddress() + "]";
    }
}
