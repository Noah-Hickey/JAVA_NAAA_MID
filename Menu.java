import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        

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
            scanner.nextLine(); 

            switch (option) {
                case 1 -> addANewPatient(system);
                case 2 -> addANewDoctor(system);
                case 3 -> addNewMedicationToPharmacy(system);
                case 4 -> deletePatient(system);
                case 5 -> deleteDoctor(system);
                case 6 -> deleteMedication(system);
                case 7 -> editPatient(system);
                case 8 -> editDoctor(system);
                case 9 -> editMedication(system);
                case 10 -> printPharmacyReport(system);
                case 11 -> checkExpiredMeds(system);
                case 12 -> processANewScript(system);
                case 13 -> printScriptsForSpecificDoctor(system);
                case 14 -> restockPharmacyDrugs(system);
                case 15 -> searchForPatMedDoc(system);
                case 16 -> assignPatientToDoctor(system);
                case 17 -> {
                    exit = true;
                    System.out.println("Exiting The System! Good Bye!");
                }
                default -> System.out.println("Invalid option");
            }
        }

        scanner.close();

    }

    private static void addANewPatient(MedicationTrackingSystem system) {
        system.addANewPatient();
    }
    private static void assignPatientToDoctor(MedicationTrackingSystem system) {
        system.assignPatientToDoctor();
    }
    

    private static void addANewDoctor(MedicationTrackingSystem system) {
        system.addANewDoctor();
    }

    private static void addNewMedicationToPharmacy(MedicationTrackingSystem system) {
        system.addANewMedication();
    }

    private static void deletePatient(MedicationTrackingSystem system) {
        system.removePatient();
    }

    private static void deleteDoctor(MedicationTrackingSystem system) {
        system.removeDoctor();
    }

    private static void deleteMedication(MedicationTrackingSystem system) {
        system.removeMedication();
    }

    private static void editPatient(MedicationTrackingSystem system) { 
        system.editPatient();
    }

    private static void editDoctor(MedicationTrackingSystem system) {
        system.editDoctor();
    }

    private static void editMedication(MedicationTrackingSystem system) {
        system.editMedication();
    }

    private static void restockPharmacyDrugs(MedicationTrackingSystem system) {
        system.restockMedications();
    }

    private static void printScriptsForSpecificDoctor(MedicationTrackingSystem system) {
        system.printScriptsForSpecificDoctor();
        
    }


    private static void processANewScript(MedicationTrackingSystem system) {

        system.displayPatients();
        System.out.println("Enter Patient ID: ");
        int patientID = system.scanner.nextInt();
        system.scanner.nextLine();

        system.displayDoctors();
        System.out.println("Enter Doctor ID: ");
        int doctorID = system.scanner.nextInt();
        system.scanner.nextLine();

        system.displayMedications();
        System.out.println("Enter Medication ID: ");
        int medicationID = system.scanner.nextInt();
        system.scanner.nextLine();

        system.acceptPrescription(patientID, doctorID, medicationID);

    }

    private static void checkExpiredMeds(MedicationTrackingSystem system) {
        system.checkExpiredMeds();
    }

    private static void printPharmacyReport(MedicationTrackingSystem system) {
        system.generateReport();
    }

    private static void searchForPatMedDoc(MedicationTrackingSystem system) {
        system.interactiveSearch();
    }

}
