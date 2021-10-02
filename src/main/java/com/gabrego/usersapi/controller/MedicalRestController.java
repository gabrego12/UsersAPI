package com.gabrego.usersapi.controller;

import com.gabrego.usersapi.entity.Doctor;
import com.gabrego.usersapi.entity.MedicalRecord;
import com.gabrego.usersapi.entity.User;
import com.gabrego.usersapi.service.MedicalService;
import com.gabrego.usersapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/usersapi/medicalrecord")
public class MedicalRestController {

    @Autowired
    private MedicalService medicalService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<MedicalRecord> findAllDoctors() {
        return medicalService.findAll();
    }

    @GetMapping("/{medicalId}")
    public MedicalRecord getMedicalRecorById(@PathVariable int medicalId){
        MedicalRecord medicalRecord = medicalService.findById(medicalId);

        if(medicalRecord == null) {
            throw new RuntimeException("User id not found - "+medicalId);
        }
        //retornará al usuario con id pasado en la url
        System.out.println(medicalRecord);
        return medicalRecord;
    }

    @GetMapping("/email/{email}")
    public MedicalRecord getMedicalRecordByEmail(@PathVariable String email){
        User user = userService.findByEmail(email);
        MedicalRecord medicalRecord = medicalService.findByUserId(user.getId());

        if(medicalRecord == null) {
            throw new RuntimeException("Doctor email not found - "+ email);
        }
        //retornará al usuario con el email pasado en la url
        System.out.println(medicalRecord);
        return medicalRecord;
    }

    @PostMapping("/")
    public MedicalRecord addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        medicalRecord.setId(0);
        User user = userService.findById(medicalRecord.getUser_id().getId());
        medicalRecord.setUser_id(user);
        //Este metodo guardará al usuario enviado
        medicalService.save(medicalRecord);

        return medicalRecord;

    }

    @PutMapping("/")
    public MedicalRecord updateUser(@RequestBody MedicalRecord medicalRecord) {

        medicalService.save(medicalRecord);

        //este metodo actualizará al usuario enviado

        return medicalRecord;
    }

    @DeleteMapping("/{medicalId}")
    public int deleteMedicalRecordById(@PathVariable int medicalId) {

        MedicalRecord medicalRecord = medicalService.findById(medicalId);

        if(medicalRecord == null) {
            throw new RuntimeException("User id not found -"+medicalId);
        }

        return medicalService.deleteById(medicalId);
    }

    @DeleteMapping("/userid/{userId}")
    public int deleteMedicalPatientByUserId(@PathVariable int userId) {

        MedicalRecord medicalRecord = medicalService.findByUserId(userId);

        if(medicalRecord == null) {
            throw new RuntimeException("User id not found -"+userId);
        }

        return medicalService.deleteByUserId(userId);
    }

}
