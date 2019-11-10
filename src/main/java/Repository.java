import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Repository implements IRepository {
    private IPerson[] arr;


    public Repository() {
        this.arr = new IPerson[0];
    }

    public IPerson[] getArr() {
        return arr;
    }


    @Override
    public void add(IPerson person) {
        IPerson[] newArr = new IPerson[this.arr.length + 1];

        for (int i = 0; i < this.arr.length; i++) {
            if (arr[i] != null) newArr[i] = this.arr[i];
        }
        newArr[this.arr.length] = person;
        Person.setCountId(Person.getCountId() + 1);
        this.arr = newArr;
    }

    @Override
    public IPerson get(int index) {
        try {
            return this.arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(String.format("Индекс " + index + " выходит за границы массива."));
            return null;
        }
    }

    @Override
    public IPerson delete(int index) {
        try {
            IPerson[] newArr = new IPerson[this.arr.length - 1];

            for (int i = 0; i < this.arr.length; i++) {
                if (i < index) {
                    newArr[i] = this.arr[i];
                }
                if (i > index) {
                    newArr[i - 1] = this.arr[i];
                }
            }
            this.arr = newArr;
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(String.format("Индекс " + index + " выходит за границы массива."));
            return null;
        }
    }

    @Override
    public IPerson set(int index, IPerson person) {
        try {
            this.arr[index] = person;
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(String.format("Индекс " + index + " выходит за границы массива."));
            return null;
        }
    }

    @Override
    public void add(int index, IPerson person) {

    }

    @Override
    public List<IPerson> toList() {
//        List<IPerson> list = Arrays.asList(this.arr);
        return Arrays.asList(this.arr);
    }


    @Override
    public void sortBy(Comparator<IPerson> comparator) {
        bubbleSort(comparator);
        selectionSort(comparator);
        insertionSort(comparator);
    }

    public IPerson[] bubbleSort(Comparator<IPerson> comparator) {
        IPerson[] arr = this.arr;
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) < 0) {
                    IPerson temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        return arr;
    }

    public IPerson[] selectionSort(Comparator<IPerson> comparator) {
        IPerson[] arr = this.arr;
        for (int i = 0; i < arr.length; i++) {
            IPerson min = arr[i];
            int min_i = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (comparator.compare(arr[j], min) < 0) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                IPerson tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
        return arr;
    }


    public IPerson[] insertionSort(Comparator<IPerson> comparator) {
        IPerson[] arr = this.arr;
        IPerson key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(arr[j], arr[j + 1]) < 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }


    @Override
    public IRepository searchBy(Predicate<IPerson> condition) {
        Repository rep = new Repository();
        for (IPerson pr : this.arr) {
            if (condition.test(pr)) rep.add(pr);
        }
        return rep;
    }

}
