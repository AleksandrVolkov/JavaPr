package oldLab1;

import oldLab1.DynamicArray;
import java.util.Optional;

public class Find {
    private Person[] mainArray;

    public Find(Person[] mainArray) {
        this.mainArray = mainArray;
    }

    public Optional<Person> findOnId(int id) {
        for (Person pr : mainArray) {
            if (pr.getId() == id) return Optional.of(pr);
        }

        return Optional.empty();
    }

    public Optional<Person[]> findOnName(String name) {
        DynamicArray arr = new DynamicArray();
        for (Person pr : mainArray) {
            if (pr.getName().equals(name)) arr.addPerson(pr);
        }
        return Optional.of(arr.getArr());
    }

    public Optional<Person[]> findOnAge(int age) {
        DynamicArray arr = new DynamicArray();
        for (Person pr : mainArray) {
            if (pr.getAge() == age) arr.addPerson(pr);
        }
        return Optional.of(arr.getArr());
    }

    public Optional<Person[]> findOnGender(String gender) {
        DynamicArray arr = new DynamicArray();
        for (Person pr : mainArray) {
            if (pr.getGender().equals(gender))
                arr.addPerson(pr);
        }
        return Optional.of(arr.getArr());
    }


}
