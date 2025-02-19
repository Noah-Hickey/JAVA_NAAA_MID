
import java.time.LocalDate;
import java.util.Random;

public class Medication {
    private int id;
    private String name;
    private String dose;
    private int quantity;
    private LocalDate expirationDate;


    // Method to generate a random expiry date that includes past and future - assisted by ChatGPT//

    private LocalDate generateRandomExpiryDate() {
        Random rand = new Random();
        int DaysOffset = rand.nextInt(4 * 365) - (2 * 365); // 2 years before and after the current day //
        return LocalDate.now().plusDays(DaysOffset);
    }

    // Constructor //

    public Medication(int id, String name, String dose, int quantity) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantity = quantity;
        this.expirationDate = generateRandomExpiryDate();
    }



    // Getters //

    public int getid() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getdose() {
        return dose;
    }

    public int getquantity() {
        return quantity;
    }

    public LocalDate getExpirationDate () {
        return expirationDate;
    }

    // Setters //

    public void setName(String name) {
        this.name = name;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString method //
    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dose='" + dose + '\'' +
                ", quantity=" + quantity +
                ", expirationDate=" + expirationDate +
                '}';
    }

}