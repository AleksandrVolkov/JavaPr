package classesWithInterface;

import ru1.vsu1.lab1.entities.IPerson;
import ru1.vsu1.lab1.entities.enums.Gender;
import ru1.vsu1.lab1.reader.IReader;
import ru1.vsu1.lab1.repository.IRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repository rep = new Repository();

        IReader reader = new Reader(rep, ".\\src\\main\\resources\\persons.csv");
        rep = (Repository) reader.read();


        rep.add(2, new Persone1(1, "", "", LocalDate.now(), Gender.MALE, new Division(1, "d"), new BigDecimal("123.44444444444444444444444")));

        Comparator<IPerson> comp = Comparator.comparingInt(IPerson::getId);

        Comparator<IPerson> comp1 = ((o1, o2) -> Integer.compare(o1.getFirstName().compareTo(o2.getFirstName()), 0));
        Comparator<IPerson> comp2 = Comparator.comparingInt(IPerson::getAge);

//        IPerson[] pr = rep.sortBy(comp2.reversed());

        IRepository rp = rep.searchBy(x -> x.getId() == 28292);
        IRepository rp1 = rep.searchBy(x -> "Aaron".equals(x.getFirstName()));
        IRepository rp2 = rep.searchBy(x -> x.getAge() == 79);
        IRepository rp3 = rep.searchBy(x -> Gender.FEMALE.equals(x.getGender()));


//        printPerson(pr);
        printLPerson(rep.toList());

    }

    static void printLPerson(List<IPerson> dl) {
        for (IPerson pr : dl) {
            System.out.println(outputPerson(pr));
        }
    }

    static void printPerson(IPerson[] dArr) {
        for (int i = 0; i < dArr.length; i++) {
            System.out.println(outputPerson(dArr[i]));
        }
    }

    static String outputPerson(IPerson inpPr) {
        return String.format(" | ID " + inpPr.getId() + " | Имя " + inpPr.getFirstName() + ' ' + inpPr.getLastName() +
                " | ДР " + inpPr.getBirthday().toString() + " | Возраст " + inpPr.getAge() + " | Пол " + inpPr.getGender() +
                " | classesWithInterface.Division " + inpPr.getDivision().getName() + ' ' + inpPr.getDivision().getId() + " | Salary " + inpPr.getSalary());
    }
}
