CREATE TABLE if not exists `DBDeliveredProducts`.`ship`
(
    `idShip`      int AUTO_INCREMENT ,
    `ShipName`    text NULL ,
    `ShipCapName` text NULL ,

    PRIMARY KEY (`idShip`)
);
CREATE TABLE `DBDeliveredProducts`.`ports`
(   `idPort`   int AUTO_INCREMENT,
    `namePort`     text NULL ,
    `locationPort`  text NULL ,
    `phonePort`     text NULL ,
    PRIMARY KEY (`idPort`)
);

CREATE TABLE `DBDeliveredProducts`.`documents`
(
    `idDoc`           int AUTO_INCREMENT ,
    `dateStarDelivery`  date  NULL ,
    `ShipId`          int  Null ,
    `idPortNameStart`  int  Null ,
    `idPortNameFinish` int  Null ,
    `dateFinishDelivery` date NULL ,

    PRIMARY KEY (`idDoc`),
    KEY `FK_3` (`ShipId`),
    CONSTRAINT `FK_3_2` FOREIGN KEY `FK_3` (`ShipId`) REFERENCES `DBDeliveredProducts`.`ship` (`idShip`),
    KEY `FK_12` (`idPortNameStart`),
    CONSTRAINT `FK_21` FOREIGN KEY `FK_12` (`idPortNameStart`) REFERENCES `DBDeliveredProducts`.`ports` (`idPort`),
    KEY `FK_13` (`idPortNameFinish`),
    CONSTRAINT `FK_22` FOREIGN KEY `FK_13` (`idPortNameFinish`) REFERENCES `DBDeliveredProducts`.`ports` (`idPort`)
);


CREATE TABLE `DBDeliveredProducts`.`containers`
(
    `idCont`     int AUTO_INCREMENT,
    `serialCont` int NULL,
    `idDoc`      int NULL,

    PRIMARY KEY (`idCont`),
    KEY `FK_2` (`idDoc`),
    CONSTRAINT `FK_4` FOREIGN KEY `FK_2` (`idDoc`) REFERENCES `DBDeliveredProducts`.`documents` (`idDoc`)
);
CREATE TABLE `DBDeliveredProducts`.`depotype`
(
    `idDep`   int AUTO_INCREMENT,
    `typeDep` text NULL,

    PRIMARY KEY (`idDep`)
);
CREATE TABLE `DBDeliveredProducts`.`product`
(
    `idProd`            int AUTO_INCREMENT,
    `nameProd`          text NULL,
    `idCont`            int  NULL,
    `quantity`          int  NULL,
    `dateOfManufacture` date NULL,
    `dayToExpire`       int  NULL,
    `categProd`         text NULL,
    `compName`            text  NULL,
    `recipentEmail`            text  NULL,
    `recipentPhone`            text  NULL,


    PRIMARY KEY (`idProd`),
    KEY `FK_4` (`idCont`),
    CONSTRAINT `FK_3` FOREIGN KEY `FK_4` (`idCont`) REFERENCES `DBDeliveredProducts`.`containers` (`idCont`)
);
CREATE TABLE `requestproduct`
(
    `idReq`   int AUTO_INCREMENT,
    `dateReq` date NULL,
    `idDoc`   int  NULL,
    `idProd`  int  NULL,

    PRIMARY KEY (`idReq`),
    KEY `FK_2` (`idProd`),
    CONSTRAINT `FK_6` FOREIGN KEY `FK_2` (`idProd`) REFERENCES `DBDeliveredProducts`.`product` (`idProd`),
    KEY `FK_3` (`idDoc`),
    CONSTRAINT `FK_7` FOREIGN KEY `FK_3` (`idDoc`) REFERENCES `DBDeliveredProducts`.`documents` (`idDoc`)
);




