package com.ead.backend.repository;

import java.util.List;

import com.ead.backend.model.Claim;

import org.springframework.data.repository.CrudRepository;

public interface ClaimRepository extends CrudRepository<Claim, Integer> {

    List<Claim> findByStatus(String status);

    Claim findClaimById(Integer id);
}
