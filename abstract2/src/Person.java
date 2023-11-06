import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String address;
    private List<Vehicle> vehicleList = new ArrayList<>();

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    /**xoa phuong tien.*/
    public void removeVehicle(String registrationNumber) {
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getRegistrationNumber().equals(registrationNumber)) {
                vehicleList.remove(i);
            }
        }
    }

    /**getInfo.*/
    public String getVehiclesInfo() {
        if (vehicleList.size() == 0) {
            return getName() + " has no vehicle!";
        } else {
            String s = getName() + " has:\n\n";
            for (int i = 0; i < vehicleList.size(); i++) {
                s = s + vehicleList.get(i).getInfo() + "\n";
            }
            return s;
        }
    }

}
