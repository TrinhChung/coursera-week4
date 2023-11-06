public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model,
               String registrationNumber, Person owner, int numberOfDoors) {
        super(brand, model, registrationNumber, owner);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    /**thong tin.*/
    @Override
    public String getInfo() {
        String s = "Car:\n";
        s = s + "\tBrand: " + brand + "\n\tModel: " + model;
        s = s + "\n\tRegistration Number: " + registrationNumber;
        s = s + "\n\tNumber of Doors: " + numberOfDoors;
        s = s + "\n\tBelongs to " + owner.getName() + " - " + owner.getAddress();
        return s;
    }
}
