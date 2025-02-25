// import java.lang.classfile.instruction;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicationTrackingSystem {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Medication> medications;
    private List<Prescription> prescriptions;

    private Scanner scanner;

    // Constructor 
    public MedicationTrackingSystem() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        Patient patient1 = new Patient(20, "Bob", 30, "709-222-2222");
        patients.add(patient1);

        Patient patient2 = new Patient(22, "Jill", 25, "709-333-2222");
        patients.add(patient2);

        Doctor doctor1 = new Doctor(20, "Gordon", 65, "709-444-4444", "Cardiology");
        doctors.add(doctor1);

        Doctor doctor2 = new Doctor(20, "Gord", 65, "709-555-5555", "Cancer");
        doctors.add(doctor2);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Added patient: " + patient.getName());
    }

    public void displayPatients() {
        System.out.println("Patients:");
        for (Patient pat : patients) {
            System.out.println(pat);
        }
    }

    // Method to search for a patient by name - not case-sensitive - assisted by Chat GPT //

    public void searchPatient(String name) {

        List<Patient> searchResults = new ArrayList<>(); // Creating a list to store search results //

        for (Patient patient : patients) { // Loops through the list of patients //
            if (patient.getName().toLowerCase().contains(name.toLowerCase())) { //Performing a case-insensitive search //
                searchResults.add(patient); // Adds the patient to the search results //
            }
        }
        displaySearchResults(searchResults,"Patients"); // Displays the search results //
    }

    //Mehtod to search for a doctor by name - not case-sensitive //

    public void searchDoctor(String name) {

        List<Doctor> searchResults = new ArrayList<>(); //Creating a list to store search results //

        for (Doctor doctor : doctors) { // Loops through the list of doctors //
            if (doctor.getName().toLowerCase().contains(name.toLowerCase())) { //Performing a case-insensitive search //
                searchResults.add(doctor); // Adds the doctor to the search results //
            }
        }
        displaySearchResults(searchResults,"Doctors"); // Displays the search results //
    }

    //Method to search for a medication by name - not case-sensitive //

    public void searchMedication(String name) {

        List<Medication> searchResults = new ArrayList<>(); // Creating a list to store search results //

        for (Medication medication : medications) { // Loops through the list of medications //
            if (medication.getName().toLowerCase().contains(name.toLowerCase())) { //Performing a case-insensitive search //
                searchResults.add(medication); // Adds the medication to the search results //
            }
        }
        displaySearchResults(searchResults,"Medications"); // Displays the search results //
    }

    // Method to display search results - Assisted by ChatGPT//

    public void displaySearchResults(List<?> results, String type) { // Accepts a list of any type and a string - "?" is any type of list//
        if (results.isEmpty()) {
            System.out.println(type + " not found."); // Displays a message if no results are found //
        } else {
            System.out.println(type + "(s) found:"); // Displays the found search results //
            for (Object obj : results) { // Loops through the list of search results //
                System.out.println(obj); // Displays the search results //
            }
        }
    }


    // Method to search for patients, doctors, and medications by name by scanner - Assisted by ChatGPT for help and fixing syntax errors //

    public void interactiveSearch(Scanner scanner) {
        while (true) { 
            System.out.println();
            System.out.println("\nSearch Menu:");
            System.out.println();
            System.out.println("1. Search for a Patient");
            System.out.println();
            System.out.println("2. Search for a Doctor");
            System.out.println();
            System.out.println("3. Search for a Medication");
            System.out.println();
            System.out.println("4. Exit Search");
            System.out.println();
            System.out.println("Enter your choice: ");
            int searchchoice;

            try {
                searchchoice = Integer.parseInt(scanner.nextLine()); // Accepts user input //
            } catch (NumberFormatException e) { // Validates the input is a number //
                System.out.println("Invalid choice. Please enter a number.");
                continue; // Restarts the loop //
            }
            
            if (searchchoice == 4) {
                System.out.println("Exiting search...");
                break; // Exits the loop //
            }

            System.out.print("Enter name to search: "); // Prompts the user to enter a name to search //
            String searchTerm = scanner.nextLine();

            switch (searchchoice) { // Switch statement to determine the search type //
                case 1:
                    searchPatient(searchTerm); // Calls the searchPatient method //
                    break;
                case 2:
                    searchDoctor(searchTerm);  // Calls the searchDoctor method //
                    break;
                case 3:
                    searchMedication(searchTerm); // Calls the searchMedication method //
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option."); // Displays a message if an invalid option is entered //
            }
        
        }
    }
    // // Main method //
    // public static void main(String[] args) {
    //     // MedicationTrackingSystem system = new MedicationTrackingSystem(); // Creates an instance of the tracking system //
    //     Scanner scanner = new Scanner(System.in);
    //     system.interactiveSearch(scanner);
    //     scanner.close();
    // }
}
