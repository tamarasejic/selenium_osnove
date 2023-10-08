package map_filter_foreach_metode;

//        4. Zadatak
//        Napisati program koji ima niz od 10 brojeva. Niz je ArrayList<Integer> tipa. Zatim pomocu map lambda izaraza zameniti znak svakog broja i pomocu lambda foreach-a proci kroz niz i odstampati elemente.
//        Primer: ako je niz = 1,-2,3,4,-5,6,7,8,-9,10
//        stampa se -1,2,-3,-4,5,-6,-7,-8,9,-10

import java.util.ArrayList;
import java.util.Collections;

public class Zadatak4 {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers,55, -212, -98, 11, 25, -69,3, 61, 4, -888);

        numbers.stream()
                .map(n -> n * -1)
                .forEach(num -> System.out.print(num + ", "));
    }
}
