import java.util.*;

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

        long countMinor = persons.stream()
                .filter(value -> value.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних: " + countMinor);

        List<String> conscripts = persons.stream()
                .filter(value -> value.getSex() == Sex.MAN)
                .filter(value -> value.getAge() >= 18 && value.getAge() < 27)
                .map(Person::getFamily)
                .toList();
        System.out.println("Призывники: " + conscripts);

        List<String> workable = persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> {
                    if (person.getSex() == Sex.WOMAN) {
                        return person.getAge() >= 18 && person.getAge() < 60;
                    } else {
                        return person.getAge() >= 18 && person.getAge() < 65;
                    }
                })
                .sorted(Comparator.comparing(Person::getFamily))
                .map(Person::getFamily)
                .toList();
        System.out.println("Потенциально работоспособные: " + workable);
    }

}