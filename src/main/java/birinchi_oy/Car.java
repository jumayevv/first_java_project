package Dars.birinchi_oy;
public class Car {
    String brand;
    Integer maxSpeed;
    Dvigitel dvigitel;

    public Car(String brand, Integer maxSpeed, Dvigitel dvigitel) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.dvigitel = dvigitel;
    }

    public static class Dvigitel{
        public Integer numberOfSlinders;
        public String typeOfFuel;

        public Dvigitel(Integer numberOfSlinders, String typeOfFuel) {
            this.numberOfSlinders = numberOfSlinders;
            this.typeOfFuel = typeOfFuel;
        }
    }

    @Override
    public String toString() {
        return "brand: " +this.brand +
                "\nmax speed: " + this.maxSpeed;
    }



}
