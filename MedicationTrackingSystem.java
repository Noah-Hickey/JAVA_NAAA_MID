// import java.lang.classfile.instruction;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MedicationTrackingSystem{
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Medication> medications;
    private List<Prescription> prescriptions;

    public Scanner scanner;

    // Constructor 
    public MedicationTrackingSystem() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        scanner = new Scanner(System.in);

        Patient patient1 = new Patient(20, "Bob", 30, "709-222-2222");
        patients.add(patient1);

        Patient patient2 = new Patient(22, "Jill", 25, "709-333-2222");
        patients.add(patient2);

        Patient patient3 = new Patient(23, "Jack", 35, "709-444-2222");
        patients.add(patient3);

        Patient patient4 = new Patient(24, "Gill", 25, "709-555-2222");
        patients.add(patient4);

        Doctor doctor1 = new Doctor(1, "Gordon", 65, "709-444-4444", "Cardiology");
        doctors.add(doctor1);

        Doctor doctor2 = new Doctor(2, "Gord", 65, "709-555-5555", "Cancer");
        doctors.add(doctor2);

        Doctor doctor3 = new Doctor(3, "Gordy", 65, "709-666-6666", "Pediatrics");
        doctors.add(doctor3);

        Medication med1 = new Medication(1, "Tylenol", "10mg", 5);
        medications.add(med1);

        Medication med2 = new Medication(2, "Advil", "20mg", 10);
        medications.add(med2);

        Medication med3 = new Medication(3, "Marijuana", "3.5g", 5);
        medications.add(med3);

        Medication med4 = new Medication(4, "Morphine", "5mg", 5);
        medications.add(med4);

        Medication med5 = new Medication(5, "Penicillin", "10mg", 5);
        medications.add(med5);

        Medication med6 = new Medication(6, "Chocolate", "1.5kg", 5);
        medications.add(med6);

        Prescription script1 = new Prescription(doctor1, patient1, med1);
        prescriptions.add(script1);

        Prescription script2 = new Prescription(doctor2, patient2, med2);
        prescriptions.add(script2);

        Prescription script3 = new Prescription(doctor3, patient3, med3);
        prescriptions.add(script3);

        Prescription script4 = new Prescription(doctor1, patient4, med3);
        prescriptions.add(script4);

        Prescription script5 = new Prescription(doctor2, patient1, med3);
        prescriptions.add(script5);
    }

    public void displayPatients() {
        System.out.println("\n=== List of Patients ===\n");
        for (Patient pat : patients) {
            System.out.println(pat);
        }
    }

    public void displayDoctors() {
        System.out.println("\n=== List of Doctors ===\n");
        for (Doctor doc : doctors) {
            System.out.println(doc);
        }
    }

    public void displayMedications() {
        System.out.println("\n=== List of Medications ===\n");
        for (Medication med : medications) {
            System.out.println(med);
        }
    }

    public void assignPatientToDoctor() {
        System.out.println("\n=== Assign a Patient to a Doctor ===");

        displayPatients();

        System.out.print("\nEnter the Patient ID: ");
        int patientID = scanner.nextInt();
        scanner.nextLine();  

        Patient selectedPatient = findPatientByID(patientID);
        if (selectedPatient == null) {
            System.out.println("\nError: Invalid Patient ID.");
            return;
        }

        displayDoctors();
        
        System.out.print("\nEnter the Doctor ID: ");
        int doctorID = scanner.nextInt();
        scanner.nextLine();  

        Doctor selectedDoctor = findDoctorByID(doctorID);
        if (selectedDoctor == null) {
            System.out.println("Error: Invalid Doctor ID.");
            return;
        }

        selectedDoctor.addPatient(selectedPatient);
        System.out.println("\nSuccess! " + selectedPatient.getName() + " has been assigned to Dr. " + selectedDoctor.getName());
    }

    // Method to accept a prescription //
    public void acceptPrescription(int patientID, int doctorID, int medicationID) {
        Patient patient = findPatientByID(patientID);
        Doctor doctor = findDoctorByID(doctorID);
        Medication medication = findMedicationByID(medicationID);

        if (patient == null || doctor == null || medication == null) {
            System.out.println("Error: Invalid patient, doctor, or medication ID.");
            return;
        }

        Prescription newPrescription = new Prescription(doctor, patient, medication);
        prescriptions.add(newPrescription);
        patient.addPrescription(newPrescription);

        System.out.println("\nSuccess! Prescription added for " + patient.getName() + ". Prescribed by Dr. " + doctor.getName());
    }

    // Method to find a patient by ID //
    private Patient findPatientByID (int id) {
        for (Patient p : patients) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    // Method to find a doctor by ID //
    private Doctor findDoctorByID (int id) {
        for (Doctor d : doctors) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    // Method to find a medication by ID //
    private Medication findMedicationByID(int id) {
        for (Medication m : medications) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    // Method to generate a report //
    public void generateReport() {
        System.out.println("\n=====================================");
        System.out.println("       MEDICATION SYSTEM REPORT");
        System.out.println("=====================================\n");

        System.out.println("Doctors:");
        for (Doctor doc : doctors) {
            System.out.println("- " + doc);
        }

        System.out.println("\nPatients:");
        for (Patient pat : patients) {
            System.out.println("- " + pat);
        }

        System.out.println("\nMedications:");
        for (Medication med : medications) {
            System.out.println("- " + med);
        }

        System.out.println("\nPrescriptions:");
        for (Prescription pres : prescriptions) {
            System.out.println("\n" + pres);
        }

        System.out.println("\n=================================");
        System.out.println("         END OF REPORT");
        System.out.println("=================================");
    }

    // A function to check if a medication is expired and print a message //
    public void checkExpiredMeds() {
        System.err.println("\nChecking for expired medications...\n");

        for (Medication med : medications) {
            if (med.getExpirationDate() != null && med.getExpirationDate().isBefore(LocalDate.now()))  {
                System.out.println(" - Medication " + med.getName() + " expired on " + med.getExpirationDate() + "!");
            }
        }

        if (medications.stream().noneMatch(med -> med.getExpirationDate().isBefore(java.time.LocalDate.now()))) {
            System.out.println("No expired medications found.");
        }
    }

    // Method to search for a patient by name - not case-sensitive //
    public void searchPatient(String name) {

        List<Patient> searchResults = new ArrayList<>(); 

        for (Patient patient : patients) { 
            if (patient.getName().toLowerCase().contains(name.toLowerCase())) { 
                searchResults.add(patient); 
            }
        }
        displaySearchResults(searchResults,"Patients"); 
    }

    //Mehtod to search for a doctor by name - not case-sensitive //
    public void searchDoctor(String name) {

        List<Doctor> searchResults = new ArrayList<>(); 

        for (Doctor doctor : doctors) { 
            if (doctor.getName().toLowerCase().contains(name.toLowerCase())) { 
                searchResults.add(doctor); 
            }
        }
        displaySearchResults(searchResults,"Doctors"); 
    }

    //Method to search for a medication by name - not case-sensitive //
    public void searchMedication(String name) {

        List<Medication> searchResults = new ArrayList<>(); 

        for (Medication medication : medications) { 
            if (medication.getName().toLowerCase().contains(name.toLowerCase())) {
                searchResults.add(medication); 
            }
        }
        displaySearchResults(searchResults,"Medications"); 
    }

    // Method to display search results //
    public void displaySearchResults(List<?> results, String type) { // Accepts a list of any type and a string - "?" is any type of list//
        if (results.isEmpty()) {
            System.out.println(type + " not found."); 
        } else {
            System.out.println(type + "(s) found:"); 
            for (Object obj : results) { 
                System.out.println(obj); 
            }
        }
    }

    // Method to search for patients, doctors, and medications by name by scanner //
    public void interactiveSearch() {
        boolean searching = true;
        while (searching) {  
            System.out.println("\nSearch Menu:");
            System.out.println("\n1. Search for a Patient");
            System.out.println("2. Search for a Doctor");
            System.out.println("3. Search for a Medication");
            System.out.println("4. Exit Search");
            System.out.println("\nEnter your choice: \n");
            int searchchoice;

            try {
                searchchoice = Integer.parseInt(scanner.nextLine()); 
            } catch (NumberFormatException e) { // Validates the input is a number //
                System.out.println("Invalid choice. Please enter a number.");
                continue; // Restarts the loop //
            }
            
            if (searchchoice == 4) {
                System.out.println("Exiting search...");
                searching = false;
                continue;
            }

            System.out.print("Enter name to search: "); 
            String searchTerm = scanner.nextLine();

            switch (searchchoice) { // Switch statement to determine the search type //
                case 1 -> searchPatient(searchTerm);
                case 2 -> searchDoctor(searchTerm);
                case 3 -> searchMedication(searchTerm);
                default -> System.out.println("Invalid choice! Please enter a valid option.");
            }
        
        }
    }
    

    // Prints a report for prescriptions associated with a specific Doctor //
    public void generateDoctorReport(int doctorID) {
    
        Doctor doctor = findDoctorByID(doctorID);
        
        if (doctor == null) {
            System.out.println("Error: Doctor ID not found.");
        return;
    }

        System.out.println("\n=== Prescriptions for Dr. " + doctor.getName() + " ===");

        boolean hasPrescriptions = false;
        for (Prescription pres : prescriptions) {
            if (pres.getDoctor().getId() == doctorID) {
                System.err.println("");
                System.out.println(pres);
                hasPrescriptions = true;
            }
        }

        if (!hasPrescriptions) {
            System.out.println("No prescriptions found for Dr. " + doctor.getName());
        }
}

    // Method to edit a patient, doctor, or medication //
    public void editPatient() {
        

        // print list of patients //
        for (Patient patient : patients) {
            System.out.println(patient);
        }

        System.out.println("\nEnter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Patient patient = findPatientByID(id);
        if (patient == null) {
            System.out.println("Error: Patient ID not found.");
            return;
        }

        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        patient.setName(name);

        System.out.println("Enter new age: ");
        int age = scanner.nextInt();
        patient.setAge(age);

        System.out.println("Enter new phone number: ");
        String phone = scanner.next();
        patient.setPhoneNumber(phone);

        System.out.println("Patient updated successfully!");
    }

    // Method to edit a doctor //
    public void editDoctor() {
        
        displayDoctors();

        System.out.println("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Doctor doctor = findDoctorByID(id);
        if (doctor == null) {
            System.out.println("Error: Doctor ID not found.");
            return;
        }

        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        doctor.setName(name);

        System.out.println("Enter new age: ");
        int age = scanner.nextInt();
        doctor.setAge(age);

        System.out.println("Enter new phone number: ");
        String phone = scanner.next();
        doctor.setPhoneNumber(phone);

        System.out.println("Enter new specialty: ");
        String specialty = scanner.nextLine();
        doctor.setSpecialization(specialty);

        System.out.println("Doctor updated successfully!");
    }

    // Method to edit a medication //
    public void editMedication() {
        
        displayMedications();

        System.out.println("Enter Medication ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Medication medication = findMedicationByID(id);
        if (medication == null) {
            System.out.println("Error: Medication ID not found.");
            return;
        }

        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        medication.setName(name);

        System.out.println("Enter new dosage: ");
        String dosage = scanner.next();
        medication.setDose(dosage);

        System.out.println("Enter new quantity: ");
        int quantity = scanner.nextInt();
        medication.setQuantity(quantity);

        System.out.println("Medication updated successfully!");
    }

    // Restocking Medications  //
    public void restockMedications() {
        if (medications.isEmpty()) {
            System.out.println("No medications found to restock.");
        return;
        }

        displayMedications();
        while (true) { 
        
            displayMedications();

            System.out.println("\nRestocking Menu:");
            System.out.println("1. Restock all medications automatically");
            System.out.println("2. Restock a specific medication");
            System.out.println("3. Return to Main Menu");
            System.out.print("\nEnter your choice: \n");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number.");
                continue;
            }

        // Automatic Restocking //

            if (choice == 1) {
                Random rand = new Random();
                System.out.println("Restocking All Medications...\n");
                for (Medication med : medications) {
                    int restockAmount = rand.nextInt(51) + 10; // Randomly gets a stock amount between 10 and 60. //
                    med.setQuantity(med.getQuantity() + restockAmount);
                    System.out.println("Restocked " + med.getName() + " by " + restockAmount + ". New Quantity: " + med.getQuantity());
                }
                System.out.println("Medications have been restocked successfully!");

            // Restocking by medication ID // 
            } else if (choice == 2) {
                System.out.println("Enter medication ID to restock");

                displayMedications(); 

                while (true) { 
                    System.out.println("\nEnter the Medication ID to restock (or type 'exit' to return to Main Menu): ");
                    String input = scanner.nextLine().trim();
            
                    if (input.equalsIgnoreCase("exit")) {
                        System.out.println("Returning to Main Menu...");
                        return;
                    }
            
                    int medID;
                    try {
                        medID = Integer.parseInt(input); // Converts input to integer //
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter a valid numeric Medication ID.");
                        continue;
                    }
            
                    Medication foundMed = findMedicationByID(medID);
                    if (foundMed == null) {
                        System.out.println("Error: Medication ID not found. Try again.");
                        continue;
                    }
            
                    System.out.println("Enter the quantity to add: ");
                    int restockAmount;
                    try {
                        restockAmount = Integer.parseInt(scanner.nextLine());
                        if (restockAmount < 0) {
                            System.out.println("Error: Invalid amount. Please enter a positive number.");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid input. Please enter a valid number.");
                        continue;
                    }
            
                    foundMed.setQuantity(foundMed.getQuantity() + restockAmount);
                    System.out.println("Successfully restocked " + foundMed.getName() + " by " + restockAmount + ". New Quantity: " + foundMed.getQuantity());
                    return; 
                }
            }
        }
    }

    // Method to add a new patient //
    public void addANewPatient() {
        System.out.println("\nEnter Patient Details:");
    
        System.out.print("Enter Patient's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
    
        System.out.print("Enter Patient's Name: ");
        String name = scanner.nextLine();
    
        System.out.print("Enter Patient's Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
    
        System.out.print("Enter Patient's Phone #: ");
        String phone = scanner.nextLine();
    
        Patient newPatient = new Patient(id, name, age, phone);
        patients.add(newPatient);
        
        System.out.println("Patient added successfully: " + newPatient);
    }
    
    // Method to add a doctor //
    public void addANewDoctor() {

        System.out.println("\nEnter Doctor Details: ");
        System.out.println("Enter Doctor's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Doctor's Name: ");
        String name = scanner.nextLine();
    
        System.out.println("Enter Doctor's Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Phone #: ");
        String phone = scanner.nextLine();

        System.out.println("Enter Doctor's Specialty: ");
        String specialty = scanner.nextLine();

        Doctor newDoctor = new Doctor(id, name, age, phone, specialty);
        doctors.add(newDoctor);
        System.out.println("Doctor added successfully: " + newDoctor);
    }

    // Method to add a new medication //
    public void addANewMedication () {
        System.out.println("\nEnter Medication Details: ");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
    
        System.out.print("Name: ");
        String name = scanner.nextLine();
    
        System.out.print("Dose: ");
        String dose = scanner.nextLine();
    
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        LocalDate expirationDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
        while (expirationDate == null) {
            System.out.print("Enter Expiration Date (yyyy-MM-dd): ");
            String dateInput = scanner.nextLine();
            try {
                expirationDate = LocalDate.parse(dateInput, formatter);
                if (expirationDate.isBefore(LocalDate.now())) {
                    System.out.println("\nWarning: This medication is already expired.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("\nInvalid date format. Please use yyyy-MM-dd.");
            }
        }
    
        Medication newMedication = new Medication(id, name, dose, quantity, expirationDate);
        medications.add(newMedication);
        System.out.println("\nMedication added successfully: " + newMedication);
    }

    // Method to remove patient by ID and if not found will display a message //
    public void removePatient() {
        while (true) { 
            
            displayPatients();

            System.out.print("\nEnter Patient ID to remove (or type 'exit' to return to Main Menu): ");

            
            String input = scanner.nextLine().trim();
    
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Returning to Main Menu...");
                return;
            }
    
            int id;
            try {
                id = Integer.parseInt(input); 
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid numeric Patient ID.");
                continue;
            }
    
            Patient foundPatient = null;
            for (Patient patient : patients) {
                if (patient.getId() == id) {
                    foundPatient = patient;
                    break;
                }
            }
    
            if (foundPatient != null) {
                patients.remove(foundPatient);
                System.out.println("Patient removed: " + foundPatient.getName());
                return; 
            } else {
                System.out.println("Error: Patient ID not found. Try again or type 'exit' to return to the Main Menu.");
            }
        }
    }

    // Method to remove doctor and if not found will display a message //
    public void removeDoctor() {
    while (true) { 
        
        // Print list of doctors //
        System.out.println("\nList of Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
        
        System.out.print("\nEnter Doctor ID to remove (or type 'exit' to return to Main Menu): ");
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("exit")) {
            System.out.println("Returning to Main Menu...");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid numeric Doctor ID.");
            continue;
        }

        Doctor foundDoctor = null;
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                foundDoctor = doctor;
                break;
            }
        }

        if (foundDoctor != null) {
            doctors.remove(foundDoctor);
            System.out.println("Doctor removed: " + foundDoctor.getName());
            return;
        } else {
            System.out.println("Error: Doctor ID not found. Try again or type 'exit' to return to the Main Menu.");
        }
    }
}

    // Method to remove medication and if not found will display a message //
    public void removeMedication() {
        
        // List of medications //
        System.out.println("\nList of Medications:");
        for (Medication medication : medications) {
            System.out.println(medication);
        }
        
        while (true) { 
            System.out.print("\nEnter Medication ID to remove (or type 'exit' to return to Main Menu): ");
            String input = scanner.nextLine().trim();
    
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Returning to Main Menu...");
                return;
            }
    
            int id;
            try {
                id = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid numeric Medication ID.");
                continue;
            }
    
            Medication foundMedication = null;
            for (Medication medication : medications) {
                if (medication.getId() == id) {
                    foundMedication = medication;
                    break;
                }
            }
    
            if (foundMedication != null) {
                medications.remove(foundMedication);
                System.out.println("Medication removed: " + foundMedication.getName());
                return;
            } else {
                System.out.println("Error: Medication ID not found. Try again or type 'exit' to return to the Main Menu.");
            }
        }
    }
}
