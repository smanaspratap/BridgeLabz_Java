/*
Description: Design a system to manage patients in a hospital:
Create an abstract class Patient with fields like patientId, name, and age.
Add an abstract method calculateBill() and a concrete method getPatientDetails().
Extend it into subclasses InPatient and OutPatient, implementing calculateBill()
with different billing logic.
Implement an interface MedicalRecord with methods addRecord() and viewRecords().
Use encapsulation to protect sensitive patient data like diagnosis and medical history.
Use polymorphism to handle different patient types and display their billing details dynamically.
*/

import java.util.ArrayList;
import java.util.List;

/* ---------- Interface ---------- */
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

/* ---------- Abstract Class ---------- */
abstract class Patient {

    private int patientId;
    private String name;
    private int age;

    // sensitive data (encapsulated)
    private String diagnosis;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
    }

    // Encapsulation (setter only)
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}

/* ---------- In-Patient ---------- */
class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(int id, String name, int age, int days, double charge) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.dailyCharge = charge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        System.out.println("In-Patient Record Added: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Viewing In-Patient Medical Records");
    }
}

/* ---------- Out-Patient ---------- */
class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;

    public OutPatient(int id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        System.out.println("Out-Patient Record Added: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Viewing Out-Patient Medical Records");
    }
}

/* ---------- Main Class ---------- */
public class HospitalTest {

    public static void main(String[] args) {

        List<Patient> patients = new ArrayList<>();

        patients.add(new InPatient(1, "Prajwal", 22, 5, 3000));
        patients.add(new OutPatient(2, "Amit", 30, 800));

        // Polymorphism in action
        for (Patient p : patients) {

            p.getPatientDetails();
            System.out.println("Total Bill : ₹" + p.calculateBill());

            System.out.println("--------------------------");
        }
    }
}
