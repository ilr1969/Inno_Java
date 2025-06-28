package Homework_2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.maxNumber();
        main.maxDistinctNumber();
        main.oldestEngineers();
        main.getEngineersAvgAge();
        main.longestWord();
        main.countWords();
        main.sortedWords();
        main.longestWordFromArray();
    }

    public void maxNumber() {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 10, 9, 4, 3, 10, 1, 13));
        System.out.println("Третье наибольшее число");
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).stream().skip(2).findFirst().get());
    }

    public void maxDistinctNumber() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(5, 2, 10, 9, 4, 3, 10, 1, 13));
        System.out.println("\n" + "Третье наибольшее уникальное число");
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList()).stream().skip(2).findFirst().get());
    }

    public void oldestEngineers() {
        List<Engineer> list = new ArrayList<>(
                List.of(
                        new Engineer("Петрович", 65, "Инженер"),
                        new Engineer("Никита", 29, "Сантехник"),
                        new Engineer("Гриша", 37, "Инженер"),
                        new Engineer("Вася", 18, "Инженер"),
                        new Engineer("Новичок", 24, "Грузчик"),
                        new Engineer("Костя", 22, "Инженер"),
                        new Engineer("Надя", 44, "Бухгалтер"),
                        new Engineer("Маша", 30, "Диспетчер"),
                        new Engineer("Иваныч", 56, "Инженер"),
                        new Engineer("Петрович 2", 63, "Слесарь"),
                        new Engineer("Василич", 54, "Слесарь")
                )
        );
        System.out.println("\n" + "Три наиболее возрастных инженера");
        System.out.println(list.stream().sorted((e1, e2) -> e2.age - e1.age).collect(Collectors.toList()).stream().filter(e -> Objects.equals(e.jobTitle, "Инженер")).collect(Collectors.toList()).stream().limit(3).collect(Collectors.toList()));
    }

    public void getEngineersAvgAge() {
        List<Engineer> list = new ArrayList<>(
                List.of(
                        new Engineer("Петрович", 65, "Инженер"),
                        new Engineer("Никита", 29, "Сантехник"),
                        new Engineer("Гриша", 37, "Инженер"),
                        new Engineer("Вася", 18, "Инженер"),
                        new Engineer("Новичок", 24, "Грузчик"),
                        new Engineer("Костя", 22, "Инженер"),
                        new Engineer("Надя", 44, "Бухгалтер"),
                        new Engineer("Маша", 30, "Диспетчер"),
                        new Engineer("Иваныч", 56, "Инженер"),
                        new Engineer("Петрович 2", 63, "Слесарь"),
                        new Engineer("Василич", 54, "Слесарь")
                )
        );
        System.out.println("\n" + "Средний возраст инженеров");
        System.out.println(list.stream().filter(e -> Objects.equals(e.jobTitle, "Инженер")).collect(Collectors.toList()).stream().map(e -> e.age).collect(Collectors.toList()).stream().mapToInt(a -> a).average().getAsDouble());
    }

    public void longestWord() {
        List<String> list = new ArrayList<>(Arrays.asList("Огурец", "Яблоко", "Апельсин", "Киви", "Банан"));
        System.out.println("\n" + "Самое длинное слово");
        System.out.println(list.stream().max(Comparator.comparingInt(String::length)).get());
    }

    public void countWords() {
        String words = "огурец яблоко апельсин киви банан яблоко апельсин киви киви";
        System.out.println("\n" + "Слово + количество в строке");
        Arrays.stream(words.split(" ")).collect(Collectors.groupingBy(w -> w, Collectors.counting())).forEach((k, v) -> System.out.println(k + " : " + v));
    }

    public void sortedWords() {
        String words = "огурец яблоко апельсин личи банан мандарин киви";
        System.out.println("\n" + "Сортировка по длине, затем по алфавиту");
        Arrays.stream(words.split(" ")).sorted().collect(Collectors.toList()).stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList()).forEach(System.out::println);
    }

    public void longestWordFromArray() {
        ArrayList<String> array = new ArrayList<>(
                List.of(
                "огурец личи апельсин",
                " яблоко мандарин банан киви"
                )
        );
        System.out.println("\n" + "Выбор самого длинного слова из массива строк");
        System.out.println(array.stream().map(e -> Arrays.stream(e.split(" ")).max(Comparator.comparingInt(String::length)).get()).collect(Collectors.toList()).stream().max(Comparator.comparingInt(String::length)).get());
    }
}

