package classesWithInterface;

import ru.vsu.lab.reader.IReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ru.vsu.lab.entities.*;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;

import java.math.BigDecimal;
import java.time.*;
import java.lang.String;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Reader implements IReader {
    private IRepository rep;
    private String path;

    public Reader(IRepository rep, String path) {
        this.rep = rep;
        this.path = path;
    }

    @Override
    public IRepository read() {
        List<IDivision> dvl = new ArrayList<>();
        String line = "";
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {
            br.readLine();
            while ((line = br.readLine()) != null) {

                if (25 == i++) break;

                String[] el = line.split(";");
                Integer id = new Integer(el[0]);
                String firstName = el[1];
                String lastName = "";
                LocalDate birthday = LocalDate.parse(el[3], DateTimeFormatter.ofPattern("d.MM.yyyy"));
                Integer age = Period.between(birthday, LocalDate.now()).getYears();
                Gender gender = "Male".equals(el[2]) ? Gender.MALE : Gender.FEMALE;
                IDivision division = null;
                if (dvl != null) {
                    for (IDivision dv : dvl) {
                        if (el[4].equals(dv.getName())) {
                            division = dv;
                            break;
                        }
                    }
                    if (division == null){
                        division = new Division(id, el[4]);
                        dvl.add(division);

                    }
                } else {
                    division = new Division(id, el[4]);
                    dvl.add(division);
                }
                BigDecimal salary = new BigDecimal(el[5]);

                rep.add(new Persone1(id, firstName, lastName, birthday, age, gender, division, salary));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return rep;
    }
}
