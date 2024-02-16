package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Skills;
import com.example.service.SkillService;

@RestController
@RequestMapping("/api")
public class Control {

    @Autowired
    private SkillService skillService;

    @GetMapping("/getSkillId")
    public ResponseEntity<Map<String, Object>> getSkillId(
            @RequestParam String domain,
            @RequestParam String subdomain,
            @RequestParam String skillName) {

        Skills skill = skillService.getSkillIdByDetails(domain, subdomain, skillName);

        Map<String, Object> response = new HashMap<>();

        if (skill != null) {
            response.put("skillId", skill.getSkillid());
            response.put("message", "Skill ID retrieved successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Skill not found for the provided details");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
