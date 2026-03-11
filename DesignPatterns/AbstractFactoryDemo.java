public class AbstractFactoryDemo {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        Car sedan = carFactory.createCar("sedan");
        sedan.drive();

        VehicleFactory bikeFactory = new BikeFactory();
        Bike sports = bikeFactory.createBike("sports");
        sports.ride();
    }
}

interface Car { void drive(); }
interface Bike { void ride(); }

class Sedan implements Car { public void drive() { System.out.println("Driving Sedan"); } }
class SUV implements Car { public void drive() { System.out.println("Driving SUV"); } }

class SportsBike implements Bike { public void ride() { System.out.println("Riding SportsBike"); } }
class NormalBike implements Bike { public void ride() { System.out.println("Riding NormalBike"); } }

abstract class VehicleFactory {
    public Car createCar(String type) { throw new UnsupportedOperationException(); }
    public Bike createBike(String type) { throw new UnsupportedOperationException(); }
}

class CarFactory extends VehicleFactory {
    @Override
    public Car createCar(String type) {
        return switch (type.toLowerCase()) {
            case "sedan" -> new Sedan();
            case "suv" -> new SUV();
            default -> throw new IllegalArgumentException("Unknown car: " + type);
        };
    }
}

class BikeFactory extends VehicleFactory {
    @Override
    public Bike createBike(String type) {
        return switch (type.toLowerCase()) {
            case "sports" -> new SportsBike();
            case "normal" -> new NormalBike();
            default -> throw new IllegalArgumentException("Unknown bike: " + type);
        };
    }
}