CREATE TABLE p_core.notification
(
    id                SERIAL NOT NULL,
    sender            VARCHAR(50),
    recipient         VARCHAR(50),
    message           VARCHAR(2000),
    notification_type VARCHAR(50),
    send_status       INTEGER,
    created_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE p_core.document
(
    id                SERIAL NOT NULL,
    name            VARCHAR(50),
    content         VARCHAR(50),
    created_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);