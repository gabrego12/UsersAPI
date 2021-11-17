package com.gabrego.usersapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "medical_record_detail")
public class MedicalRecordDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "appointment_id", referencedColumnName = "id")
    private Appointment appointment_id;

    @ManyToOne
    @JoinColumn(name = "detail_type_id", referencedColumnName = "id")
    private DetailType detailType_id;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    public MedicalRecordDetail() {
    }

    public MedicalRecordDetail(int id, Appointment appointment_id, DetailType detailType_id, String description, Status status) {
        this.id = id;
        this.appointment_id = appointment_id;
        this.detailType_id = detailType_id;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Appointment getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(Appointment appointment_id) {
        this.appointment_id = appointment_id;
    }

    public DetailType getDetailType_id() {
        return detailType_id;
    }

    public void setDetailType_id(DetailType detailType_id) {
        this.detailType_id = detailType_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MedicalRecordDetail{" +
                "id=" + id +
                ", appointment_id=" + appointment_id +
                ", detailType_id=" + detailType_id +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
