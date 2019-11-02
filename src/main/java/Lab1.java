import org.joda.time.LocalDate;

import javax.swing.text.html.Option;
import java.util.Optional;


public class Lab1 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        DynamicArray dArr = new DynamicArray();
//        Person pr1 = new Person(Person.getCountId(), "Pol", new LocalDate(1999, 12, 30), true);
//        dArr.addPerson(pr1);

        dArr.addPerson(new Person(Person.getCountId(), "Sasha", new LocalDate(1999, 12, 2), true));
        dArr.addPerson(new Person(Person.getCountId(), "Pol", new LocalDate(1989, 1, 12), true));
        dArr.addPerson(new Person(Person.getCountId(), "Norm", new LocalDate(2005, 4, 15), true));
        dArr.addPerson(new Person(Person.getCountId(), "Dima", new LocalDate(2001, 5, 16), true));
        dArr.addPerson(new Person(Person.getCountId(), "Vova", new LocalDate(1997, 5, 8), true));
        dArr.addPerson(new Person(Person.getCountId(), "Vika", new LocalDate(1994, 2, 18), false));
        dArr.addPerson(new Person(Person.getCountId(), "Katy", new LocalDate(1991, 1, 3), false));
        dArr.addPerson(new Person(Person.getCountId(), "Sasha", new LocalDate(1987, 6, 6), false));
        dArr.addPerson(new Person(Person.getCountId(), "Olya", new LocalDate(2003, 7, 4), false));
        dArr.addPerson(new Person(Person.getCountId(), "Ilya", new LocalDate(1962, 9, 21), true));
        dArr.addPerson(new Person(Person.getCountId(), "Nastya", new LocalDate(1995, 11, 30), false));
        dArr.addPerson(new Person(Person.getCountId(), "Nastya", new LocalDate(1995, 11, 30), false));
        dArr.addPerson(new Person(Person.getCountId(), "Kostya", new LocalDate(1995, 11, 30), true));

//        int month = 1;
//        int day = 1;
//        for (int i = 0; i < 4; i++) {
//            if (month == 12) month = 1;
//            if (day == 30) day = 1;
//            dArr.addPerson(new Person(Person.getCountId(), String.format("Pol" + i), new LocalDate(1990 + i, month, 3 + i), true));
//            month += 1;
//            day += 1;
//        }

        Optional<Person> pd = dArr.getPerson(16);

        dArr.removePerson(50);

        printPerson(dArr.getArr());

        Sort st = new Sort(dArr.getArr());

        System.out.println('\n');
        printPerson(st.bubbleSort(false, false, true, false));

        System.out.println('\n');
        printPerson(st.selectionSort(false, true, false, true));

        System.out.println('\n');
        printPerson(st.insertionSort(true, false, false, false));

        Find fn = new Find(dArr.getArr());

        System.out.println("\n Поиск по ID");
        System.out.println(outputPerson(fn.findOnId(1).get()));

        System.out.println("\n Поиск по возрасту");
        printPerson(fn.findOnAge(23).get());

        System.out.println("\n Поиск по имени");
        printPerson(fn.findOnName("Sasha").get());

        System.out.println("\n Поиск по полу");
        printPerson(fn.findOnGender("man").get());


    }

    static void printPerson(Person[] dArr) {
        for (int i = 0; i < dArr.length; i++) {
            if (!Optional.empty().equals(dArr[i]))
                System.out.println(outputPerson(dArr[i]));
        }
    }

    static String outputPerson(Person inpPr) {
        return String.format(" | ID " + inpPr.getId() + " | Имя " + inpPr.getName() + " | Возраст " + inpPr.getAge() + " | Пол " + inpPr.getGender());
    }
}
