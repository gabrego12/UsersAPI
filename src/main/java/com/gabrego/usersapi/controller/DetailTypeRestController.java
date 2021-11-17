package com.gabrego.usersapi.controller;

import com.gabrego.usersapi.entity.DetailType;
import com.gabrego.usersapi.entity.MedicalRecordDetail;
import com.gabrego.usersapi.service.DetailTypeService;
import com.gabrego.usersapi.service.MedicalDetailService;
import com.gabrego.usersapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/usersapi/medicalrecord/detailtype/")
public class DetailTypeRestController {

    @Autowired
    private DetailTypeService detailTypeService;


    @GetMapping("/")
    public List<DetailType> findAllDetailTypes() {
        return detailTypeService.findAll();
    }

    @GetMapping("/{detailId}")
    public DetailType getDetailTypeById(@PathVariable int detailId){
        DetailType detailType = detailTypeService.findById(detailId);

        if(detailType == null) {
            return new DetailType();
        }

        System.out.println(detailType);
        return detailType;
    }



    @PostMapping("/")
    public DetailType addDetailType(@RequestBody DetailType detailType) {
        detailType.setId(0);
        detailTypeService.save(detailType);
        return detailType;
    }

    @PutMapping("/")
    public DetailType updateMedicalRecordDetail(@RequestBody DetailType detailType) {
        detailTypeService.save(detailType);
        return detailType;
    }

    @DeleteMapping("/{medicalId}")
    public int deleteDetailTypeById(@PathVariable int medicalId) {

        DetailType detailType = detailTypeService.findById(medicalId);

        if(detailType == null) {
            return 0;
        }

        return detailTypeService.deleteById(medicalId);
    }

}
