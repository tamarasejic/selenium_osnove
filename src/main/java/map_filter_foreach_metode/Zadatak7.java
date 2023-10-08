package map_filter_foreach_metode;

//        7. Zadatak
//        Koristeci klasu iz 5.zad u glavnom programu kreirati niz od 10 proizvoda, tipa ArrayList<Product>.
//        Zatim pomocu map izvuci sve cene proizvoda a zatim koristeci sum lamba sracunati ukupunu cenu svih proizvda.
//        Na kraju programa odstampati ukupnu cenu na ekranu

import map_filter_foreach_metode.Zadatak5.Product;

import java.util.ArrayList;

public class Zadatak7 {
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

        int sum = products.stream()
                .map(Product::getPrice)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);
    }
}
