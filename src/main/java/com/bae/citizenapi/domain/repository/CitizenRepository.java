package com.bae.citizenapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.bae.citizenapi.domain.model.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long>, QueryByExampleExecutor<Citizen> {

}