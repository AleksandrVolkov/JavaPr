package classesWithInterface;

//import ru.vsu.lab.entities.IPerson;
import ru1.vsu1.lab1.entities.IPerson;

import java.util.Comparator;

public class Sort {
    private IPerson[] arr;

    public Sort(IPerson[] arr) {
        this.arr = arr;
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
}
