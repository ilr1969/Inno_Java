package Homework_1;

public class MyClass {

    @Test
    public void Calc1() {
        System.out.println("Приоритет по умолчанию");
    }

    @BeforeSuite
    public void Calc2() {
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public void Calc3() {
        System.out.println("AfterSuite");
    }

    @Test(priority = 2)
    public void Calc4() {
        System.out.println("Приоритет 2");
    }

    @Test(priority = 6)
    public void Calc5() {
        System.out.println("Приоритет 6");
    }

    @Test(priority = 9)
    public void Calc6() {
        System.out.println("Приоритет 9");
    }
}
