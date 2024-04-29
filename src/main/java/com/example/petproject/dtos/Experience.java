package com.example.petproject.dtos;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Experience {

    private String company;
    private String period;
    private String position;
    private String project;
    private String common;


    public static List<Experience> getExperiences(String language) {
        return "ru".equals(language) ? Arrays.asList(Experience.builder()
                        .company("First Mobile Solutions")
                        .period("ноябрь 2020 - н.в.")
                        .project("Мобильный и интерент банкинг")
                        .position("Инженер-программист JAVA")
                        .common("""
                                - Использование в работе инструментов, протокола удаленного доступа. (SSH, Putty, Kitty, WinSCP)
                                - Умение работать с фреймворками Spring, Apache Camel, Hibernate.                                                                                                                    - Опыт работы с базами данных (SQL, NoSQL).
                                - Понимание принципов разработки веб-приложений, включая работу с RESTful API.
                                - Умение использовать средства сборки и управления зависимостями. (Maven или Gradle).
                                - Опыт работы с инструментами контроля версий. (Git, BitBucket)
                                - Навыки тестирования и отладки приложений (JUnit).
                                - Понимание принципов безопасности кода и опыт работы с механизмами аутентификации и авторизации.
                                - Навыки командной работы, коммуникации с коллегами и анализ требований заказчика для эффективной разработки.
                                """)
                        .build(),
                Experience.builder()
                        .company("First Mobile Solutions")
                        .period("март 2018 - ноябрь 2020")
                        .project("Мобильный и интерент банкинг")
                        .position("QA инженер")
                        .common("""
                                - Ручное тестирование мобильного приложения. (Android, iOS)
                                - Функциональное/нефункциональное тестирование веб-приложения.
                                - Базовые знания в области автоматизации тестирования. (Postman, IntelliJ IDEA, Selenium IDE)
                                - Тестирование графического интерфейса. (Figma)
                                - Тестирование API. (Postman, SoapUI, Charles)
                                - Понимание принципов функционирования клиент-серверной архитектуры.
                                - Анализ журналов логирования. (JSON, XML)
                                - Создание тестовой документации. (Jira, Confluence)
                                - Тестирование новых функций, регрессионное тестирование, дымовое тестирование.
                                Участие в собеседованиях.
                                Тесное общение с заказчиком.""")
                        .build())
                : Arrays.asList(Experience.builder()
                        .company("First Mobile Solutions")
                        .period("November 2020 - till now")
                        .project("Mobile and internet banking")
                        .position("Java Software Engineer")
                        .common("""
                                   - Remote access. (SSH, Putty, Kitty, WinSCP)
                                   - Ability to work with Java frameworks. (Spring, Hibernate)
                                   - Experience working with databases. (SQL, NoSQL).
                                   - Understanding of the principles of web application development, including working with RESTful API.
                                   - Ability to use build tools and dependency management. (Maven, Gradle)
                                   - Experience with version control tools. (Git, Bitbucket).
                                   - Application testing and debugging skills (JUnit).
                                   - Understanding of code security principles and experience with authentication and authorization mechanisms.
                                   - Teamwork skills, communication with colleagues and analysis of customer requirements for effective development.
                                """)
                        .build(),
                Experience.builder()
                        .company("First Mobile Solutions")
                        .period("March 2018 - November 2020")
                        .project("Mobile and internet banking")
                        .position("QA Test Engineer")
                        .common("""
                                - Manual testing mobile application. (Android, iOS)\s
                                - Functional/non-functional testing web application. (DevTools)
                                - Basic knowledge in automation testing. (Postman, IntelliJ IDEA, Selenium IDE)
                                - GUI testing. (Figma)
                                - API testing. (Postman, SoapUI)
                                - Understanding of client-server architecture principles of functioning.\s
                                - Log file analysis. (JSON, XML)
                                - Test documentation creation. (Jira, Confluence)
                                - New feature testing, regression testing, smoke testing.

                                Participation in interviews.
                                Close communication with clients.""")
                        .build());
    }
}
