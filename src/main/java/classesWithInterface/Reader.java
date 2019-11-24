package classesWithInterface;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ru1.vsu1.lab1.entities.IDivision;
import ru1.vsu1.lab1.entities.enums.Gender;
import ru1.vsu1.lab1.reader.IReader;
import ru1.vsu1.lab1.repository.IRepository;

import java.math.BigDecimal;
import java.time.*;
import java.lang.String;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Reader implements IReader {
    IRepository repository;
    String path;

    public Reader(IRepository repository, String path) {
        this.repository = repository;
        this.path = path;
    }
//    public Reader(Repository rep, String s) {
//    }

    @Override
    public IRepository read() {
        String line = "";
        int i =0;
        Map<String ,IDivision> mapDivision = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(".\\src\\main\\resources\\persons.csv"))) {
            br.readLine();
            while ((line = br.readLine()) != null) {

                if(6==i++)break;


                String[] el = line.split(";");
                Integer id = new Integer(el[0]);
                String firstName = el[1];
                String lastName = "";
                LocalDate birthday = LocalDate.parse(el[3], DateTimeFormatter.ofPattern("d.MM.yyyy"));
                Integer age = Period.between(birthday, LocalDate.now()).getYears();
                Gender gender = "Male".equals(el[2]) ? Gender.MALE : Gender.FEMALE;
                IDivision division;
                if( !mapDivision.containsKey(el[4]) || mapDivision.isEmpty()) {
                    mapDivision.put(el[4], new Division(id, el[4]));
                    division = mapDivision.get(el[4]);
                }
                else
                    division = mapDivision.get(el[4]);

                BigDecimal salary = new BigDecimal(el[5]);

                repository.add(new Persone1(id, firstName, lastName, birthday, gender, division, salary));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return repository;
    }
}
