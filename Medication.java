
import java.time.LocalDate;

public class Medication {
    private int id;
    private String name;
    private String dose;
    private int quantity;
    private LocalDate expirationDate;

    // Constructors //

    // With an expiry date specified //
    public Medication(int id, String name, String dose, int quantity, LocalDate expirationDate) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    // Without a specified expiry date //
    public Medication(int id, String name, String dose, int quantity) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantity = quantity;
        this.expirationDate = LocalDate.now().plusYears(1); // Default: 1 year from today if not specified//
    }

    // Getters //

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDose() {
        return dose;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getExpirationDate() { 
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

    public void setExpirationDate(LocalDate expirationDate) { 
        this.expirationDate = expirationDate; 
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
