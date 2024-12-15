import java.util.List;
import java.util.stream.Stream;
import java.util.Arrays;

class task1 {
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 6, 2, 8, 9, 4);
        Stream<Integer> stream = numbers.stream();

        int result = stream.reduce(0, Integer::sum);
        int mean = result / numbers.size();

        System.out.println("Mean result: " + mean);
    }
}