import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.Years;


/**
 * Класс персоны
 */
public class Person{
    private int id;
    private String name;
    private LocalDate birthday;
    private boolean gender;
    private static int countId = 0;

    public static int getCountId() {
        return countId;
    }

    public static void setCountId(int countId) {
        Person.countId = countId;
    }

    /**
     * @param id       идентефикатор
     * @param name     имя
     * @param birthday день рождения
     * @param gender   пол в значении boolean(true - мужчина,false - женщина)
     */
    public Person(int id, String name, LocalDate birthday, boolean gender) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    /**
     * @return возвращает id персоны
     */
    public int getId() {
        return id;
    }

    /**
     * задает id персоны
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return возвращает имя
     */
    public String getName() {
        return name;
    }

    /**
     * задает имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return возвращает возраст персоны
     */
    public int getAge() {
        LocalDate today = LocalDate.now(DateTimeZone.getDefault());
        Years age = Years.yearsBetween(this.birthday, today);
        return age.getYears();
    }

    /**
     * задает возраст
     */
    public void setBirthday(LocalDate birthday) {

        this.birthday = birthday;
    }

    /**
     * @return возвращает пол (true - мужчина,false - женщина)
     */
    public String getGender()
    {
        if(this.gender == true){
            return "man";
        }
        else{
            return "woman";
        }

    }

    /**
     * задает пол в значении boolean(true - мужчина,false - женщина)
     */
    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
