package com.gabrego.usersapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "days")
public class Day {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    public Day() {
    }

    public Day(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
