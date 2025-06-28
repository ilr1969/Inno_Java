package Homework_1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class TestRunner {
    public static void runTests(Class c) throws InvocationTargetException, IllegalAccessException {
        Class myClass = c.asSubclass(Object.class);
        int beforeSuiteCount = 0;
        int afterSuiteCount = 0;

        for (Method method : myClass.getMethods()) {

            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteCount++;
                if (beforeSuiteCount > 1) {
                    System.out.println("Найдено больше одной аннотации BeforeSuite");
                }
            }

            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteCount++;
                if (afterSuiteCount > 1) {
                    System.out.println("Найдено больше одной аннотации AfterSuite");
                }
            }
        }

        if (beforeSuiteCount == 1) {
            for (Method method : myClass.getMethods()) {
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    method.invoke(myClass);
                }
            }
        }

        var listTestMethods = new ArrayList<Method>();
        for (Method method : myClass.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                listTestMethods.add(method);

            }
        }

        var sortedByPriority = listTestMethods.stream().sorted(Comparator.comparing(m -> m.getAnnotation(Test.class).priority()));

        sortedByPriority.forEach(result -> {
            try {
                result.invoke(myClass);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });

        if (afterSuiteCount == 1) {
            for (Method method : myClass.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(AfterSuite.class)) {
                    method.invoke(myClass);
                }
            }
        }
    }
}



