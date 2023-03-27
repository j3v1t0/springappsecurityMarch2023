package com.bankingaccount.appsecurity.repository;

import com.bankingaccount.appsecurity.model.AccessModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends CrudRepository<AccessModel, Long> {
}
