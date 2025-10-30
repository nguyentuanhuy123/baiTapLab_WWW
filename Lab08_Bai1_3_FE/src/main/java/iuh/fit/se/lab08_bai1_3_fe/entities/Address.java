package iuh.fit.se.lab08_bai1_3_fe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
public class Address {
    private int id;
    private String name;
    public Employee employee;

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
