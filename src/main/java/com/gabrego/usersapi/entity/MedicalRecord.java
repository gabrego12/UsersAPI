package com.gabrego.usersapi.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "medical_record")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Column(name = "address", nullable = false, length = 500)
    private String address;

    @Column(name = "profession", nullable = false, length = 50)
    private String profession;

    @Column(name = "weight", nullable = false, length = 7, precision = 2)
    private double weight;

    @Column(name = "height", nullable = false, length = 7, precision = 2)
    private double height;

    @Column(name = "date_birth", nullable = false)
    private Date date_birth;

    @Column(name = "gender", nullable = false, length = 1)
    private String gender;

    @ManyToOne
    @JoinColumn(name = "identification_id", referencedColumnName = "id")
    private Identification identification_id;

    @Column(name = "num_id", nullable = false, length = 25)
    private String num_id;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;

    public MedicalRecord() {
    }

    public MedicalRecord(int id, User user_id, String phone, String address, String profession, double weight, Date date_birth, String gender, Identification identification_id, String num_id, Status status) {
        this.id = id;
        this.user_id = user_id;
        this.phone = phone;
        this.address = address;
        this.profession = profession;
        this.weight = weight;
        this.date_birth = date_birth;
        this.gender = gender;
        this.identification_id = identification_id;
        this.num_id = num_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Date getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(Date date_birth) {
        this.date_birth = date_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Identification getIdentification_id() {
        return identification_id;
    }

    public void setIdentification_id(Identification identification_id) {
        this.identification_id = identification_id;
    }

    public String getNum_id() {
        return num_id;
    }

    public void setNum_id(String num_id) {
        this.num_id = num_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "{" + '\'' +
                "id=" + id + '\'' +
                ", user_id=" + user_id + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", profession='" + profession + '\'' +
                ", weight=" + weight +
                ", date_birth=" + date_birth +
                ", gender='" + gender + '\'' +
                ", identification_id=" + identification_id +
                ", num_id='" + num_id + '\'' +
                ", status=" + status + '\'' +
                ", created_at=" + created_at + '\'' +
                ", updated_at=" + updated_at + '\'' +
                '}';
    }
}
