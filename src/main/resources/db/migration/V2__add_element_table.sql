CREATE TABLE `DBDeliveredProducts`.`stock`
(
    `idPos`   int AUTO_INCREMENT,
    `idProd`         int NULL ,
    `idDep`        int NULL ,
    `idDoc`        int NULL ,
    `date`        date NULL ,

    PRIMARY KEY (`idPos`),
    KEY `FK_2` (`idProd`),
    CONSTRAINT `FK_8` FOREIGN KEY `FK_2` (`idProd`) REFERENCES `DBDeliveredProducts`.`product` (`idProd`),
    KEY `FK_3` (`idDep`),
    CONSTRAINT `FK_9` FOREIGN KEY `FK_3` (`idDep`) REFERENCES `DBDeliveredProducts`.`depotype` (`idDep`),
    KEY `FK_5` (`idDoc`),
    CONSTRAINT `FK_20` FOREIGN KEY `FK_5` (`idDoc`) REFERENCES `DBDeliveredProducts`.`documents` (`idDoc`)
);



insert into depotype (typeDep) values ('fruit-vegetable');
insert into depotype (typeDep) values ('electronic');
insert into depotype (typeDep) values ('default');

insert ports (namePort,locationPort,phonePort) values ('portName1', 'Bremen/Bremerhaven,Germany', '+472348733');
insert ports (namePort,locationPort,phonePort) values ('portName2', 'Algeciras, Spain', '+343244234');
insert ports (namePort,locationPort,phonePort) values ('portName3', 'Piraeus, Greece', '+423423423');
insert ports (namePort,locationPort,phonePort) values ('portName4', 'Long Beach, U.S.A.', '+412412121');
