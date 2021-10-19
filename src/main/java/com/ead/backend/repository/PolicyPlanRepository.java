package com.ead.backend.repository;

import java.util.List;

import com.ead.backend.model.PolicyPlan;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PolicyPlanRepository extends CrudRepository<PolicyPlan, Integer> {
    @Query("SELECT p.planName FROM PolicyPlan p")
    List<String> getPolicyNameList();
}
