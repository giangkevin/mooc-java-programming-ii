
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
        List<Integer> inputs = new ArrayList<>();
        while (true){
            String row = scanner.nextLine();
            if (row.equals("end")){
                break;
            }
            int number = Integer.valueOf(row);
            inputs.add(number);
        }

        
        System.out.println(positive(inputs));
    }
    
    public static List<Integer> positive(List<Integer> numbers){
        return numbers.stream().filter(number -> number > 0).collect(Collectors.toList());
    }
}
