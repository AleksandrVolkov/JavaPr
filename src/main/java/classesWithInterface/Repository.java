package classesWithInterface;

import ru1.vsu1.lab1.entities.IPerson;
import ru1.vsu1.lab1.repository.IRepository;

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
            return this.arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(String.format("Индекс " + index + " выходит за границы массива."));
            return null;
        }
    }

    @Override
    public IPerson set(int index, IPerson person) {
        try {
            this.arr[index] = person;
            return person;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(String.format("Индекс " + index + " выходит за границы массива."));
            return null;
        }
    }

    @Override
    public void add(int index, IPerson person) {
        try {
            IPerson[] newArr = new IPerson[this.arr.length + 1];

            newArr[index] = person;

            System.arraycopy(this.arr, 0, newArr, 0, index );
            System.arraycopy(this.arr, index, newArr, index + 1, this.arr.length - index);

            this.arr = newArr;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println(String.format("Индекс " + index + " выходит за границы массива."));
        }
    }

    @Override
    public List<IPerson> toList() {
//        List<IPerson> list = Arrays.asList(this.arr);
        return Arrays.asList(this.arr);
    }


    @Override
    public void sortBy(Comparator<IPerson> comparator) {
//        Sort st = new Sort(this.arr);
//        this.arr = st.bubbleSort(comparator);
//        this.arr = st.selectionSort(comparator);
//        this.arr = st.insertionSort(comparator);
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
