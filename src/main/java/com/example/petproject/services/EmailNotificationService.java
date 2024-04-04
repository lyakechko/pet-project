package com.example.petproject.services;


import com.example.petproject.dtos.NotificationResponseDto;
import com.example.petproject.dtos.SendNotificationRequestDto;


public interface EmailNotificationService {

    String SUCCESS = "SUCCESS";
    String ERROR = "ERROR";
    NotificationResponseDto sendEmailNotification(SendNotificationRequestDto sendNotificationRequestDto);

}
