import java.util.*;
import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])

            );
        }
        for (Person person : persons) { //пример чтоб вывести список
            System.out.println(person);
        }
        long count = persons.stream() //стрим подсчета несовершеннолетних
                .filter((age) -> age.getAge() < 18)
                .count();
        System.out.println(count); //итоговое кол-во несовершеннолетних





    }
}