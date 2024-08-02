package com.recommendation.stock.controller;

import com.recommendation.stock.dto.OptionList;
import com.recommendation.stock.entity.Adviser;
import com.recommendation.stock.service.AdviserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/adviser")
public class AdviserController {
    private static AdviserController mInstance=null;
    private AdviserController(){

    }
    public static AdviserController getInstance(){
        if(mInstance==null){
           mInstance = new AdviserController();
        }
        return mInstance;
    }

    @Autowired
    private AdviserService adviserService;

    @PostMapping(value = { "", "/" }, produces = "application/json")
    public ResponseEntity<Adviser> saveAdvisor(@RequestBody Adviser adviser) {
        Adviser result = adviserService.saveOrUpdateAdviser(adviser);
        if (result != null) {
            return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = { "", "/" }, produces = "application/json")
    public ResponseEntity<List<Adviser>> getAllAdvisers() {
        return new ResponseEntity<>(adviserService.getAllAdvisers(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = { "{id}", "{id}/" }, produces = "application/json")
    public ResponseEntity<Adviser> getAdviserById(@PathVariable long id) {
        return new ResponseEntity<>(adviserService.getAdviserById(id), new HttpHeaders(), HttpStatus.OK);
    }

    public List<OptionList> getAllAdvisersList() {
        List<Adviser> list= adviserService.getAllAdvisers();
        List<OptionList> adviserNameIdList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            adviserNameIdList.add(new OptionList(list.get(i).getId().toString(),list.get(i).getName(),i,"adviserId"));
        }
        return adviserNameIdList;
    }
}
