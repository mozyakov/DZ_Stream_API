import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays.*;
import java.util.Comparator;
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        /*for (Person person : persons) { //пример чтоб вывести список
            System.out.println(person);
        }
        System.out.println("=========");*/
        List<Person> peoplesForWork = persons.stream()
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
                //.sorted(person (p1, p2) -> p1.person.getFamily() - p2.person.getFamily());
                //.sorted(Comporator.comparing(Person::getFamily))
                //.sorted(PersonComparator.naturalOrder())
                .collect(Collectors.toList());

        System.out.println(peoplesForWork);

        System.out.println("========="); //для удобства чтения

        List<String> manForWar = persons.stream() //2 стрим подсчет призывников
                        .filter(person -> (person.getAge() >= 18) && (person.getAge() < 27))
                        .filter(person -> person.getSex() == Sex.MAN)
                        .map(person -> person.getFamily())
                        .collect(Collectors.toList());
        System.out.println("Список фамилий призывников " + manForWar);

        System.out.println("========="); //для удобства чтения

        long ageLess18 = persons.stream() //1 стрим подсчет несовершеннолетних
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Кол-во несовершеннолетних " + ageLess18);  //кол-во несовершеннолетних


    }
}