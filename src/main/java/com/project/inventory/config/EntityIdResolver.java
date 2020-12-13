/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.config;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import javax.persistence.EntityManager;

/**
 *
 * @author i am me
 */
public class EntityIdResolver implements ObjectIdResolver{
    private EntityManager entityManager;

    public EntityIdResolver(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    @Override
    public void bindItem(ObjectIdGenerator.IdKey idkey, Object o) {
       
    }

    @Override
    public Object resolveId(ObjectIdGenerator.IdKey idkey) {
       return this.entityManager.find(idkey.scope, idkey.key);
    }

    @Override
    public ObjectIdResolver newForDeserialization(Object o) {
       return this;
    }

    @Override
    public boolean canUseFor(ObjectIdResolver oir) {
       return false;
    }
    
}
