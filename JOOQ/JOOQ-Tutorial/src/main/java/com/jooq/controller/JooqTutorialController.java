package com.jooq.controller;

import com.jooq.jooq.tables.pojos.Country;
import com.jooq.jooq.tables.pojos.Unrepresentative;
import com.jooq.model.CountryRepresentativeMapper;
import com.jooq.model.InnerJoinMapper;
import com.jooq.service.JooqTutorialService;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jooq")
public class JooqTutorialController {

    @Autowired
    JooqTutorialService jooqTutorialService;

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return jooqTutorialService.getCountries();
    }

    @GetMapping("/unrepresentatives")
    public List<Unrepresentative> getAllUnrepresentatives() {
        return jooqTutorialService.getUnrepresentatives();
    }

    @GetMapping("/join/inner")
    public List<InnerJoinMapper> getInnerJoin() {

        return jooqTutorialService.getInnerJoin();
    }

    @GetMapping("/join/left")
    public List<InnerJoinMapper> getLeftJoin() {

        return jooqTutorialService.getLeftJoin();
    }

    @GetMapping("/join/right")
    public List<InnerJoinMapper> getRightJoin() {

        return jooqTutorialService.getRightJoin();
    }

    @PostMapping("/save/country")
    public int saveCountry(@RequestBody Country country){
        return jooqTutorialService.saveCountry(country);
    }

    @PostMapping("/save/countryAndUnrepresentative")
    public int saveCountry(@RequestBody CountryRepresentativeMapper countryRepresentativeMapper){
        return jooqTutorialService.saveCountryThenSaveUnrepresentative(countryRepresentativeMapper.getCountry(), countryRepresentativeMapper.getUnrepresentative());
    }

    @DeleteMapping("/delete/countryById/{id}")
    public int deleteCountryById(@PathVariable("id") int id){
        return jooqTutorialService.deleteCountryById(id);
    }
}
