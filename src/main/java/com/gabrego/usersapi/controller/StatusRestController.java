package com.gabrego.usersapi.controller;

import com.gabrego.usersapi.entity.DetailType;
import com.gabrego.usersapi.entity.Status;
import com.gabrego.usersapi.service.DetailTypeService;
import com.gabrego.usersapi.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/usersapi/status")
public class StatusRestController {

    @Autowired
    private StatusService statusService;


    @GetMapping("/")
    public List<Status> findAllDetailTypes() {
        return statusService.findAll();
    }

    @GetMapping("/{statusId}")
    public Status getDetailTypeById(@PathVariable int statusId){
        Status status = statusService.findById(statusId);

        if(status == null) {
            return new Status();
        }

        System.out.println(status);
        return status;
    }



    @PostMapping("/")
    public Status addDetailType(@RequestBody Status status) {
        status.setId(0);
        statusService.save(status);
        return status;
    }

    @PutMapping("/")
    public Status updateMedicalRecordDetail(@RequestBody Status detailType) {
        statusService.save(detailType);
        return detailType;
    }

    @DeleteMapping("/{statusId}")
    public int deleteDetailTypeById(@PathVariable int statusId) {

        Status status = statusService.findById(statusId);

        if(status == null) {
            return 0;
        }

        return statusService.deleteById(statusId);
    }

}
