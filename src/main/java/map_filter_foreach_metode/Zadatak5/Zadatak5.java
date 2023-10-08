package map_filter_foreach_metode.Zadatak5;

//        5. Zadatak
//        Kreirati klasu Product koja ima:
//        naziv
//        cenu (int)
//        U glavnom programu kreirati niz od 10 proizvoda, tipa ArrayList<Product>.
//        Zatim pomocu foreach lambda izraza odstampati podatke svih proizvoda.
//        Proizvod se stampa u formatu
//        naziv - $ cena
//        Primer:
//        Nike patika - $120

import java.util.ArrayList;

public class Zadatak5 {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Bread", 50));
        products.add(new Product("Salt", 15));
        products.add(new Product("Pasta", 300));
        products.add(new Product("Orange Juice", 200));
        products.add(new Product("Tomato", 150));
        products.add(new Product("Potato", 75));
        products.add(new Product("Basil", 5));
        products.add(new Product("Coca-cola", 120));
        products.add(new Product("Fanta", 115));
        products.add(new Product("Wine", 1200));

        products
                .forEach(product -> System.out.println(product.getName() + " - $" + product.getPrice()));
    }
}
