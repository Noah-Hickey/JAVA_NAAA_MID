import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit){
            System.out.println();
            System.out.println("=====Welcome To The Pharmacy Med Tracking System=====");
            System.out.println();
            System.out.println("What would you like to do? Enter a number for one of the following options:");
            System.out.println();
            System.out.println("1: Add A New Patient");
            System.out.println("2: Add A New Doctor");
            System.out.println("3: Add New Medication To Pharmacy");
            System.out.println("4: Delete Patient");
            System.out.println("5: Delete Doctor");
            System.out.println("6: Delete Medication");
            System.out.println("7: Edit Patient");
            System.out.println("8: Edit Doctor");
            System.out.println("9: Edit Medication");
            System.out.println("10: Print Pharmacy Report");
            System.out.println("11: Check Expired Medications");
            System.out.println("12: Process A New Script");
            System.out.println("13: Print Scripts For Specific Doctor");
            System.out.println("14: Restock Pharmacy Drugs");
            System.out.println("15: Search For Patient, Medication, or Doctor");
            System.out.println("16: Assign Patient To Doctor");
            System.out.println("17: Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Fixes issue where it printed the menu twice //

            switch (option) {
                case 1 -> addANewPatient(scanner, system);
                case 2 -> addANewDoctor(scanner);
                case 3 -> addNewMedicationToPharmacy(scanner, system);
                case 4 -> deletePatient(scanner, system);
                case 5 -> deleteDoctor(scanner, system);
                case 6 -> deleteMedication(scanner, system);
                case 7 -> editPatient(scanner, system);
                case 8 -> editDoctor(scanner, system);
                case 9 -> editMedication(scanner, system);
                case 10 -> printPharmacyReport(system);
                case 11 -> checkExpiredMeds(system);
                case 12 -> processANewScript(scanner, system);
                case 13 -> printScriptsForSpecificDoctor(scanner, system);
                case 14 -> restockPharmacyDrugs(scanner, system);
                case 15 -> searchForPatMedDoc(scanner, system);
                case 16 -> assignPatientToDoctor(scanner, system);
                case 17 -> {
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
    private static void assignPatientToDoctor(Scanner scanner, MedicationTrackingSystem system) {
    system.assignPatientToDoctor();
}
    

    private static void addANewDoctor(Scanner scanner) {
    
    }

    private static void addNewMedicationToPharmacy(Scanner scanner, MedicationTrackingSystem system) {

    }

    private static void deletePatient(Scanner scanner, MedicationTrackingSystem system) {

    }

    private static void deleteDoctor(Scanner scanner, MedicationTrackingSystem system) {

    }

    private static void deleteMedication(Scanner scanner, MedicationTrackingSystem system) {

    }

    private static void editPatient(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        system.editPatient(id);
    }

    private static void editDoctor(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        system.editDoctor(id);
    }

    private static void editMedication(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Medication ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        system.editMedication(id);
    }

    private static void restockPharmacyDrugs(Scanner scanner, MedicationTrackingSystem system) {
        system.restockMedications(scanner);
    }

    private static void printScriptsForSpecificDoctor(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Doctor ID: ");
        
        if (scanner.hasNextInt()) { 
            int doctorID = scanner.nextInt();
            scanner.nextLine();  
            system.generateDoctorReport(doctorID);
        } else {
            System.out.println("Invalid input! Please enter a valid Doctor ID.");
            scanner.nextLine(); 
        }
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
