public class TestPrescription {
    public static void main(String[] args) {
        // Testing objects for doctor, patient, medication
        Doctor doctor = new Doctor(1, "Dr. Green", 45, "123-456-7890", "Cardiology");
        Patient patient = new Patient(2, "Alperen Sengun", 30, "987-654-3210");
        Medication med = new Medication(101, "Tylenol", "100mg", 100);

        Prescription prescription1 = new Prescription(doctor, patient, med);
        Prescription prescription2 = new Prescription(doctor, patient, med);

        System.out.println(prescription1);
        System.out.println();
        System.out.println(prescription2);
    }
}
