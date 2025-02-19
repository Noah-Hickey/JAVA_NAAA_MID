import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private List<Medication> medications;
    private List<Prescription> prescriptions;

    // Constructor
    public Patient(int id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // Methods to add and remove medications
    public void addMedication(Medication medication) {
        if (medication != null) {
            medications.add(medication);
        }
    }

    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    // Methods to add and remove prescriptions
    public void addPrescription(Prescription prescription) {
        if (prescription != null) {
            prescriptions.add(prescription);
        }
    }

    public void removePrescription(Prescription prescription) {
        prescriptions.remove(prescription);
    }

    // Getters
    public List<Medication> getMedications() {
        return new ArrayList<>(medications);
    }

    public List<Prescription> getPrescriptions() {
        return new ArrayList<>(prescriptions);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "ID=" + getId() +
                ", Name='" + getName() + '\'' +
                ", Age=" + getAge() +
                ", Phone Number='" + getPhoneNumber() + '\'' +
                ", Medications=" + medications +
                ", Prescriptions=" + prescriptions +
                '}';
    }
}
