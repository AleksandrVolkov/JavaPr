package classesWithInterface;

import ru.vsu.lab.entities.*;
import ru.vsu.lab.entities.enums.Gender;
import java.math.BigDecimal;
import java.time.*;


public class Persone1 implements IPerson {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Integer age;
    private Gender gender;
    private IDivision division;
    private BigDecimal salary;

    public Persone1(Integer id, String firstName, String lastName, LocalDate birthday, Integer age, Gender gender, IDivision division, BigDecimal salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.age = age;
        this.gender = gender;
        this.division = division;
        this.salary = salary;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String setFirstName(String firstName) {
        this.firstName = firstName;
        return null;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String setLastName(String lastName) {
        this.lastName = lastName;
        return null;
    }

    @Override
    public LocalDate getBirthday() {
        return this.birthday;
    }

    @Override
    public LocalDate setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return null;
    }

    @Override
    public Integer getAge() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }

    @Override
    public Gender getGender() {
        return this.gender;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public IDivision getDivision() {
        return this.division;
    }

    @Override
    public void setDivision(IDivision division) {
        this.division = division;
    }

    @Override
    public BigDecimal getSalary() {
        return this.salary;
    }

    @Override
    public void setSalary(BigDecimal salary) {
        this.salary =salary;
    }
}
