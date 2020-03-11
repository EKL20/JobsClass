package com.personalSoft.tallerFullStack.repositories;

import org.springframework.stereotype.Repository;
import com.personalSoft.tallerFullStack.entities.*;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RegDAO extends CrudRepository<RegistersView, Long>{

}
