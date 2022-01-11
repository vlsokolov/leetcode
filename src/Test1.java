import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println(calc(reader.readLine(), reader.readLine()));
    }

    public static int calc(String amount, String input) {

        int size = Integer.parseInt(amount);
        String[] numbers = input.split(" ");

        int leftToRightSum = 0;
        int rightToLeftSum = 0;

        int[] leftToRight = new int[size];
        int[] rightToLeft = new int[size];

        for (int i = 0; i < numbers.length; i++) {
            leftToRightSum += Integer.parseInt(numbers[i]);
            rightToLeftSum += Integer.parseInt(numbers[numbers.length-i-1]);

            leftToRight[i] = leftToRightSum;
            rightToLeft[numbers.length-i-1] = rightToLeftSum;
        }

        int count = 0;

        for (int i = 0; i < size; i++) {
            if (i + 1 < size && leftToRight[i] == rightToLeft[i+1]) {
                count++;
            }
        }
        return count;
    }
}
