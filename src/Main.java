import java.util.*;
import java.util.function.*;
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

        List<Person> peoplesForWork = persons.stream()
                .filter((education) -> education.getEducation() == Education.HIGHER)
                .filter((sex) -> sex.getSex() == Sex.MAN)
                .filter((age) -> (age.getAge() >= 18) & (age.getAge() < 65))
                //.filter((age) -> (age.getAge() >= 18) & (age.getAge() < 65))
                //.filter((sex, age) -> sex.getSex().equals(Sex.MAN) & (age.getAge() >= 18) & (age.getAge() < 60))
                //.filter((age) -> (age.getAge() >= 18) & (age.getAge() < 60))
                .collect(Collectors.toList());
        System.out.println(peoplesForWork);

        /*for (Person person : persons) { // цикл со всеми условиями фильтра
            if(person.getEducation() == Education.HIGHER & person.getSex() == Sex.MAN & (person.getAge() >= 18 & (person.getAge() < 66)))
            //System.out.println(person);
                return;
         else if(person.getEducation() == Education.HIGHER & person.getSex() == Sex.WOMAN & (person.getAge() >= 18 & (person.getAge() < 60)))
        //System.out.println(person);
             return;
        }*/
        /*for (Person person : persons) { //
            if(person.getSex().equals(Sex.MAN) & (person.getAge() >= 18 & (person.getAge() < 65)))
            System.out.println(person);
         else if(person.getSex().equals(Sex.WOMAN) & (person.getAge() >= 18 & (person.getAge() < 60)))
        System.out.println(person);
        }*/

        /*List<String> manWarriors = persons.stream() //2 стрим подсчет призывников
                        .filter((age) -> (age.getAge() >= 18) & (age.getAge() < 27))
                        .filter((sex) -> sex.getSex().equals(Sex.MAN))
                        .map(Person -> Person.getFamily())
                        .collect(Collectors.toList());
        System.out.println(manWarriors); */

        //System.out.println("=========");

        /*long countAgeLess18 = persons.stream() //1 стрим подсчет несовершеннолетних
                .filter((age) -> age.getAge() < 18)
                .count();
        System.out.println("кол-во несовершеннолетних " + countAgeLess18);  //кол-во несовершеннолетних*/
    }
}