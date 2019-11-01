import java.util.Optional;

/**
 * Класс динамического массива
 */
public class DynamicArray {
    private Person[] arr;

    /**
     * Конструктор. Создает массив с начальным значением
     */
    public DynamicArray() {
        this.arr = new Person[1];
    }

    /**
     * @param index индекс персоны
     * @return возвращает терсону по индексу
     */
    public Optional<Person> getPerson(int index) {
        try {
            Optional<Person> pr = Optional.ofNullable(arr[index]);
            return pr;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(String.format("Индекс " + index + " выходит за границы массива."));
            return Optional.empty();
        }

    }

    /**
     * @return Возвращает длину массива
     */
    public int getLength() {
        return this.arr.length;
    }

    /**
     * @param newPerson принимает персону и добавлят ее в масив
     */
    public void addPerson(Person newPerson) {

        Person[] newArr = new Person[this.arr.length + 1];

        for (int i = 0; i < newArr.length; i++) {

            if (arr[i] == null) {
                newArr[i] = newPerson;
                break;
            } else {
                newArr[i] = this.arr[i];
            }
        }
        Person.setCountId(Person.getCountId() + 1);
        this.arr = newArr;
    }


    /**
     * @param index по индексу удаляет персону из массива
     */
    public void removePerson(int index) {
        try {
            Person[] newArr = new Person[this.arr.length - 1];

            for (int i = 0; i < this.arr.length; i++) {
                if (i < index) {
                    newArr[i] = this.arr[i];
                }
                if (i > index) {
                    newArr[i - 1] = this.arr[i];
                }
            }
            this.arr = newArr;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(String.format("Индекс " + index + " выходит за границы массива."));
        }

    }

}
