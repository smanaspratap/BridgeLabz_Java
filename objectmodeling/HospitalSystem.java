/* Problem 3: Hospital, Doctors, and Patients (Association and Communication)
Description:
Doctors and Patients interact through consultations.
A doctor can consult multiple patients and
a patient can consult multiple doctors.

Goal:
Practice association with communication between objects.
*/

import java.util.ArrayList;

// Patient class
class Patient {
    String name;

    Patient(String name) {
        this.name = name;
    }
}

// Doctor class
class Doctor {
    String name;
    ArrayList<Patient> patients; // Association with Patient

    Doctor(String name) {
        this.name = name;
        patients = new ArrayList<>();
    }

    // Communication method
    void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Doctor " + name + " is consulting patient " + patient.name);
    }
}

// Hospital class
public class HospitalSystem {
    public static void main(String[] args) {

        Doctor d1 = new Doctor("Dr. Sharma");
        Doctor d2 = new Doctor("Dr. Mehta");

        Patient p1 = new Patient("Manas");
        Patient p2 = new Patient("Rahul");

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);
    }
}
