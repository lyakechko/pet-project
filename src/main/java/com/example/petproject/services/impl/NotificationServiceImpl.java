package com.example.petproject.services.impl;


import com.example.petproject.dtos.NotificationResponseDto;
import com.example.petproject.dtos.SendNotificationRequestDto;
import com.example.petproject.services.EmailNotificationService;
import com.example.petproject.services.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {
    private final EmailNotificationService emailNotificationService;

    @Override
    public NotificationResponseDto sendNotification(SendNotificationRequestDto sendNotificationRequestDto) {
        return emailNotificationService.sendEmailNotification(sendNotificationRequestDto);
    }
}

