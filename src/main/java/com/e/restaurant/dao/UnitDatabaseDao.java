package com.e.restaurant.dao;

import com.e.restaurant.database.entity.Unit;
import com.e.restaurant.database.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("unitMysql")
public class UnitDatabaseDao implements UnitDao {

    private UnitRepository repository;

    @Autowired
    public UnitDatabaseDao(UnitRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveUnit(Unit unit) {
        repository.save(unit);
    }

    @Override
    public Iterable<Unit> getUnits() {
        return repository.findAll();
    }

    @Override
    public Optional<Unit> getUnit(String name) {
        return repository.findFirstByName(name);
    }

}
