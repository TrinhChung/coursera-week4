public class MotorBike extends Vehicle {
    private boolean hasSidecar;

    public MotorBike(String brand, String model,
                     String registrationNumber, Person owner, boolean hasSidecar) {
        super(brand, model, registrationNumber, owner);
        this.hasSidecar = hasSidecar;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    /**thong tin.*/
    @Override
    public String getInfo() {
        String s = "Motor Bike:\n";
        s = s + "\tBrand: " + brand + "\n\tModel: " + model;
        s = s + "\n\tRegistration Number: " + registrationNumber;
        s = s + "\n\tHas Side Car: " + hasSidecar;
        s = s + "\n\tBelongs to " + owner.getName() + " - " + owner.getAddress();
        return s;
    }
}
