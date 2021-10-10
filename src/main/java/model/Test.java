package model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
@Component
public class Test {
    @Id
    private int Id;
    private String name;
public Test(int id, String n) {
        Id = id;
        name = n;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
