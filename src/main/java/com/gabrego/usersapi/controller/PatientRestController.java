package com.gabrego.usersapi.controller;

import com.gabrego.usersapi.entity.Patient;
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
    public List<Patient> findAllPatient() {
        return patientService.findAll();
    }

    @GetMapping("/{userId}")
    public Patient getPatientById(@PathVariable int userId){
        Patient patient = patientService.findById(userId);

        if(patient == null) {
            throw new RuntimeException("User id not found -"+userId);
        }
        //retornará al usuario con id pasado en la url
        System.out.println(patient);
        return patient;
    }

    @PostMapping("/")
    public Patient addPatient(@RequestBody Patient patient) {
        patient.setId(0);
        User user = userService.findById(patient.getUser_id().getId());
        patient.setUser_id(user);
        //Este metodo guardará al usuario enviado
        patientService.save(patient);

        return patient;

    }

    @DeleteMapping("/{patientId}")
    public int deletePatientById(@PathVariable int patientId) {

        Patient patient = patientService.findById(patientId);

        if(patient == null) {
            throw new RuntimeException("User id not found -"+patientId);
        }

        return patientService.deleteById(patientId);
    }

    @DeleteMapping("users/patients/userid/{userId}")
    public int detetePatientByUserId(@PathVariable int userId) {

        Patient patient = patientService.findByUserId(userId);

        if(patient == null) {
            throw new RuntimeException("User id not found -"+userId);
        }

        return patientService.deleteByUserId(userId);
    }
}
