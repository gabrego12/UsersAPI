package com.gabrego.usersapi.controller;

import com.gabrego.usersapi.entity.Doctor;
import com.gabrego.usersapi.entity.User;
import com.gabrego.usersapi.service.PatientService;
import com.gabrego.usersapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/usersapi/patients")
public class PatientRestController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<Doctor> findAllPatient() {
        return patientService.findAll();
    }

    @GetMapping("/{userId}")
    public Doctor getPatientById(@PathVariable int userId){
        Doctor doctor = patientService.findById(userId);

        if(doctor == null) {
            throw new RuntimeException("User id not found -"+userId);
        }
        //retornará al usuario con id pasado en la url
        System.out.println(doctor);
        return doctor;
    }

    @PostMapping("/")
    public Doctor addPatient(@RequestBody Doctor doctor) {
        doctor.setId(0);
        User user = userService.findById(doctor.getUser_id().getId());
        doctor.setUser_id(user);
        //Este metodo guardará al usuario enviado
        patientService.save(doctor);

        return doctor;

    }

    @DeleteMapping("/{patientId}")
    public int deletePatientById(@PathVariable int patientId) {

        Doctor doctor = patientService.findById(patientId);

        if(doctor == null) {
            throw new RuntimeException("User id not found -"+patientId);
        }

        return patientService.deleteById(patientId);
    }

    @DeleteMapping("users/patients/userid/{userId}")
    public int deletePatientByUserId(@PathVariable int userId) {

        Doctor doctor = patientService.findByUserId(userId);

        if(doctor == null) {
            throw new RuntimeException("User id not found -"+userId);
        }

        return patientService.deleteByUserId(userId);
    }
}
