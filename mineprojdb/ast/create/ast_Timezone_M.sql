DROP TABLE IF EXISTS `ast_Timezone_M`;

CREATE TABLE `ast_Timezone_M` ( `timeZoneId` VARCHAR(64) NOT NULL, `utcdifference` INT(11) NOT NULL, `gmtLabel` VARCHAR(256) NULL DEFAULT NULL, `timeZoneLabel` VARCHAR(256) NULL DEFAULT NULL, `country` VARCHAR(256) NULL DEFAULT NULL, `cities` VARCHAR(256) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`timeZoneId`));

