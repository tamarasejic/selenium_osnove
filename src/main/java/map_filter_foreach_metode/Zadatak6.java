package map_filter_foreach_metode;

//          6. Zadatak
//          Napisati program koji ima niz od 10 brojeva. Niz je ArrayList<Integer> tipa.
//          Zatim pomocu sum lamda metode sracunati zbir svih elemenata u nizu.
//          Sum lamda https://www.baeldung.com/java-array-sum-average#find-sum-using-stream

import java.util.ArrayList;
import java.util.Collections;

public class Zadatak6 {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers,55, 212, 98, 11, 25, 69,3, 61, 4, 888);

        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

    }
}
