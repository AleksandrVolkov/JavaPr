import org.joda.time.LocalDate;


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
        for (int i = 0; i < 15; i++) {
            if (month == 12) month = 1;
            if (day == 30) day = 1;
            dArr.addPerson(new Person(Person.getCountId(), String.format("Pol" + i), new LocalDate(1990 + i, month, 3 + i), true));
            month += 1;
            day += 1;
        }
        dArr.removePerson(3);

        printPerson(dArr);

    }
    static void printPerson(DynamicArray dArr){
        for (int i = 0;i<dArr.getLength()-1;i++){
            System.out.println(outputPerson(dArr.getPerson(i)));
        }
    }

    static String outputPerson(Person inpPr) {
        return String.format(" | ID " + inpPr.getId() + " | Имя " + inpPr.getName() + " | Возраст " + inpPr.getAge() + " | Пол " + inpPr.getGender());
    }
}
