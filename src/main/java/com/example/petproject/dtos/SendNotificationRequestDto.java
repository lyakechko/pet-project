package com.example.petproject.dtos;

import com.example.petproject.enums.ClientKind;
import com.example.petproject.enums.NotificationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class SendNotificationRequestDto extends NotificationRequestDto {

    private String phoneNumber;

    private ClientKind clientKind;

    @NotBlank
    @Email
    private String sender;
    @NotBlank
    private String subject;
    @Email
    private String recipient;
    private Map<String, byte[]> files;

    @Builder
    public SendNotificationRequestDto(NotificationType notificationType,
                                      String receiverId,
                                      String message,
                                      ClientKind clientKind,
                                      String phoneNumber,
                                      String sender,
                                      String recipient,
                                      String subject,
                                      Map<String, byte[]> files) {
        super(notificationType, message);
        this.clientKind = clientKind;
        this.phoneNumber = phoneNumber;
        this.files = files;
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
    }
}
