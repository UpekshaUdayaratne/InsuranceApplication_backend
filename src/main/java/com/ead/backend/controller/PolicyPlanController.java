package com.ead.backend.controller;

import java.util.List;

import com.ead.backend.model.PolicyPlan;
import com.ead.backend.repository.PolicyPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyPlanController {
    @Autowired
    PolicyPlanRepository policyplanRepository;

    @PostMapping("/addpolicyplan")
    public String addPolicyPlan(@RequestBody PolicyPlan policyplan) {
        policyplanRepository.save(policyplan);
        return "Added new policy plan!";
    }

    @PostMapping("/updatepolicyplan")
    public String updatePolicyPlan(@RequestBody PolicyPlan policyplan) {
        policyplanRepository.save(policyplan);
        return "updated policy plan!";
    }

    @GetMapping("/policyplanlist")
    public Iterable<PolicyPlan> getPolicyPlans() {
        return policyplanRepository.findAll();
    }

    @GetMapping("/policynames")
    public List<String> getPolicyNames() {
        return policyplanRepository.getPolicyNameList();
    }

    @PostMapping("/deletepolicyplan")
    public String deletePolicyPlan(@RequestBody PolicyPlan policyplan) {
        policyplanRepository.deleteById(policyplan.getId());
        return "Deleted policy plan!";
    }
}
