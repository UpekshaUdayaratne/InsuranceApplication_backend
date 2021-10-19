package com.ead.backend.controller;

import com.ead.backend.model.Claim;
import com.ead.backend.repository.ClaimRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClaimController {
    @Autowired
    ClaimRepository claimRepository;

    @PostMapping("/addclaim")
    public String addClaim(@RequestBody Claim claim) {
        claimRepository.save(claim);
        return "Added new claim!";
    }

    @GetMapping("/ongoingclaimlist")
    public Iterable<Claim> getOngoingClaimList() {
        return claimRepository.findByStatus("ongoing");
    }

    @GetMapping("/completedclaimlist")
    public Iterable<Claim> getCompletedClaimList() {
        return claimRepository.findByStatus("completed");
    }

    @GetMapping("/updateclaimstatus/{id}")
    public String updateStatus(@PathVariable Integer id) {
        Claim claim = claimRepository.findClaimById(id);
        claim.setStatus("completed");
        claimRepository.save(claim);
        return "Updated claim status!";
    }
}
