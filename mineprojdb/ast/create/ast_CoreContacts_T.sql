DROP TABLE IF EXISTS `ast_CoreContacts_T`;

CREATE TABLE `ast_CoreContacts_T` ( `contactId` VARCHAR(64) NOT NULL, `titleId` VARCHAR(64) NOT NULL, `firstName` VARCHAR(256) NOT NULL, `middleName` VARCHAR(256) NULL DEFAULT NULL, `lastName` VARCHAR(256) NOT NULL, `nativeLanguageCode` VARCHAR(64) NULL DEFAULT NULL, `nativeTitle` VARCHAR(128) NULL DEFAULT NULL, `nativeFirstName` VARCHAR(256) NULL DEFAULT NULL, `nativeMiddleName` VARCHAR(256) NULL DEFAULT NULL, `nativeLastName` VARCHAR(256) NULL DEFAULT NULL, `genderId` VARCHAR(64) NOT NULL, `dateofbirth` DATE NULL DEFAULT NULL, `age` INT(11) NULL DEFAULT NULL, `approximateDOB` DATE NULL DEFAULT NULL, `emailId` VARCHAR(256) NOT NULL, `phoneNumber` VARCHAR(20) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `timeZoneId` VARCHAR(64) NULL DEFAULT NULL, `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`contactId`));

