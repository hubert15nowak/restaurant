package com.e.restaurant.service;

import com.e.restaurant.dao.UnitDao;
import com.e.restaurant.database.entity.Unit;
import com.e.restaurant.dto.unit.CreateUnitDto;
import com.e.restaurant.dto.unit.UnitDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitService {
    private final UnitDao unitDao;

    public UnitService(@Qualifier("unitMysql") UnitDao unitDao) {
        this.unitDao = unitDao;
    }


    public void createUnit(CreateUnitDto unit) throws DataIntegrityViolationException {
        addUnit(unit.mapToDao());
    }

    public Iterable<UnitDto> getUnits() {
        return StreamSupport.stream(unitDao.getUnits().spliterator(), true)
                .map(UnitDto::mapToDto)
                .collect(Collectors.toList());
    }

    protected void addUnit(Unit unit) throws DataIntegrityViolationException {
        unitDao.saveUnit(unit);
    }

    protected Optional<Unit> getUnit(String name) {
        return unitDao.getUnit(name);
    }

    public UnitDto getUnitDto(String name) {
        Optional<Unit> optionalUnit = getUnit(name);
        return optionalUnit.map(UnitDto::mapToDto).orElse(null);
    }
}
