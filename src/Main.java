import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        System.out.println("Список несовершеннолетних:");
        numberOfMinors(persons);
        System.out.println("Список призывников:");
        namesOfConscripts(persons);
        System.out.println("Отсортированный по фамилии список потенциально работоспособных людей с высшим образованием в выборке:");
        peopleWithHigherEducation(persons);


    }

    public static void numberOfMinors(Collection<Person> persons) {
        long count = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println(count);
    }

    public static void namesOfConscripts(Collection<Person> persons) {
        List<String> conscripts = persons.stream()
                .filter(x -> x.getAge() < 27 && x.getAge() > 18)
                .map(x -> x.getFamily().toString())
                .collect(Collectors.toList());

        conscripts.forEach(System.out::println);
    }

    public static void peopleWithHigherEducation(Collection<Person> persons) {
        List<Person> people = persons.stream()
                .filter(x -> ((x.getSex() == Sex.WOMAN && x.getAge() >= 18 && x.getAge() <= 60) ||
                        (x.getSex() == Sex.MAN) && x.getAge() >= 18 && x.getAge() <= 65))
                .filter(x -> x.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());

        people.forEach(System.out::println);

    }

}