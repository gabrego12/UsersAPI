package com.gabrego.usersapi.controller;

import com.gabrego.usersapi.entity.Doctor;
import com.gabrego.usersapi.entity.User;
import com.gabrego.usersapi.service.DoctorService;
import com.gabrego.usersapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/usersapi/doctors")
public class DoctorRestController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<Doctor> findAllDoctors() {
        return doctorService.findAll();
    }

    @GetMapping("/clinic/{clinicId}")
    public List<Doctor> findAllDoctors(@PathVariable int clinicId) {
        return doctorService.findByClinicId(clinicId);
    }

    @GetMapping("/{userId}")
    public Doctor getDoctorById(@PathVariable int userId){
        Doctor doctor = doctorService.findById(userId);

        if(doctor == null) {
            throw new RuntimeException("User id not found - "+userId);
        }
        //retornará al usuario con id pasado en la url
        System.out.println(doctor);
        return doctor;
    }

    @GetMapping("/email/{email}")
    public Doctor getDoctorByEmail(@PathVariable String email){
        User user = userService.findByEmail(email);
        Doctor doctor = doctorService.findByUserId(user.getId());

        if(doctor == null) {
            throw new RuntimeException("Doctor email not found - "+ email);
        }
        //retornará al usuario con id pasado en la url
        System.out.println(doctor);
        return doctor;
    }

    @PostMapping("/")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        doctor.setId(0);
        User user = userService.findById(doctor.getUser_id().getId());
        doctor.setUser_id(user);
        //Este metodo guardará al usuario enviado
        doctorService.save(doctor);

        return doctor;

    }

    @PutMapping("/")
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        System.out.println(doctor);
        User user = userService.findById(doctor.getUser_id().getId());
        doctor.setUser_id(user);
        //Este metodo guardará al usuario enviado
        doctorService.save(doctor);
        return doctor;

    }

    @DeleteMapping("/{patientId}")
    public int deletePatientById(@PathVariable int patientId) {

        Doctor doctor = doctorService.findById(patientId);

        if(doctor == null) {
            throw new RuntimeException("User id not found -"+patientId);
        }

        return doctorService.deleteById(patientId);
    }

    @DeleteMapping("users/patients/userid/{userId}")
    public int deletePatientByUserId(@PathVariable int userId) {

        Doctor doctor = doctorService.findByUserId(userId);

        if(doctor == null) {
            throw new RuntimeException("User id not found -"+userId);
        }

        return doctorService.deleteByUserId(userId);
    }
}
