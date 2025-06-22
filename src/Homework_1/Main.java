package Homework_1;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        MyClass myClass = new MyClass();
        TestRunner runner = new TestRunner();
        runner.runTests(myClass);

        System.out.println("\n");

//        Задание со *

        TestParsing testParsing = new TestParsing();

//        Тут нужен комментарий, нужно ли выдёргивать параметр аннотации метода
    //    var parcedParameter = testParsing.getClass().getMethod("testMethod").getAnnotation(CsvSource.class).value.split(", ");
//        Или можно напрямую обращаться к аннотации (тоже работает, и Idea подсказала такой вариант)
        var parcedParameter = CsvSource.value.split(", ");
//        Или есть правильный способ решения задачи

        var a = Integer.parseInt(parcedParameter[0]);
        var b = parcedParameter[1];
        var c = Integer.parseInt(parcedParameter[2]);
        var d = Boolean.parseBoolean(parcedParameter[3]);

        testParsing.testMethod(a, b, c, d);
    }
}


