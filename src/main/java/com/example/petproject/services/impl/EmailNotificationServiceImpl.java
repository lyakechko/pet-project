package com.example.petproject.services.impl;

import com.example.petproject.dtos.NotificationResponseDto;
import com.example.petproject.dtos.SendNotificationRequestDto;
import com.example.petproject.entities.Notification;
import com.example.petproject.enums.NotificationSendStatus;
import com.example.petproject.enums.NotificationType;
import com.example.petproject.repositories.NotificationRepository;
import com.example.petproject.services.EmailNotificationService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {

    private final JavaMailSender javaMailSender;
    private final NotificationRepository notificationRepository;


    @Override
    public NotificationResponseDto sendEmailNotification(SendNotificationRequestDto sendNotificationRequestDto) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(sendNotificationRequestDto.getSender());
            helper.setTo(sendNotificationRequestDto.getRecipient());
            helper.setSubject(sendNotificationRequestDto.getSubject());
            helper.setText(Objects.nonNull(sendNotificationRequestDto.getMessage())
                    ? sendNotificationRequestDto.getMessage()
                    : "");

            if (Objects.nonNull(sendNotificationRequestDto.getFiles())) {
                sendNotificationRequestDto.getFiles().entrySet().stream()
                        .filter(Objects::nonNull)
                        .filter(file ->
                                Objects.nonNull(file.getKey())
                                        && Objects.nonNull(file.getValue())
                                        && file.getValue().length > 0)
                        .forEach(file -> addFile(helper, file));
            }
            javaMailSender.send(message);
        } catch (Exception exception) {
            log.error("Error sending email notification. Message : {}", exception.getMessage());
            log.info("Error sending email notification. Message : {}", exception.getMessage());
            saveNotification(sendNotificationRequestDto, NotificationSendStatus.NOT_SENT);
            return new NotificationResponseDto(EmailNotificationService.ERROR);
        }
        saveNotification(sendNotificationRequestDto, NotificationSendStatus.SENT);
        return new NotificationResponseDto(EmailNotificationService.SUCCESS);
    }


    private static void addFile(MimeMessageHelper helper, Map.Entry<String, byte[]> file) {
        try {
            String encodeToString = Base64.getEncoder().encodeToString(file.getValue());
            byte[] decode = Base64.getDecoder().decode(encodeToString.getBytes());
            helper.addAttachment(file.getKey(), new ByteArrayResource(decode), "application/pdf");
        } catch (MessagingException e) {
            log.error("Failed to attach file named \"{}\" !", file.getKey());
        }
    }

    private void saveNotification(SendNotificationRequestDto sendNotificationRequestDto, NotificationSendStatus sendStatus) {
        Notification notification = new Notification();
        notification.setNotificationType(NotificationType.EMAIL);
        notification.setSender(sendNotificationRequestDto.getSender());
        notification.setRecipient(sendNotificationRequestDto.getRecipient());
        notification.setMessage(sendNotificationRequestDto.getMessage());
        notification.setCreatedDate(new Date());
        notification.setSendStatus(sendStatus);
        notificationRepository.save(notification);
    }
}
