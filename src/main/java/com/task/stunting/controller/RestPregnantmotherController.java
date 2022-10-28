package com.task.stunting.controller;

import com.task.stunting.model.Pregnantmother;
import com.task.stunting.repository.PregnantmotherSDJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class RestPregnantmotherController {
    @Autowired
    private PregnantmotherSDJRepository pregnantmotherSDJRepository;

    @GetMapping("/pregnantmothers")
    @ResponseStatus(HttpStatus.OK)
    public List<Pregnantmother> findall() {
        return pregnantmotherSDJRepository.findAll();
    }

    @GetMapping("/pregnantmothers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pregnantmother findPregnantmotherById(@PathVariable("id") int id){
        return pregnantmotherSDJRepository.findPregnantmotherById(id);
    }

    @PostMapping("/pregnantmothers")
    @ResponseStatus(HttpStatus.OK)
    public Pregnantmother addPregnantmother(@RequestBody Pregnantmother pregnantmother){
        //tambahin if ifan pregnant womannya disini
        if(pregnantmother.getSmoking() == false && pregnantmother.getVitamin() == true)
            pregnantmother.setRecommendation("baik");
        else if (pregnantmother.getSmoking() == false && pregnantmother.getVitamin() == false)
            pregnantmother.setRecommendation("waspada");
        else if (pregnantmother.getSmoking() == true && pregnantmother.getVitamin() == true)
            pregnantmother.setRecommendation("waspada");
        else if (pregnantmother.getSmoking() == true && pregnantmother.getVitamin() == false)
            pregnantmother.setRecommendation("awas");

        return pregnantmotherSDJRepository.save(pregnantmother);
    }

    @PutMapping("/pregnantmothers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pregnantmother updatePregnantmother(@RequestBody Pregnantmother pregnantmother, @PathVariable("id") int id){
        //tambahin if ifan pregnant womannya disini
        if(pregnantmother.getSmoking() == false && pregnantmother.getVitamin() == true)
            pregnantmother.setRecommendation("baik");
        else if (pregnantmother.getSmoking() == false && pregnantmother.getVitamin() == false)
            pregnantmother.setRecommendation("waspada");
        else if (pregnantmother.getSmoking() == true && pregnantmother.getVitamin() == true)
            pregnantmother.setRecommendation("waspada");
        else if (pregnantmother.getSmoking() == true && pregnantmother.getVitamin() == false)
            pregnantmother.setRecommendation("awas");

        pregnantmother.setId(id);
        return pregnantmotherSDJRepository.save(pregnantmother);
    }

    @DeleteMapping("/pregnantmothers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePregnantmother(@PathVariable("id") int id){
        pregnantmotherSDJRepository.deleteById(id);
    }
}
