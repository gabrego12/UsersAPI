package com.gabrego.usersapi.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private User patient_id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor_id;

    @ManyToOne
    @JoinColumn(name = "doctor_schedule_id", referencedColumnName = "id")
    private DoctorSchedule doctor_schedule_id;

    @Column(name = "justification")
    private String justification;

    @Column(name = "appointment_date")
    private java.sql.Date appointment_date;

    @Column(name = "appointment_time")
    private Time appointment_time;

    @Column(name = "appointment_time_finish")
    private Time appointment_time_finish;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;

    public Appointment() {
    }

    public Appointment(int id, User patient_id, Doctor doctor_id, DoctorSchedule doctor_schedule_id, String justification, java.sql.Date appointment_date, Time appointment_time, Time appointment_time_finish, Status status) {
        this.id = id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.doctor_schedule_id = doctor_schedule_id;
        this.justification = justification;
        this.appointment_date = appointment_date;
        this.appointment_time = appointment_time;
        this.appointment_time_finish = appointment_time_finish;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(User patient_id) {
        this.patient_id = patient_id;
    }

    public Doctor getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Doctor doctor_id) {
        this.doctor_id = doctor_id;
    }

    public DoctorSchedule getDoctor_schedule_id() {
        return doctor_schedule_id;
    }

    public void setDoctor_schedule_id(DoctorSchedule doctor_schedule_id) {
        this.doctor_schedule_id = doctor_schedule_id;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public Date getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(java.sql.Date appointment_date) {
        this.appointment_date = appointment_date;
    }

    public Time getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(Time appointment_time) {
        this.appointment_time = appointment_time;
    }

    public Time getAppointment_time_finish() {
        return appointment_time_finish;
    }

    public void setAppointment_time_finish(Time appointment_time_finish) {
        this.appointment_time_finish = appointment_time_finish;
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
        return "Appointment{" +
                "id=" + id +
                ", patient_id=" + patient_id +
                ", doctor_id=" + doctor_id +
                ", doctor_schedule_id=" + doctor_schedule_id +
                ", justification='" + justification + '\'' +
                ", appointment_date=" + appointment_date +
                ", appointment_time=" + appointment_time +
                ", appointment_time_finish=" + appointment_time_finish +
                ", status=" + status +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
