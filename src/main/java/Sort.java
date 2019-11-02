
public class Sort {
    private Person[] mainArray;

    public Sort(Person[] mainArray) {
        this.mainArray = mainArray;
    }

    public Person getElemMainArray(int index) {
        return this.mainArray[index];
    }

    private int compareToId(Person pr1, Person pr2) {
        return Integer.compare(pr1.getId(), pr2.getId());
    }

    private int compareToName(Person pr1, Person pr2) {
        return Integer.compare(pr1.getName().compareTo(pr2.getName()), 0);
    }

    private int compareToBirthday(Person pr1, Person pr2) {
        return Integer.compare(pr1.getAge(), pr2.getAge());
    }


    private int compare(Person pr1, Person pr2, boolean id, boolean name, boolean birthday) {
        if (id) return compareToId(pr1, pr2);
        if (name) return compareToName(pr1, pr2);
        if (birthday) return compareToBirthday(pr1, pr2);
        return 12;
    }

    public Person[] bubbleSort(boolean id, boolean name, boolean birthday, boolean increase) {
        Person[] arr = mainArray;
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (increase) {
                    if (compare(arr[j], arr[j + 1], id, name, birthday) > 0) {
                        Person temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                } else {
                    if (compare(arr[j], arr[j + 1], id, name, birthday) < 0) {
                        Person temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
        return arr;

    }

    public Person[] selectionSort(boolean id, boolean name, boolean birthday, boolean increase) {
        Person[] arr = mainArray;
        for (int i = 0; i < arr.length; i++) {
            Person min = arr[i];
            int min_i = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (increase) {
                    if (compare(arr[j], min, id, name, birthday) < 0) {
                        min = arr[j];
                        min_i = j;
                    }
                } else {
                    if (compare(arr[j], min, id, name, birthday) > 0) {
                        min = arr[j];
                        min_i = j;
                    }
                }
            }
            if (i != min_i) {
                Person tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
        return arr;
    }


    public Person[] insertionSort(boolean id, boolean name, boolean birthday, boolean increase) {
        Person[] arr = mainArray;
        Person key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            int j = i - 1;
            if (increase) {
                while (j >= 0 && compare(arr[j], key, id, name, birthday) > 0) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            } else {
                while (j >= 0 && compare(arr[j], key, id, name, birthday) < 0) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }

        }
        return arr;

    }
}
