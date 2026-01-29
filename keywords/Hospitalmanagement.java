/*
Sample Program 7: Hospital Management System
Demonstrates static, this, final, and instanceof.
*/

class Patient {

    // Static variables
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;

    // Final variable
    final int patientID;

    // Instance variables
    String name;
    int age;
    String ailment;

    // Constructor using this
    Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    // Static method
    static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    void displayPatientDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }

    public static void main(String[] args) {
        Patient p = new Patient(1, "Manas", 22, "Fever");

        if (p instanceof Patient) {
            p.displayPatientDetails();
        }

        Patient.getTotalPatients();
    }
}
