package com.gabrego.usersapi.controller;

import com.gabrego.usersapi.entity.DetailType;
import com.gabrego.usersapi.entity.Identification;
import com.gabrego.usersapi.entity.Status;
import com.gabrego.usersapi.service.DetailTypeService;
import com.gabrego.usersapi.service.IdentificationService;
import com.gabrego.usersapi.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/usersapi/identification")
public class IdentificationRestController {

    @Autowired
    private IdentificationService identificationService;

    @Autowired
    private StatusService statusService;


    @GetMapping("/")
    public List<Identification> findAllIdentifications() {
        return identificationService.findAll();
    }

    @GetMapping("/{identificationId}")
    public Identification getIdentificationById(@PathVariable int identificationId){
        Identification identification = identificationService.findById(identificationId);

        if(identification == null) {
            return new Identification();
        }

        System.out.println(identification);
        return identification;
    }



    @PostMapping("/")
    public Identification addIdentification(@RequestBody Identification identification) {
        identification.setId(0);
        Status status = statusService.findById(identification.getStatus().getId());
        identification.setStatus(status);
        identificationService.save(identification);
        return identification;
    }

    @PutMapping("/")
    public Identification updateIdentification(@RequestBody Identification identification) {
        identificationService.save(identification);
        return identification;
    }

    @DeleteMapping("/{identificationId}")
    public int deleteIdentificationById(@PathVariable int identificationId) {

        Identification identification = identificationService.findById(identificationId);

        if(identification == null) {
            return 0;
        }

        return identificationService.deleteById(identificationId);
    }

}
