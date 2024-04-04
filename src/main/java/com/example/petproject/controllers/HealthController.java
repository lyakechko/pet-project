package com.example.petproject.controllers;

import com.example.petproject.dtos.ApiSuccess;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/health")
public class HealthController {
    @GetMapping
    public ApiSuccess health() { return new ApiSuccess(HttpStatus.OK); }
}
