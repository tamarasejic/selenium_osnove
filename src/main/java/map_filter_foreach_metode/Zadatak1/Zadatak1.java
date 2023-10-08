package map_filter_foreach_metode.Zadatak1;

//        1.Zadatak
//        Kreirati klasu Zadatak1 sa main metodom i u njoj:
//        Kreirati niz gradova (niz od minimum 10 gradova)
//        Potrebno je imati jos par niza u programu.
//        1. Niz gradova koji krecu na slovo B. Iz originalnog niza filtrirati sve gradove koji krecu na slovo B.
//        Upoznaj se sa metodom filter https://www.geeksforgeeks.org/stream-filter-java-examples/ .
//        Zatim nakon filtriranja iskoristii foreach metodu niza da se niz odstampa u konzoli.
//        2. Niz gradova ciji naziv ima vise od 7 karaktera u nazivu.
//        iz originalnog niza filtrirati sve gradove koji imaju preko 7 karaktera u nazivu.
//        3. Niz koji cuva duzine naziva gradova. Npr: ako je origanalan niz gradova:
//        “Beograd”, “Nis”, “Novi Sad”, “Leskovac”, ovaj niz ce imati vrednosti 7, 3, 8, 8.
//        Iskorititi map metodu za kreiranje ovog niza.
//        Upoznaj se sa map metodom https://www.geeksforgeeks.org/javascript-array-map-method/

import java.util.ArrayList;
import java.util.stream.Stream;

public class Zadatak1 {
    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Tokio");
        cities.add("Jakarta");
        cities.add("Delhi");
        cities.add("Guangzhou");
        cities.add("Mumbai");
        cities.add("Manila");
        cities.add("Shanghai");
        cities.add("Sao Paulo");
        cities.add("Seoul");
        cities.add("Mexico City");
        cities.add("Nis");
        cities.add("Belgrade");
        cities.add("Novi Sad");
        cities.add("New York");
        cities.add("Moscow");

//        1. Niz gradova koji krecu na slovo S.

        Stream<String> stream = cities.stream();
        stream
                .filter(str -> str.toUpperCase().startsWith("S"))
                .forEach(System.out::println);


//        2. Niz gradova ciji naziv ima vise od 7 karaktera u nazivu.

        Stream<String> stream1 = cities.stream();
        stream1
                .filter(str -> str.length() > 7)
                .forEach(System.out::println);

//      3. Niz koji cuva duzine naziva gradova.

        Stream<String> stream2 = cities.stream();

        stream2
                .map(String::length)
                .forEach(System.out::println);

    }
}
