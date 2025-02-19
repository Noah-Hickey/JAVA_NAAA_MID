
public class TestMedicationTrackingSystem {
    public static void main(String[] args) {
        MedicationTrackingSystem system1 = new MedicationTrackingSystem();
       Patient patient1 = new Patient(1, "Jimbo", 10, "709-111-1111");

       system1.addPatient(patient1);
        System.out.println(patient1);
        system1.displayPatients();
    }
}
