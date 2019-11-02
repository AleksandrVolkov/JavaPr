import org.joda.time.LocalDate;

import javax.swing.text.html.Option;
import java.util.Optional;


public class Lab1 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        DynamicArray dArr = new DynamicArray();
        Person pr1 = new Person(Person.getCountId(), "Pol", new LocalDate(1999, 12, 30), true);
        dArr.addPerson(pr1);
        int month = 1;
        int day = 1;
        for (int i = 0; i < 4; i++) {
            if (month == 12) month = 1;
            if (day == 30) day = 1;
            dArr.addPerson(new Person(Person.getCountId(), String.format("Pol" + i), new LocalDate(1990 + i, month, 3 + i), true));
            month += 1;
            day += 1;
        }

        Optional<Person>pd = dArr.getPerson(16);

        dArr.removePerson(50);

        printPerson(dArr.getArr());

        Sort st = new Sort(dArr.getArr());

        System.out.println('\n');
        printPerson(st.bubbleSort(false,false,true,false));

        System.out.println('\n');
        printPerson(st.selectionSort(false,true,false,false));

        System.out.println('\n');
        printPerson(st.insertionSort(true,false,false,false));

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
