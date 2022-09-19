import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1);
        fibonacci.add(1);
        Scanner sc = new Scanner(System.in);
        List<Integer> test = new ArrayList<>();
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int testNum = sc.nextInt();
            test.add(testNum);
        }

        for (int i = 2; i<=40; i++) {
            fibonacci.add(fibonacci.get(i-2) + fibonacci.get(i-1));
        }

        for (int i = 0; i<test.size(); i++) {
            if(test.get(i) == 0) {
                System.out.println("1 0");
            } else if(test.get(i) == 1) {
                System.out.println("0 1");
            } else {
                System.out.println(fibonacci.get(test.get(i)-2) + " " + fibonacci.get(test.get(i)-1));
            }
        }


    }

}