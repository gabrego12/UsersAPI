package com.gabrego.usersapi.controller;

import com.gabrego.usersapi.dao.MedicalRecordDetailDAO;
import com.gabrego.usersapi.entity.MedicalRecord;
import com.gabrego.usersapi.entity.MedicalRecordDetail;
import com.gabrego.usersapi.entity.User;
import com.gabrego.usersapi.service.MedicalDetailService;
import com.gabrego.usersapi.service.MedicalService;
import com.gabrego.usersapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/usersapi/medicalrecord/detail")
public class MedicalDetailRestController {

    @Autowired
    private MedicalDetailService medicalDetailService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<MedicalRecordDetail> findAllMedicalRecordDetails() {
        return medicalDetailService.findAll();
    }

    @GetMapping("/{medicalId}")
    public MedicalRecordDetail getMedicalRecordById(@PathVariable int medicalId){
        MedicalRecordDetail medicalRecord = medicalDetailService.findById(medicalId);

        if(medicalRecord == null) {
            return new MedicalRecordDetail();
        }

        System.out.println(medicalRecord);
        return medicalRecord;
    }

    @GetMapping("/appointment/{appointmentId}")
    public List<MedicalRecordDetail> getByAppointmentId(@PathVariable int appointmentId){

        List<MedicalRecordDetail> medicalRecordDetails = medicalDetailService.findByAppointmentId(appointmentId);

        if(medicalRecordDetails == null) {
            return Collections.emptyList();
        }
        
        return medicalRecordDetails;
    }

    @GetMapping("/patient/{patientId}")
    public List<MedicalRecordDetail> getByPatientId(@PathVariable int patientId){

        List<MedicalRecordDetail> medicalRecordDetails = medicalDetailService.findByPatientId(patientId);

        if(medicalRecordDetails == null) {
            return Collections.emptyList();
        }

        return medicalRecordDetails;
    }

    @GetMapping("/patient/{patientId}/{typeId}")
    public List<MedicalRecordDetail> getByPatientIdAndType(@PathVariable int patientId, @PathVariable int typeId){

        List<MedicalRecordDetail> medicalRecordDetails = medicalDetailService.findByUserIdAndTypeId(patientId, typeId);

        if(medicalRecordDetails == null) {
            return Collections.emptyList();
        }

        return medicalRecordDetails;
    }

    @PostMapping("/")
    public MedicalRecordDetail addMedicalRecordDetail(@RequestBody MedicalRecordDetail medicalRecordDetail) {
        medicalRecordDetail.setId(0);
        medicalDetailService.save(medicalRecordDetail);
        return medicalRecordDetail;
    }

    @PutMapping("/")
    public MedicalRecordDetail updateMedicalRecordDetail(@RequestBody MedicalRecordDetail medicalRecordDetail) {
        medicalDetailService.save(medicalRecordDetail);
        return medicalRecordDetail;
    }

    @DeleteMapping("/{medicalId}")
    public int deleteMedicalRecordDetailById(@PathVariable int medicalId) {

        MedicalRecordDetail medicalRecord = medicalDetailService.findById(medicalId);

        if(medicalRecord == null) {
            return 0;
        }

        return medicalDetailService.deleteById(medicalId);
    }

    @DeleteMapping("/appointmentid/{appointmentId}")
    public int deleteByAppointmentId(@PathVariable int appointmentId) {

        List<MedicalRecordDetail> medicalRecord = medicalDetailService.findByAppointmentId(appointmentId);

        if(medicalRecord == null) {
            return 0;
        }

        return medicalDetailService.deleteByAppointmentId(appointmentId);
    }

}
