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
            System.out.println("3: Add A New Medication To Pharmacy");
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
                case 1 -> addANewPatient(system);
                case 2 -> addANewDoctor(scanner,system);
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
                case 16 -> assignPatientToDoctor(system);
                case 17 -> {
                    exit = true;
                    System.out.println("Exiting The System! Good Bye!");
                }
                default -> System.out.println("Invalid option");
            }
        }

    }

    private static void addANewPatient(MedicationTrackingSystem system) {
        system.addANewPatient();
    }
    private static void assignPatientToDoctor(MedicationTrackingSystem system) {
        system.assignPatientToDoctor();
    }
    

    private static void addANewDoctor(Scanner scanner, MedicationTrackingSystem system) {
        system.addANewDoctor(scanner);
    }

    private static void addNewMedicationToPharmacy(Scanner scanner, MedicationTrackingSystem system) {
        system.addANewMedication(scanner);
    }

    private static void deletePatient(Scanner scanner, MedicationTrackingSystem system) {
        system.removePatient(scanner);
    }

    private static void deleteDoctor(Scanner scanner, MedicationTrackingSystem system) {
        system.removeDoctor(scanner);
    }

    private static void deleteMedication(Scanner scanner, MedicationTrackingSystem system) {
        system.removeMedication(scanner);
    }

    private static void editPatient(Scanner scanner, MedicationTrackingSystem system) { 
        system.editPatient(scanner);
    }

    private static void editDoctor(Scanner scanner, MedicationTrackingSystem system) {
        system.editDoctor(scanner);
    }

    private static void editMedication(Scanner scanner, MedicationTrackingSystem system) {
        system.editMedication(scanner);
    }

    private static void restockPharmacyDrugs(Scanner scanner, MedicationTrackingSystem system) {
        system.restockMedications(scanner);
    }

    private static void printScriptsForSpecificDoctor(Scanner scanner, MedicationTrackingSystem system) {
        
        system.displayDoctors();
        
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

        system.displayPatients();
        System.out.println("Enter Patient ID: ");
        int patientID = scanner.nextInt();

        system.displayDoctors();
        System.out.println("Enter Doctor ID: ");
        int doctorID = scanner.nextInt();

        system.displayMedications();
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
