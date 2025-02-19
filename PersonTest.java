public class PersonTest {
    public static void main(String[] args) {
        // Testing Person class
        System.out.println("===🤓 Testing Person Class 🤓===");
        Person person = new Person(1, "Alice Johnson", 28, "709-853-4223");
        System.out.println(person);

        // Testing Patient class
        System.out.println("\n===🤓 Testing Patient Class 🤓===");
        Patient patient = new Patient(101, "John Doe", 30, "709-769-3210");
        System.out.println(patient);

        // Testing Doctor class
        System.out.println("\n===🤓 Testing Doctor Class 🤓===");
        Doctor doctor = new Doctor(1, "Dr. Smith", 45, "709-222-7890", "Cardiology");
        System.out.println(doctor);
    }
}
