package com.HospitalManagement.Hospital.Web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckControllerDB {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HealthCheckControllerDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/db")
    public String checkDatabaseConnection() {
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return "Database connection is healthy!";
        } catch (Exception e) {
            return "Database connection is not established. Error: " + e.getMessage();
        }
    }
}

