package com.gabrego.usersapi.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;

    @Column(name = "speciality", nullable = false, length = 100)
    private String speciality;

    @ManyToOne
    @JoinColumn(name = "identification_id", referencedColumnName = "id")
    private Identification identification_id;

    @Column(name = "num_id", nullable = false, length = 25)
    private String num_id;

    @Column(name = "num_reg_doc", nullable = false, length = 25)
    private String num_reg_doc;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic_id;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;

    public Doctor() {
    }

    public Doctor(int id, User user_id, String speciality, Identification identification_id, String num_id, String num_reg_doc, Clinic clinic_id, Status status) {
        this.id = id;
        this.user_id = user_id;
        this.speciality = speciality;
        this.identification_id = identification_id;
        this.num_id = num_id;
        this.num_reg_doc = num_reg_doc;
        this.clinic_id = clinic_id;
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

    public void setUser_id(User user) {
        this.user_id = user;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Identification getIdentification_id() {
        return identification_id;
    }

    public void setIdentification_id(Identification identification) {
        this.identification_id = identification;
    }

    public String getNum_id() {
        return num_id;
    }

    public void setNum_id(String num_id) {
        this.num_id = num_id;
    }

    public String getNum_reg_doc() {
        return num_reg_doc;
    }

    public void setNum_reg_doc(String num_reg_doc) {
        this.num_reg_doc = num_reg_doc;
    }

    public Clinic getClinic_id() {
        return clinic_id;
    }

    public void setClinic_id(Clinic clinic_id) {
        this.clinic_id = clinic_id;
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
        return "Doctor{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", speciality='" + speciality + '\'' +
                ", identification_id=" + identification_id +
                ", num_id='" + num_id + '\'' +
                ", num_reg_doc='" + num_reg_doc + '\'' +
                ", clinic_id=" + clinic_id +
                ", status=" + status +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
