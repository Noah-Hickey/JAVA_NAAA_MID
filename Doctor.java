import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private String specialization;
    private List<Patient> patients;

    // Constructor
    public Doctor(int id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    // Getters and setters for specialization
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Methods to add and remove patients
    public void addPatient(Patient patient) {
        if (patient != null) {
            patients.add(patient);
        }
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    // Get patients list
    public List<Patient> getPatients() {
        return new ArrayList<>(patients);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "ID=" + getId() +
                ", Name='" + getName() + '\'' +
                ", Age=" + getAge() +
                ", Phone Number='" + getPhoneNumber() + '\'' +
                ", Specialization='" + specialization + '\'' +
                ", Patients=" + patients +
                '}';
    }
}
