CREATE TABLE if not exists `DBDeliveredProducts`.`ship`
(
    `idShip`      int AUTO_INCREMENT ,
    `ShipName`    text NULL ,
    `ShipCapName` text NULL ,

    PRIMARY KEY (`idShip`)
);

CREATE TABLE `DBDeliveredProducts`.`documents`
(
    `idDoc`           int AUTO_INCREMENT ,
    `dateStarDelivery`  date  NULL ,
    `ShipId`          int  Null ,
    `dateFinishDelivery` date NULL ,
    `starLocation`       text  NULL ,
    `finishLocation`    text  NULL ,

    PRIMARY KEY (`idDoc`),
    KEY `FK_3` (`ShipId`),
    CONSTRAINT `FK_3_2` FOREIGN KEY `FK_3` (`ShipId`) REFERENCES `DBDeliveredProducts`.`ship` (`idShip`)
);

CREATE TABLE `DBDeliveredProducts`.`company`
(
    `idComp`   int AUTO_INCREMENT ,
    `nameComp` text ,
    `phoneComp`    text ,
    `countryComp`  text ,

    PRIMARY KEY (`idComp`)
);

CREATE TABLE `DBDeliveredProducts`.`containers`
(
    `idCont`   int AUTO_INCREMENT,
    `serialCont` int NULL ,
    `idDoc`         int NULL ,
    `idComp`        int NULL ,

    PRIMARY KEY (`idCont`),
    KEY `FK_2` (`idDoc`),
    CONSTRAINT `FK_4` FOREIGN KEY `FK_2` (`idDoc`) REFERENCES `DBDeliveredProducts`.`documents` (`idDoc`),
    KEY `FK_3` (`idComp`),
    CONSTRAINT `FK_5` FOREIGN KEY `FK_3` (`idComp`) REFERENCES `DBDeliveredProducts`.`company` (`idComp`)
);
CREATE TABLE `DBDeliveredProducts`.`depo`
(
    `idDep`   int AUTO_INCREMENT,
    `typeDep` text NULL  ,

    PRIMARY KEY (`idDep`)
);
CREATE TABLE `DBDeliveredProducts`.`product`
(
    `idProd`            int AUTO_INCREMENT ,
    `nameProd`          text  NULL ,
    `idDep`             int  NULL ,
    `idCont`            int  NULL ,
    `quantity`          int  NULL ,
    `dateOfManufacture` date  NULL ,
    `dayToExpire`       date  NULL ,
    `categProd`         int  NULL ,

    PRIMARY KEY (`idProd`),
    KEY `FK_4` (`idCont`),
    CONSTRAINT `FK_3` FOREIGN KEY `FK_4` (`idCont`) REFERENCES `DBDeliveredProducts`.`containers` (`idCont`),
    KEY `FK_5` (`idDep`),
    CONSTRAINT `FK_3_1` FOREIGN KEY `FK_5` (`idDep`) REFERENCES `DBDeliveredProducts`.`depo` (`idDep`)
);
CREATE TABLE `requestProduct`
(
    `idReq`   int AUTO_INCREMENT,
    `dateReq` date NULL ,
    `idDoc`   int  NULL ,
    `idProd`  int NULL ,

    PRIMARY KEY (`idReq`),
    KEY `FK_2` (`idProd`),
    CONSTRAINT `FK_6` FOREIGN KEY `FK_2` (`idProd`) REFERENCES `DBDeliveredProducts`.`product` (`idProd`),
    KEY `FK_3` (`idDoc`),
    CONSTRAINT `FK_7` FOREIGN KEY `FK_3` (`idDoc`) REFERENCES `DBDeliveredProducts`.`documents` (`idDoc`)
);




