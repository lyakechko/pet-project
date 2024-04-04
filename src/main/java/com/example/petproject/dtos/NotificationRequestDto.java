package com.example.petproject.dtos;

import com.example.petproject.enums.NotificationType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationRequestDto {
    @NotNull
    private NotificationType notificationType;
    private String message;
}
