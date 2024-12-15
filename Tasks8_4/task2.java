import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class task2 {
    
    // Filter out all the even numbers from the list.
    public static List<Integer> filterEvenNumbersOut(List<Integer> numbers) {
        return numbers.stream().filter(x -> x % 2 !=0).collect(Collectors.toList());
    }

    // Double each remaining number.
    public static List<Integer> doubleRemainingNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> x * 2).collect(Collectors.toList());
    }

    // Find the sum of the resulting numbers.
    public static int sumEverything(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    // Main function
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 6, 2, 8, 9, 4);

        System.out.println("The original List: " + numbers);

        numbers = filterEvenNumbersOut(numbers);
        System.out.println("Filtered list" + numbers);

        numbers = doubleRemainingNumbers(numbers);
        System.out.println("Double remaining List: " + numbers);

        int result = sumEverything(numbers);
        System.out.println("Sums the list: " + result);
    }
}
