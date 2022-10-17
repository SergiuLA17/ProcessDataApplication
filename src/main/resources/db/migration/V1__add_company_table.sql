CREATE TABLE `TestDB`.`company`
(
    `id_company`   INT          NOT NULL,
    `name_company` VARCHAR(255) NULL,
    PRIMARY KEY (`id_company`)
);

CREATE TABLE `TestDB`.`product`
(
    `id_product`   INT          NOT NULL,
    `name_product` VARCHAR(255) NULL,
    `quantity`     INT          NULL,
    `company_id` INT NULL,
    PRIMARY KEY (`id_product`),
    FOREIGN KEY (company_id) REFERENCES company (id_company)
);