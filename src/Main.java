import java.util.*;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 40; i++) { //кол-во объектов коллекции Person
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        /*for (Person p: persons) {   //цикл for each по всей коллекции)
            System.out.println(p);
        }*/
        //System.out.println("========="); //для удобства чтения
        persons.forEach(System.out::println); //тоже самое что и цикл выше
        System.out.println("========="); //для удобства чтения
        
        long ageLess18 = persons.stream()   //первый стрим подсчет несовершеннолетних
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Кол-во несовершеннолетних " + ageLess18);  //кол-во несовершеннолетних
        System.out.println("========="); //для удобства чтения

        List<String> manForWar = persons.stream()   //второй стрим список фамилий призывников
                .filter(person -> person.getAge() >= 18) //&& (person.getAge() < 27)) для упрощения перенесу вниз
                .filter(person -> person.getAge() < 27)
                .filter(person -> person.getSex() == Sex.MAN)
                //.filter(Person::isgetSex(MAN)) //в классе Person надо написать метод
                .map(person -> person.getFamily())
                //.map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println("Список фамилий призывников " + manForWar);
        System.out.println("========="); //для удобства чтения

        List<Person> peoplesForWork = persons.stream()   //третий стрим способные к работе отсортированный по фамилиям
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> (person.getAge() >= 18))
                /*.filter (person -> {  //фильтр через цикл foreach
                    if(person.getSex() == Sex.MAN) {
                        return person.getAge() < 65;
                } else if (person.getSex() == Sex.WOMAN && person.getAge() < 60) {
                        return person.getAge() < 60;
                    }
                    return false;
                })*/
                .filter(person -> person.getSex() == Sex.MAN && person.getAge() < 65 //фильтр с упрощенной логикой
                        || person.getSex() == Sex.WOMAN && person.getAge() < 60)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        //System.out.println("Список доступных для найма " + peoplesForWork); //ниже вывод через цикл
        peoplesForWork.forEach(System.out::println);
        System.out.println("========="); //для удобства чтения
    }
}