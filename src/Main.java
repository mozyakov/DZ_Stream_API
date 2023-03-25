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

        long ageLess18 = persons.stream()   //первый стрим подсчет несовершеннолетних
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Кол-во несовершеннолетних " + ageLess18);  //кол-во несовершеннолетних
        System.out.println("========="); //для удобства чтения

        List<String> manForWar = persons.stream()   //второй стрим список фамилий призывников
                .filter(person -> (person.getAge() >= 18) && (person.getAge() < 27))
                .filter(person -> person.getSex() == Sex.MAN)
                .map(person -> person.getFamily())
                .collect(Collectors.toList());
        System.out.println("Список фамилий призывников " + manForWar);
        System.out.println("========="); //для удобства чтения

        List<Person> peoplesForWork = persons.stream()   //третий стрим способные к работе отсортированный по фамилиям
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> (person.getAge() >= 18))
                .filter (person -> {
                    if(person.getSex() == Sex.MAN) {
                        return person.getAge() < 65;
                } else if (person.getSex() == Sex.WOMAN && person.getAge() < 60) {
                        return person.getAge() < 60;
                    }
                    return false;
                })
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(peoplesForWork);
        System.out.println("========="); //для удобства чтения
    }
}