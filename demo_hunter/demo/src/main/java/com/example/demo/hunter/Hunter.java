package com.example.demo.hunter;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Hunter {
    @Id
    @SequenceGenerator(name="hunter_sequence", sequenceName = "hunter_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hunter_sequence")
    private  Long id;
    private  String name;
    private String email;
    private LocalDate dos;
    private String job;
    private String rank;
    @Transient
    private  Integer age;

    public Hunter() {

    }

    public Hunter(Long id, String name, String email, LocalDate dos) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dos = dos;
    }

    public Hunter(String name, String email, LocalDate dos, String rank, String job) {
        this.name = name;
        this.email = email;
        this.dos = dos;
        this.job = job;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDos() {
        return dos;
    }

    public void setDos(LocalDate dob) {
        this.dos = dob;
    }

    public Integer getAge() {
        return Period.between(this.dos,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Hunter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateofstart=" + dos +
                ", age=" + age +
                ", job=" + job +
                ", rank=" + rank +
                '}';
    }
}
