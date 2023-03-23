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

        /*List<Person> peoplesForWork = persons.stream()
                .filter((sex) -> sex.getSex().equals(Sex.MAN))*/

        List<String> manWarriors = persons.stream() //2 стрим подсчет призывников
                        .filter((age) -> (age.getAge() >= 18) & (age.getAge() < 27))
                        .filter((sex) -> sex.getSex().equals(Sex.MAN))
                        .map(Person -> Person.getFamily())
                        .collect(Collectors.toList());
        System.out.println(manWarriors);

        System.out.println("=========");

        /*long countAgeLess18 = persons.stream() //1 стрим подсчет несовершеннолетних
                .filter((age) -> age.getAge() < 18)
                .count();
        System.out.println("кол-во несовершеннолетних " + countAgeLess18);  //кол-во несовершеннолетних*/





    }
}