package com.example.petproject.sheduler;

import com.example.petproject.dtos.SendNotificationRequestDto;
import com.example.petproject.enums.NotificationType;
import com.example.petproject.services.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationJob implements Runnable {

    private final NotificationService notificationService;
    @Override
    public void run() {
        SendNotificationRequestDto sendNotificationRequestDto = SendNotificationRequestDto.builder()
                .notificationType(NotificationType.EMAIL)
                .message("Просьба не отвечать. Это не спам!")
                .subject("Тестовая рассылка сообщений!")
                .recipient("kechko1994@gmail.com")
                .sender("ilya.kechko@fmobile.by")
                .build();
        notificationService.sendNotification(sendNotificationRequestDto);
    }
}
