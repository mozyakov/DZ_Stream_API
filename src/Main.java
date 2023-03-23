import java.util.*;
import java.util.stream.Collectors;
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
        System.out.println("=========");



        List<Person> manForWar = persons.stream() //2 стрим подсчет призывников
                        .filter((age) -> (age.getAge() >= 18) & (age.getAge() < 50))
                        .filter((sex) -> sex.getSex().equals(Sex.MAN))
                        .collect(Collectors.toList());
        System.out.println(manForWar);
        System.out.println("=========");
        long countAgeLess18 = persons.stream() //1 стрим подсчет несовершеннолетних
                .filter((age) -> age.getAge() < 18)
                .count();
        System.out.println(countAgeLess18);  //кол-во несовершеннолетних
        System.out.println("=========");




    }
}