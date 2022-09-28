package com.tkachev.service;

import com.tkachev.exception_handling.exception.FieldNotSpecifiedException;
import com.tkachev.exception_handling.exception.NoSuchEntityException;

public abstract class AbstractService {

    public <T> T isExist(T entity, String entityName) {
        if (entity == null) {
            throw new NoSuchEntityException("There is no such " + entityName +  " in Hotel manager");
        }

        return entity;
    }

    public <T> T isSpecified(T field, String fieldName) {
        if (field == null) {
            throw new FieldNotSpecifiedException(fieldName + " must be specified");
        }

        return field;
    }
}
