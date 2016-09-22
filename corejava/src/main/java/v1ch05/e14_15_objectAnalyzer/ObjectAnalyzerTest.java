package v1ch05.e14_15_objectAnalyzer;

import java.util.ArrayList;

/**
 * This program uses e13_reflection to spy on objects.
 *
 * @author Cay Horstmann
 * @version 1.12 2012-01-26
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++)
            squares.add(i * i);
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}