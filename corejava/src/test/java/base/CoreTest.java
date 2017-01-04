package base;

import org.junit.Test;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YZhi on 2016/9/10.
 */
public class CoreTest {
    public static void main(String[] args) {
        ArrayAlg.getMiddle("a", "b", "c");
        System.out.println(2.0 - 1.1);//0.8999999999999999
        Scanner in = new Scanner(System.in);
        System.out.println("what is your name?");
        String name = in.nextLine();//一行
        String firstName = in.next();//一个单词，以空格作为分隔符
        int age = in.nextInt();//一个整数
        Console cons = System.console();
        String username = cons.readLine();
        char[] password = cons.readPassword();
        System.out.printf("%8.2f", 10000.0 / 3.0);
        String.format("%8.2f", 10000.0 / 3.0);

    }

    @Test
    public void run() throws Exception {
        //Scanner in = new Scanner("myfile.txt");//ERROR
        //Scanner in = new Scanner(Paths.get("myfile.txt"));
        //PrintWriter out = new PrintWriter("myfile.txt");
        //String dir = System.getProperty("user.dir");//用户的当前工作目录
        int number = 0;
        if (number > 10) {

        } else if (number > 5) {

        } else if (number > 1) {

        } else {

        }
        while (number > 0) {
            System.out.println(number);
            break;
        }
        do {
            break;
        } while (number > 0);
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        for (double i = 0; i != 10; i += 0.1) {

        }

        int[] a = new int[10];
        for (int i : a) {
            a[i] = i++;
        }
        Arrays.toString(a);

        int[] smallPrimes = {2, 3, 5};

        smallPrimes = new int[]{3, 5, 6};
    }
}


class ArrayAlg {
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }
}

