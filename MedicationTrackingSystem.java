// import java.lang.classfile.instruction;
import java.util.ArrayList;
import java.util.List;

public class MedicationTrackingSystem {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Medication> medications;
    private List<Prescription> prescriptions;


    // Constructor 
    public MedicationTrackingSystem() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();

        Patient patient1 = new Patient(20, "Bob", 30, "709-222-2222");
        patients.add(patient1);

        Patient patient2 = new Patient(22, "Jill", 25, "709-333-2222");
        patients.add(patient2);

        Doctor doctor1 = new Doctor(20, "Gordon", 65, "709-444-4444", "Cardiology");
        doctors.add(doctor1);

        Doctor doctor2 = new Doctor(20, "Gord", 65, "709-555-5555", "Cancer");
        doctors.add(doctor2);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Added patient: " + patient.getName());
    }

    public void displayPatients() {
        System.out.println("Patients:");
        for (Patient pat : patients) {
            System.out.println(pat);
        }
    }


}