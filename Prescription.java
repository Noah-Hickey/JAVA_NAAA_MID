import java.time.LocalDate;

public class Prescription {
    private static int idCounter = 0; 
    private final int id; 
    private Doctor doctor; 
    private Patient patient; 
    private Medication medication; 
    private LocalDate issueDate; 
    private LocalDate expiryDate; 

    public Prescription(Doctor doctor, Patient patient, Medication medication) {
        this.id = idCounter++; 
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.issueDate = LocalDate.now(); 
        this.expiryDate = issueDate.plusYears(1); 
    }

    // Getters
    public int getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public String toString() {
        return "Prescription ID: " + id + "\n" +
               "Doctor: " + doctor.getName() + "\n" +
               "Patient: " + patient.getName() + "\n";
            //    "Medication: " + medication.getName() + "\n" +
            //    "Issued Date: " + issueDate + "\n" +
            //    "Expires On: " + expiryDate + "\n" +
            //    (isExpired() ? "Alert! Prescription expired" : "Prescription is not expired");
    }
}
