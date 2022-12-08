package com.example.testdemo.database.perository;

import com.example.testdemo.database.entities.AbstractEntity;

import java.util.List;

public interface CommonService<E extends AbstractEntity>{

    void save(E entity);

    List<E> getAll();

    E getById(long id);

    void delete(E entity);

    void deleteById(long id);
}
