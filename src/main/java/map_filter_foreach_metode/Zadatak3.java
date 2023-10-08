package map_filter_foreach_metode;

//        3. Zadatak
//        Napisati program koji ima niz od 10 brojeva. Niz je ArrayList<Integer> tipa.
//        Zatim pomocu foreach lambda izraza odstampati svaki element niz razdvojeni zaredom.
//        Foreach Lamba https://www.baeldung.com/foreach-java#2-lambda-expression

import java.util.ArrayList;
import java.util.Collections;

public class Zadatak3 {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers,55, 212, 98, 11, 25, 69,3, 61, 4, 888);

        numbers
                .forEach(num -> System.out.print(num + ", "));

    }
}
