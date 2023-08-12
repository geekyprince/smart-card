package com.example.geektrust.db;

import java.util.List;

public interface Repository<ENTITY, ID> {
    ENTITY save(ENTITY entity);
    List<ENTITY> findAll();
    ENTITY findById(ID id);
}
