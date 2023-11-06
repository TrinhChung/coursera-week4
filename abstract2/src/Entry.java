public class Entry {
    public static void main(String[] args) {
        Person person = new Person("trinhChung", "BacNinh");
        Vehicle a = new Car("Mercedes-Benz", "S400", "30A - 888.88", person, 4);
        Vehicle b = new MotorBike("cup", "85", "30A - 99999", person, true);
        person.addVehicle(a);
        person.addVehicle(b);
        System.out.println(person.getVehiclesInfo());
    }
}
