
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("How many random numbers should be printed?");

        int number = Integer.valueOf(scanner.nextLine());
        
        for (int i = 0; i < number; i++){
            System.out.println(random.nextInt(11));
        }
    }

}
