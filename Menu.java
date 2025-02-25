import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit){
            System.out.println();
            System.out.println("=====Welcome To The Pharmacy Med Tracking System=====");
            System.out.println("What would you like to do? ");
            System.out.println("1: Add A New Patient");
            System.out.println("2: Add A New Doctor");
            System.out.println("3: Add A New Medication To The Pharmacy");
            System.out.println("4: Print System Report");
            System.out.println("5: Check If Meds Are Expired");
            System.out.println("6: Process A New Prescription");
            System.out.println("7: Print All Scripts For Specific Doctor");
            System.out.println("8: Restock the drugs in the pharmacy");
            System.out.println("9: print all scripts for specific patient");
            System.out.println("10: Search for Patients, Doctors, and Medications by name");
            System.out.println("11: Exit The System");

            int option = scanner.nextInt();
            scanner.nextLine(); // Fixes issue where it printed the menu twice //

            switch (option) {
                case 1 -> addANewPatient(scanner, system);
                case 2 -> addANewDoctor(scanner);
                case 3 -> addNewMedicationToPharmacy(scanner, system);
                case 4 -> printPharmacyReport(system);
                case 5 -> checkExpiredMeds(system);
                case 6 -> processANewScript(scanner, system);
                case 7 -> printScriptsForSpecificDoctor(scanner, system);
                case 8 -> restockPharmacyDrugs(scanner, system);
                case 9 -> printAllScriptsForPatientByName(scanner, system);
                case 10 -> searchForPatMedDoc(scanner, system);
                case 11 -> {
                    exit = true;
                    System.out.println("Exiting The System! Good Bye!");
                }
                default -> System.out.println("Invalid option");
            }
        }

    }

    private static void addANewPatient(Scanner scanner, MedicationTrackingSystem system) {
        System.out.println("Enter the patient's ID: ");
        int id = scanner.nextInt();
        
        System.out.println("Enter the patient's name: ");
        String name = scanner.next();
        
        System.out.println("Enter the patient's age: ");
        int age = scanner.nextInt();
        
        System.out.println("Enter the patient's phone number: ");
        String phone = scanner.next();
        
        Patient patient = new Patient(id, name, age, phone);
        system.addPatient(patient);
        System.out.println("Patient added successfully!");

        system.displayPatients();

    }

    private static void addANewDoctor(Scanner scanner) {
    
    }

    private static void addNewMedicationToPharmacy(Scanner scanner, MedicationTrackingSystem system) {

    }
    
    private static void printAllScriptsForPatientByName(Scanner scanner, MedicationTrackingSystem system) {

    }

    private static void restockPharmacyDrugs(Scanner scanner, MedicationTrackingSystem system) {

    }

    private static void printScriptsForSpecificDoctor(Scanner scanner, MedicationTrackingSystem system) {

    }

    private static void processANewScript(Scanner scanner, MedicationTrackingSystem system) {
        System.out.println("Enter Patient ID: ");
        int patientID = scanner.nextInt();

        System.out.println("Enter Doctor ID: ");
        int doctorID = scanner.nextInt();

        System.out.println("Enter Medication ID: ");
        int medicationID = scanner.nextInt();

        system.acceptPrescription(patientID, doctorID, medicationID);

    }

    private static void checkExpiredMeds(MedicationTrackingSystem system) {
      system.checkExpiredMeds();
    }

    private static void printPharmacyReport(MedicationTrackingSystem system) {
      system.generateReport();
    }

    
    private static void searchForPatMedDoc(Scanner scanner, MedicationTrackingSystem system) {

        system.interactiveSearch(scanner);

    }
    

    

}
