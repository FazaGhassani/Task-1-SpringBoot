package com.task.stunting.controller;

import com.task.stunting.model.Baby;
import com.task.stunting.repository.BabySDJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class RestBabyController {

    @Autowired
    private BabySDJRepository babySDJRepository;

    @GetMapping("/babies")
    @ResponseStatus(HttpStatus.OK)
    public List<Baby> findall() {
        return babySDJRepository.findAll();
    }

    @GetMapping("/babies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Baby findBabyById(@PathVariable("id") int id){
        return babySDJRepository.findBabyById(id);
    }

    @PostMapping("/babies")
    @ResponseStatus(HttpStatus.OK)
    public Baby addBaby(@RequestBody Baby baby){
        if(baby.getBreastmilk() == false && baby.getImmunized() == true)
            baby.setStuntingPotention("tidak stunting");
        else if (baby.getBreastmilk() == false && baby.getImmunized() == false)
            baby.setStuntingPotention("stunting");
        else if (baby.getBreastmilk() == true && baby.getImmunized() == true)
            baby.setStuntingPotention("stunting parah");

        return babySDJRepository.save(baby);
    }

    @PutMapping("/babies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Baby updateBaby(@RequestBody Baby baby, @PathVariable("id") int id){
        if(baby.getBreastmilk() == true && baby.getImmunized() == true)
            baby.setStuntingPotention("tidak stunting");
        else if (baby.getBreastmilk() == false && baby.getImmunized() == true)
            baby.setStuntingPotention("stunting");
        else if (baby.getBreastmilk() == true && baby.getImmunized() == false)
            baby.setStuntingPotention("stunting");
        else if (baby.getBreastmilk() == false && baby.getImmunized() == false)
            baby.setStuntingPotention("stunting parah");

        baby.setId(id);
        return babySDJRepository.save(baby);
    }

    @DeleteMapping("/babies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBaby(@PathVariable("id") int id){
        babySDJRepository.deleteById(id);
    }
}
