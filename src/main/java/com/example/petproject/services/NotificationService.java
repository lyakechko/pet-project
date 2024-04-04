package com.example.petproject.services;

import com.example.petproject.dtos.NotificationResponseDto;
import com.example.petproject.dtos.SendNotificationRequestDto;

public interface NotificationService {
    NotificationResponseDto sendNotification(SendNotificationRequestDto createNotificationRequestDto);

}