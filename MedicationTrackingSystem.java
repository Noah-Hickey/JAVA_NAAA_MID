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

        Patient patient3 = new Patient(23, "Jack", 35, "709-444-2222");
        patients.add(patient3);

        Patient patient4 = new Patient(24, "Gill", 25, "709-555-2222");
        patients.add(patient4);

        Doctor doctor1 = new Doctor(1, "Gordon", 65, "709-444-4444", "Cardiology");
        doctors.add(doctor1);

        Doctor doctor2 = new Doctor(2, "Gord", 65, "709-555-5555", "Cancer");
        doctors.add(doctor2);

        Doctor doctor3 = new Doctor(3, "Gordy", 65, "709-666-6666", "Pediatrics");
        doctors.add(doctor3);

        Medication med1 = new Medication(1, "Tylenol", "10mg", 5);
        medications.add(med1);

        Medication med2 = new Medication(2, "Advil", "20mg", 10);
        medications.add(med2);

        Medication med3 = new Medication(3, "Marijuana", "3.5g", 5);
        medications.add(med3);

        Medication med4 = new Medication(4, "Morphine", "5mg", 5);
        medications.add(med4);

        Prescription script1 = new Prescription(doctor1, patient1, med1);
        prescriptions.add(script1);

        Prescription script2 = new Prescription(doctor2, patient2, med2);
        prescriptions.add(script2);

        Prescription script3 = new Prescription(doctor3, patient3, med3);
        prescriptions.add(script3);

        Prescription script4 = new Prescription(doctor1, patient4, med3);
        prescriptions.add(script4);

        Prescription script5 = new Prescription(doctor2, patient1, med3);
        prescriptions.add(script5);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Added patient: " + patient.getName());
    }

    public void displayPatients() {
        System.out.println("\n=== List of Patients ===");
        for (Patient pat : patients) {
            System.out.println(pat);
        }
    }

    public void acceptPrescription(int patientID, int doctorID, int medicationID) {
        Patient patient = findPatientByID(patientID);
        Doctor doctor = findDoctorByID(doctorID);
        Medication medication = findMedicationByID(medicationID);

        if (patient == null || doctor == null || medication == null) {
            System.out.println("Error: Invalid patient, doctor, or medication ID.");
            return;
        }

        Prescription newPrescription = new Prescription(doctor, patient, medication);
        prescriptions.add(newPrescription);
        patient.addPrescription(newPrescription);

        System.out.println("Success! Prescription added for" + patient.getName() + ". Prescribed by Dr. " + doctor.getName());
    }

    private Patient findPatientByID (int id) {
        for (Patient p : patients) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    private Doctor findDoctorByID (int id) {
        for (Doctor d : doctors) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    private Medication findMedicationByID(int id) {
        for (Medication m : medications) {
            if (m.getId() == id) return m;
        }
        return null;
    }
    
    public void displayDoctors() {
        System.out.println("\n=== List of Doctors ===");
        for (Doctor doc : doctors) {
            System.out.println(doc);
        }
    }

    public void displayMedications() {
        System.out.println("\n=== List of Medications ===");
        for (Medication med : medications) {
            System.out.println(med);
        }
    }

    public void displayPrescriptions() {
        System.out.println("\n=== List of Prescriptions ===");
        for (Prescription pres : prescriptions) {
            System.out.println(pres);
        }
    }

    public void generateReport() {
        System.out.println("\n=====================================");
        System.out.println("       MEDICATION SYSTEM REPORT");
        System.out.println("=====================================\n");

        System.out.println("Doctors:");
        for (Doctor doc : doctors) {
            System.out.println("- " + doc);
        }

        System.out.println("\nPatients:");
        for (Patient pat : patients) {
            System.out.println("- " + pat);
        }

        System.out.println("\nMedications:");
        for (Medication med : medications) {
            System.out.println("- " + med);
        }

        System.out.println("\nPrescriptions:");
        for (Prescription pres : prescriptions) {
            System.out.println("\n" + pres);
        }

        System.out.println("\n=================================");
        System.out.println("         END OF REPORT");
        System.out.println("=================================");
    }


}