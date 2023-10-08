package map_filter_foreach_metode.Zadatak2;

public class CreditCard {
    private String number;
    private int month;
    private int year;
    private String cvc;

    public CreditCard(String number, int month, int year, String cvc) {
        this.number = number;
        this.month = month;
        this.year = year;
        this.cvc = cvc;
    }

    public String getNumber() {
        return number;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getCvc() {
        return cvc;
    }
}
