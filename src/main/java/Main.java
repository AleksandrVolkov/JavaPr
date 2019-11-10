import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.reader.IReader;
import ru.vsu.lab.repository.IRepository;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        IReader reader = new Reader();
        Repository rep = (Repository) reader.read();

        Comparator<IPerson> comp = Comparator.comparingInt(IPerson::getId);

        Comparator<IPerson> comp1 = ((o1, o2) -> Integer.compare(o1.getFirstName().compareTo(o2.getFirstName()), 0));
        Comparator<IPerson> comp2 = Comparator.comparingInt(IPerson::getAge);

        IPerson[] pr =  rep.bubbleSort(comp2);




        printPerson(pr);

    }

    static void printPerson(IPerson[] dArr) {
        for (int i = 0; i < dArr.length; i++) {
            System.out.println(outputPerson(dArr[i]));
        }
    }

    static String outputPerson(IPerson inpPr) {
        return String.format(" | ID " + inpPr.getId() + " | Имя " + inpPr.getFirstName() + ' ' + inpPr.getLastName() +
                " | ДР " + inpPr.getBirthday().toString() + " | Возраст " + inpPr.getAge() + " | Пол " + inpPr.getGender() +
                " | Division " + inpPr.getDivision().getName() + ' ' + inpPr.getDivision().getId() + " | Salary " + inpPr.getSalary());
    }
}