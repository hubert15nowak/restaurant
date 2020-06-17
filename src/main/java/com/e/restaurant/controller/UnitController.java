package com.e.restaurant.controller;


import com.e.restaurant.dto.unit.CreateUnitDto;
import com.e.restaurant.dto.unit.UnitDto;
import com.e.restaurant.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/unit")
public class UnitController {

    private UnitService unitService;

    @Autowired
    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<CreateUnitDto> createUnit(@RequestBody CreateUnitDto unitDto) {
        try {
            unitService.createUnit(unitDto);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<CreateUnitDto>(unitDto, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<CreateUnitDto>(unitDto, HttpStatus.CREATED);
    }

    @GetMapping
    public @ResponseBody
    Iterable<UnitDto> getUnits() {
        return unitService.getUnits();
    }

    @GetMapping("/{name}")
    public @ResponseBody
    ResponseEntity<UnitDto> getUnit(@PathVariable String name) {
        UnitDto unitDto = unitService.getUnitDto(name);
        if (unitDto != null) {
            return new ResponseEntity<UnitDto>(unitDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<UnitDto>(HttpStatus.NOT_FOUND);
        }
    }


}
