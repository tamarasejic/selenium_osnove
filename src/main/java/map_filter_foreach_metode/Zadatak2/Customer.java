package map_filter_foreach_metode.Zadatak2;

public class Customer {

    private String fullName;
    private int id;
    private String email;
    private CreditCard card;

    public Customer(String fullName, int id, String email, CreditCard card) {
        this.fullName = fullName;
        this.id = id;
        this.email = email;
        this.card = card;
    }

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
