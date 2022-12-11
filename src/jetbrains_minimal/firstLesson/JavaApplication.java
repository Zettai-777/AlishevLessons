package jetbrains_minimal.firstLesson;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaApplication {

    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        double a = Long.MAX_VALUE;
        long b = Long.MAX_VALUE;
        int c = 1;
        char z = 'a';
        z *= 1.2;
        int x = 25;
//        System.out.println(a + b + c);
//        System.out.println(c + b + a);
        System.out.println(z);
        System.out.println((int)z);
        System.out.println(x);
        {
            x = 255;
            System.out.println(x);
        }
        System.out.println(x);
        try {
            method();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void method() throws IOException {
        int res = Integer.parseInt(reader.readLine());
        if (Character.isDigit(res))
            System.out.println("Greater than 10");
            if (res > 100)
                System.out.println("Greater than 10 and 100");
        else
            System.out.println("Less than 0 or equals 0");
    }

}
