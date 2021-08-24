package com.gabrego.usersapi.controller;

import com.gabrego.usersapi.entity.Patient;
import com.gabrego.usersapi.entity.User;
import com.gabrego.usersapi.service.PatientService;
import com.gabrego.usersapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indiciamos que es un controlador rest
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/usersapi") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/usersapi/
public class UserRestController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId){
        User user = userService.findById(userId);

        if(user == null) {
            throw new RuntimeException("User id not found -"+userId);
        }
        //retornará al usuario con id pasado en la url
        return user;
    }

    @GetMapping("/users/email/{userEmail}")
    public User getUserByEmail(@PathVariable String userEmail){
        User user = userService.findByEmail(userEmail);

        if(user == null) {
            throw new RuntimeException("User email not found -" + userEmail);
        }
        //retornará al usuario con id pasado en la url
        return user;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        user.setId(0);

        //Este metodo guardará al usuario enviado
        userService.save(user);

        return user;

    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {

        userService.save(user);

        //este metodo actualizará al usuario enviado

        return user;
    }

    @DeleteMapping("users/{userId}")
    public String deteteUser(@PathVariable int userId) {

        User user = userService.findById(userId);

        if(user == null) {
            throw new RuntimeException("User id not found -"+userId);
        }

        userService.deleteById(userId);

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        return "Deleted user id - "+userId;
    }

    @GetMapping("/users/patients")
    public List<Patient> findAllPatient() {
        return patientService.findAll();
    }

    @GetMapping("/users/patients/{userId}")
    public Patient getPatient(@PathVariable int userId){
        Patient patient = patientService.findById(userId);

        if(patient == null) {
            throw new RuntimeException("User id not found -"+userId);
        }
        //retornará al usuario con id pasado en la url
        System.out.println(patient);
        return patient;
    }

    @PostMapping("/users/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        patient.setId(0);
        User user = userService.findById(patient.getUser_id().getId());
        patient.setUser_id(user);
        //Este metodo guardará al usuario enviado
        patientService.save(patient);

        return patient;

    }

    @DeleteMapping("users/patients/{patientId}")
    public int detetePatient(@PathVariable int patientId) {

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
