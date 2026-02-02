/*Sample Problem 2: Smart Home Devices 
○ Description: Create a hierarchy for a smart home system where Device is the 
superclass and Thermostat is a subclass. 
○ Tasks: 
■ Define a superclass Device with attributes like deviceId and status. 
■ Create a subclass Thermostat with additional attributes like 
temperatureSetting. 
■ Implement a method displayStatus() to show each device's current 
settings. 
○ Goal: Understand single inheritance by adding specific attributes to a subclass, 
keeping the superclass general.*/

// Superclass
class Device {
    int deviceId;
    String status;

    Device(int deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass
class Thermostat extends Device {
    int temperatureSetting;

    Thermostat(int deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

// Main class
public class SmartHomeDevices {
    public static void main(String[] args) {

        Thermostat t1 = new Thermostat(101, "ON", 24);
        t1.displayStatus();
    }
}
