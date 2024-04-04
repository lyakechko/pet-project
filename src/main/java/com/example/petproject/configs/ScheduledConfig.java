package com.example.petproject.configs;

import com.example.petproject.sheduler.NotificationJob;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import static java.time.ZoneOffset.UTC;
import static java.util.TimeZone.getTimeZone;
import static org.springframework.scheduling.support.CronExpression.isValidExpression;

@Profile("!junit")
@RequiredArgsConstructor
@Configuration
@Slf4j
public class ScheduledConfig {
    @Value("${scheduler.notification-cron}")
    private String notificationCron;

    private static final Integer POOL_SIZE = 1;
    private static final String THREAD_NAME = "ThreadPoolTaskScheduler";

    private final NotificationJob notificationJob;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        var threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(POOL_SIZE);
        threadPoolTaskScheduler.setThreadNamePrefix(THREAD_NAME);

        return threadPoolTaskScheduler;
    }

    @PostConstruct
    public void configureSchedule() {
        if (isValidExpression(notificationCron)) {
            threadPoolTaskScheduler().schedule(
                    notificationJob,
                    new CronTrigger(notificationCron, getTimeZone(UTC.getId()))
            );
        }
    }
}
