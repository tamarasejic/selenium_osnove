package p28_09_2023;

public class UvodUIzuzetke {
    public static void main(String[] args) {

       FakeDriver driver = new FakeDriver();

       int p = 0;

       try {
           p = driver.findNextNumber(-5);
           System.out.println("TRY BLOCK");
       } catch (Exception e) {
           System.out.println("Upali smo u catch");
       }

        System.out.println("FINALLY");

    }
}
