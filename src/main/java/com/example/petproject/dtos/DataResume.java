package com.example.petproject.dtos;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataResume {

    private String name;
    private String position;
    private String commonInfo;

    private String headerContact;
    private String headerSkill;
    private String headerEducation;
    private String headerLanguage;

    private String commonExperience;

    private String phone;
    private String phoneValue;

    private String email;
    private String emailValue;

    private String telegram;
    private String telegramValue;

    private String linkedIn;
    private String linkedInValue;

    private String[] skills;
    private String[] languages;

    private String university1;
    private String universityValue1;

    private String department;
    private String departmentLink1;
    private String departmentValue1;

    private String specialityWithValue1;

    private String departmentLink2;
    private String departmentValue2;

    private String speciality2;
    private String specialityWithValue2;

    private String projectTag;
    private String positionTag;

    private String language;


    public static DataResume getInstance(String language) {
        DataResume.DataResumeBuilder dataResumeBuilder = new DataResumeBuilder();
        dataResumeBuilder.language(language);
        if ("ru".equals(language)) {
            dataResumeBuilder
                    .name("ИЛЬЯ КЕЧКО")
                    .position("Инженер-программист JAVA")
                    .commonInfo("Опыт работы в области разработки программного обеспечения более 3-х лет. Опыт работы с Java, Spring Framework, Hibernate, JPA и другими технологиями. Умение разрабатывать эффективные и масштабируемые приложения. Опыт работы с БД, RESTful API и интеграцией сторонних сервисов. Готов к новым вызовам и стремлению к профессиональному росту.")
                    .headerContact("КОНТАКТЫ")
                    .headerSkill("НАВЫКИ")
                    .headerEducation("ОБРАЗОВАНИЕ")
                    .headerLanguage("ЯЗЫКИ")
                    .commonExperience("ОПЫТ РАБОТЫ")
                    .telegram("Telegram")
                    .linkedIn("LinkedIn")
                    .email("Почта")
                    .phone("Мобильный телефон")
                    .languages(new String[]{"Английский (A2)"})
                    .university1("Университет")
                    .universityValue1("БНТУ")
                    .department("Кафедра")
                    .departmentLink1("https://bntu.by/ru/faculties/stf/stf-si")
                    .departmentLink2("https://bntu.by/index.php/ru/faculties/ftug/ftug-td")
                    .departmentValue1("Спортивная инженерия")
                    .departmentValue2("Таможенное дело")
                    .specialityWithValue1("Инженер")
                    .specialityWithValue2("Магистр")
                    .positionTag("должность")
                    .projectTag("проект")
                    .build();
        } else {
            dataResumeBuilder
                    .name("ILYA KECHKO")
                    .position("Java Software Engineer")
                    .commonInfo("Experienced Java developer with over 3 years of experience in software development. Deep knowledge of Java, Spring Framework, Hibernate, JPA and other technologies. Ability to develop efficient and scalable applications following programming best practices. Experience with databases, RESTful APIs and service component integration. Ready for new challenges and the desire for professional growth.")
                    .headerContact("Contacts")
                    .headerSkill("Skills")
                    .headerEducation("Education")
                    .headerLanguage("Languages")
                    .commonExperience("Experience")
                    .telegram("Telegram")
                    .linkedIn("LinkedIn")
                    .email("Email")
                    .phone("Phone")
                    .languages(new String[]{"English (A2)", "Russian (native)"})
                    .university1("University")
                    .universityValue1("BNTU")
                    .department("Department")
                    .departmentLink1("https://bntu.by/en/faculties/stf/stf-si")
                    .departmentLink2("https://bntu.by/index.php/en/faculties/ftug/ftug-td")
                    .departmentValue1("Sports Engineering")
                    .departmentValue2("Customs")
                    .specialityWithValue1("Specialty: Engineer")
                    .specialityWithValue2("Specialty: Master")
                    .positionTag("position")
                    .projectTag("project")
                    .build();
        }
        dataResumeBuilder
                .phoneValue("+375 (25) 533-07-62")
                .telegramValue("@KechkoIlya")
                .linkedInValue("Ilya Kechko")
                .emailValue("kechko.ilya@gmail.com")
                .skills(new String[]{"Java 7-17", "Linux", "EJB", "Docker", "Git", "Kafka", "SQL", "Rabbit MQ",
                        "NoSQL", "REST", "Microservices", "SOAP", "Elasticsearch", "Spring",
                        "Maven/Gradle", "WebFlux", "Spring boot", "Hibernate", "Feign", "Camel", "Jasper Report",
                        "JUnit/Mockito", "Design patterns"})
                .build();

        return dataResumeBuilder.build();
    }

}
