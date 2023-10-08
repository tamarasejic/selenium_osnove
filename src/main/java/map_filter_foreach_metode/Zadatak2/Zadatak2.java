package map_filter_foreach_metode.Zadatak2;

//        2. Zadatak
//        Kreirati klasu Customer koja ima:
//        ime i prezime
//        id
//        email
//        karicu (objekat)
//        Kreirati klasu CreditCard koja ima:
//        broj kartice (string od 16 karaktera)
//        mesec do kad vazi kartica
//        godina do kad vazi kartica
//        CVC (string od 3 broja)
//        Kreirati klasu Database koja ima:
//        niz customera (array lista)
//        metodu dodaj customera koja dodaje customera u niz
//        metodu obrisi customera koja brise customera iz niza po Id-u.
//        metodu koja vraca sve id-eve customera (vraca niz stringova). Resiti pomocu map metode.
//        metodu koja vraca sve kartice customera (vraca niz kreditnih kartica). Resiti pomocu map metode.
//        metodu koja vraca sve kartice koje vaze do odrejenog meseca. Metoda prima kao parametar mesec vazenja kartice i filtrira sve kartice ciji je mesec vazenja manji od prosledjenog. Metoda vraca niz kartica. Resiti pomocu map i filter metode.
//        metodu koja vraca cvc za customera po trazenom id-u. Metoda prima kao parametar id customer i od kartice tog customera vraca cvc. Resiti pomocu filter i map metode.
//        U glavnom programu kreirati bazu podataka i u bazu dodati 5 customera, i svaki customer ima kreditnu karticu.
//        ZA SVAKI ZADATAK KOJI ZAHTAVA KORISCENJE VISE OD JEDNE LAMBDA FUNKCIJE, KORISTITI ULANCAVANJE https://javadevcentral.com/function-chaining-in-java

public class Zadatak2 {
    public static void main(String[] args) {

        CreditCard card1 = new CreditCard("54131313", 11, 2025, "258");
        CreditCard card2 = new CreditCard("66456614", 6, 2023, "369");
        CreditCard card3 = new CreditCard("64161661", 9, 2024, "147");
        CreditCard card4 = new CreditCard("94164161", 7, 2024, "111");
        CreditCard card5 = new CreditCard("71662268", 12, 2026, "222");

        Customer marko = new Customer("Marko Markovic", 1000, "marko@gmail.com", card1);
        Customer milan = new Customer("Milan Milanovic", 1069, "milan@gmail.com", card2);
        Customer stefan = new Customer("Stefan Stefanovic", 1306, "stefan@gmail.com", card3);
        Customer pera = new Customer("Pera Peric", 1025, "pera@gmail.com", card4);
        Customer aleksa = new Customer("Aleksa Aleksic", 1580, "aleksa@gmail.com", card5);

        Database database = new Database();
        database.addCustomer(marko);
        database.addCustomer(milan);
        database.addCustomer(stefan);
        database.addCustomer(pera);
        database.addCustomer(aleksa);


        database.removeCustomer(1000);
        database.getAllCustomerIDs();

        database.getAllCustomerCreditCards();
        database.getAllUpToDateCards(10);

        database.getCustomerCardCVC(1306);

    }
}
