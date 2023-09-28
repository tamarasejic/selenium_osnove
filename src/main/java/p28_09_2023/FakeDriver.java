package p28_09_2023;

public class FakeDriver { // WebDriver driver


    public int findNextNumber(int n) throws ITBootcampException { // radi samo za pozitivne
        if (n < 0) {
            throw new ITBootcampException ("Greska! Unet je br: " + n);
        }
        return n + 1;
    }

}
