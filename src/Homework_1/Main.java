package Homework_1;


import java.lang.reflect.InvocationTargetException;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        MyClass myClass = new MyClass();
        TestRunner runner = new TestRunner();
        runner.runTests(myClass);
    }
}

