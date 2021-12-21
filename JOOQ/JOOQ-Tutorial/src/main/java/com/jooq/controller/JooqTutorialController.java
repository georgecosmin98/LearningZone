package com.jooq.controller;

import com.jooq.jooq.tables.pojos.Country;
import com.jooq.jooq.tables.pojos.Unrepresentative;
import com.jooq.model.InnerJoinMapper;
import com.jooq.service.JooqTutorialService;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
