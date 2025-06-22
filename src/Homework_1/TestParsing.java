package Homework_1;

import java.util.ArrayList;
import java.util.Arrays;

public class TestParsing {
    @CsvSource
    public void testMethod(int a, String b, int c, boolean d) {

        System.out.println(a + " " + b + " " + c + " " + d);
        System.out.println(a + c);
        System.out.println(d);
    }
}
