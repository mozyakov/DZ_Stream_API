public class PersonComparator implements java.util.Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int len1 = p1.getFamily().split("-").length;
        int len2 = p2.getFamily().split("-").length;
        if(len1 != len2) {
            return Integer.compare(len2, len1); //сначала большее len, большее знатнее
        }
        return Integer.compare(p2.getAge(), p1.getAge()); //сначала  большее p, большее знатнее
    }
}