CREATE TABLE credits (
    id             BIGINT AUTO_INCREMENT,
    name           VARCHAR(255) NOT NULL,
    loan_amount    DOUBLE       NOT NULL,
    monthly_income DOUBLE       NOT NULL,

    PRIMARY KEY(id)
);