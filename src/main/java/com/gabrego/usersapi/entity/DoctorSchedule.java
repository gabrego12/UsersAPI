package com.gabrego.usersapi.entity;

import javax.persistence.*;
import javax.print.Doc;
import java.sql.Time;

@Entity
@Table(name = "doctor_schedule")
public class DoctorSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor_id;

    @Column(name = "start_time")
    private Time start_time;

    @Column(name = "finish_time")
    private Time finish_time;

    @ManyToOne
    @JoinColumn(name = "day_id", referencedColumnName = "id")
    private Day day_id;

    @Column(name = "rango_cita")
    private int rango_cita;

    public DoctorSchedule() {
    }

    public DoctorSchedule(int id, Doctor doctor_id, Time start_time, Time finish_time, Day day_id, int rango_cita) {
        this.id = id;
        this.doctor_id = doctor_id;
        this.start_time = start_time;
        this.finish_time = finish_time;
        this.day_id = day_id;
        this.rango_cita = rango_cita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Doctor doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Time finish_time) {
        this.finish_time = finish_time;
    }

    public Day getDay_id() {
        return day_id;
    }

    public void setDay_id(Day day_id) {
        this.day_id = day_id;
    }

    public int getRango_cita() {
        return rango_cita;
    }

    public void setRango_cita(int rango_cita) {
        this.rango_cita = rango_cita;
    }

    @Override
    public String toString() {
        return "DoctorSchedule{" +
                "id=" + id +
                ", doctor_id=" + doctor_id +
                ", start_time=" + start_time +
                ", finish_time=" + finish_time +
                ", day_id=" + day_id +
                ", rango_cita=" + rango_cita +
                '}';
    }
}
