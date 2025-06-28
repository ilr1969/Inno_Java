package Homework_2;

public class Engineer {
    String name;
    int age;
    String jobTitle;

    public Engineer(String name, int age, String jobTitle) {
        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return jobTitle + "\t" + age + "\t" + name + "\n";
    }
}
