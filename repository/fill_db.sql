--  -------------------- REGION ------------------ --

INSERT INTO `measurement_devices`.`Region`
(`id`,`designation`)
VALUES(1,'Тернопільська');

INSERT INTO `measurement_devices`.`Region`
(`id`,`designation`)
VALUES(2,'Львівська');

INSERT INTO `measurement_devices`.`Region`
(`id`,`designation`)
VALUES(3,'Івано-Франківська');

INSERT INTO `measurement_devices`.`Region`
(`id`,`designation`)
VALUES(4,'Київ');

INSERT INTO `measurement_devices`.`Region`
(`id`,`designation`)
VALUES(5,'Харківська');

INSERT INTO `measurement_devices`.`Region`
(`id`,`designation`)
VALUES(6,'Одеська');

INSERT INTO `measurement_devices`.`Region`
(`id`,`designation`)
VALUES(7,'Дніпропетровська');





-- ------------------------- DISTRICT -------------------------- --
INSERT INTO `measurement_devices`.`District`
(`id`,`designation`,`region_id`)
VALUES(1,'Тернопільський',1);

INSERT INTO `measurement_devices`.`District`
(`id`,`designation`,`region_id`)
VALUES(2,'Львівський',2);

INSERT INTO `measurement_devices`.`District`
(`id`,`designation`,`region_id`)
VALUES(3,'Івано-франківський',3);

INSERT INTO `measurement_devices`.`District`
(`id`,`designation`,`region_id`)
VALUES(4,'Збаразький',4);

INSERT INTO `measurement_devices`.`District`
(`id`,`designation`,`region_id`)
VALUES(5,'Бучацький',5);

INSERT INTO `measurement_devices`.`District`
(`id`,`designation`,`region_id`)
VALUES(6,'Зборівський',6);

INSERT INTO `measurement_devices`.`District`
(`id`,`designation`,`region_id`)
VALUES(7,'Чортківський',7);

INSERT INTO `measurement_devices`.`District`
(`id`,`designation`,`region_id`)
VALUES(8,'Золочівський',1);

INSERT INTO `measurement_devices`.`District`
(`id`,`designation`,`region_id`)
VALUES(9,'Буський',1);

INSERT INTO `measurement_devices`.`District`
(`id`,`designation`,`region_id`)
VALUES(10,'Пустомитівський',2);




-- ------------------------------ LOCALITY -------------------------- --
INSERT INTO `measurement_devices`.`Locality`
(`id`,`designation`,`district_id`)
VALUES(1,'м. Тернопіль',1);

INSERT INTO `measurement_devices`.`Locality`
(`id`,`designation`,`district_id`)
VALUES(2,'м. Львів',2);

INSERT INTO `measurement_devices`.`Locality`
(`id`,`designation`,`district_id`)
VALUES(3,'м. Івано-Франківськ',3);





-- ---------------------------- STREET ----------------------------------- --
INSERT INTO `measurement_devices`.`Street`
(`id`,`designation`,`locality_id`)
VALUES(1,'вул. Симоненка',1);

INSERT INTO `measurement_devices`.`Street`
(`id`,`designation`,`locality_id`)
VALUES(2,'вул. Морозенка',2);

INSERT INTO `measurement_devices`.`Street`
(`id`,`designation`,`locality_id`)
VALUES(3,'вул. Генерала Тарнавського',3);

INSERT INTO `measurement_devices`.`Street`
(`id`,`designation`,`locality_id`)
VALUES(4,'просп. Степана Бандери',1);

INSERT INTO `measurement_devices`.`Street`
(`id`,`designation`,`locality_id`)
VALUES(5,'бульвар Тараса Шевченка',2);

INSERT INTO `measurement_devices`.`Street`
(`id`,`designation`,`locality_id`)
VALUES(6,'вул. Вишневецького',3);

INSERT INTO `measurement_devices`.`Street`
(`id`,`designation`,`locality_id`)
VALUES(7,'вул. Володимира Великого',1);

INSERT INTO `measurement_devices`.`Street`
(`id`,`designation`,`locality_id`)
VALUES(8,'вул. Київська',2);


-- ---------------------------------------- BUILDING -------------------------- --
INSERT INTO `measurement_devices`.`Building`
(`id`,`designation`,`street_id`)
VALUES(1,'1',1);

INSERT INTO `measurement_devices`.`Building`
(`id`,`designation`,`street_id`)
VALUES(2,'2',1);

INSERT INTO `measurement_devices`.`Building`
(`id`,`designation`,`street_id`)
VALUES(3,'3',2);

INSERT INTO `measurement_devices`.`Building`
(`id`,`designation`,`street_id`)
VALUES(4,'3а',2);

INSERT INTO `measurement_devices`.`Building`
(`id`,`designation`,`street_id`)
VALUES(5,'4',3);

INSERT INTO `measurement_devices`.`Building`
(`id`,`designation`,`street_id`)
VALUES(6,'1',3);

INSERT INTO `measurement_devices`.`Building`
(`id`,`designation`,`street_id`)
VALUES(7,'2',4);

INSERT INTO `measurement_devices`.`Building`
(`id`,`designation`,`street_id`)
VALUES(8,'3',4);

INSERT INTO `measurement_devices`.`Building`
(`id`,`designation`,`street_id`)
VALUES(9,'3а',5);

INSERT INTO `measurement_devices`.`Building`
(`id`,`designation`,`street_id`)
VALUES(10,'4',5);





-- ------------------------------- ORGANIZATION ---------------------------- --
INSERT INTO `measurement_devices`.`Organization`
(`organizationType`,`id`,`name`,`email`,`phone`,`certificateGrantedDate`,`certificateNumber`,
`postal_index`,`region`,`district`,`locality`,`street`,`building`,`flat`)

VALUES

('PROVIDER',1,'ЛьвівВодоКанал','lviv_vodo_kanal@gmail.com', '2911214', null, null,
'79045','Львівська','Львівський','м. Львів','вул. Морозенка','12а',null),

('PROVIDER',2,'ЛьвівГаз','lviv_gaz@gmail.com', '2914593', null, null,
'79055','Львівська','Львівський','м. Львів','бульвар Тараса Шевченка','43',null),

('PROVIDER',3,'ЛьвівОблЕнерго','lviv_energo@gmail.com', '2911214', null, null,
'79045','Львівська','Львівський','м. Львів','вул. Морозенка','12а',null),

('PROVIDER',4,'ЛьвівТепло','lviv_warm@gmail.com', '2914593', null, null,
'79055','Львівська','Львівський','м. Львів','бульвар Тараса Шевченка','43',null),



('CALIBRATOR',5,'Омега','omega@gmail.com', '2913467', '2014-7-04', '47549',
'79011','Львівська','Львівський','м. Львів','вул. Київська','11',null),

('CALIBRATOR',6,'Оріон','orion@gmail.com', '2914365', '2013-11-11', '69365',
'79023','Львівська','Львівський','м. Львів','вул. Київська','2',null),



('STATE_VERIFICATION',7,'СДГО ЛВ','sdgo_lv@gmail.com', '2915496', '2014-7-04', '47549',
'79011','Львівська','Львівський','м. Львів','вул. Київська','11',null),

('STATE_VERIFICATION',8,'СПМО ЛВ','spmo_lv@gmail.com', '2914309', '2013-11-11', '69365',
'79023','Львівська','Львівський','м. Львів','вул. Київська','2',null);




-- ------------------------------- USER ----------------------------- --
INSERT INTO `measurement_devices`.`User`
(`userType`,`username`,`password`,`role`,
`email`,`firstName`,`lastName`,`phone`,`organization_id`)

VALUES

('SYS_ADMIN','admin','$2a$10$xTq90ybFNT/W0TfNHdQ4e.0DL1WO/7vebrpDZybGRwdEk/7F8ULEi','SYS_ADMIN', 
null, null, null, null, null),



('PROVIDER_EMPLOYEE','lviv_vodoKanal_employee','1234abc','PROVIDER_EMPLOYEE', 
'lviv_vodoKanal_employee@gmail.com', 'Романів', 'Роман', '0684589473', 1),
('PROVIDER_EMPLOYEE','lviv_gaz_employee','1234abc','PROVIDER_EMPLOYEE', 
'lviv_gaz_employee@gmail.com', 'Джеймс', 'Бонд', '0688946349', 2),



('CALIBRATOR_EMPLOYEE','lv_calib_omega','1234abc','CALIBRATOR_EMPLOYEE', 
'lv_calib_omega@gmail.com', 'Олена', 'Іванова', '0687463749', 5),
('CALIBRATOR_EMPLOYEE','lv_calib_orion','1234abc','CALIBRATOR_EMPLOYEE', 
'lv_calib_orion@gmail.com', 'Надія', 'Іванова', '0687540683', 6),



('STATE_VERIFICATOR_EMPLOYEE','lv_verif_sdgo_lv','1234abc','STATE_VERIFICATOR_EMPLOYEE', 
'lv_verif_sdgo_lv@gmail.com', 'Іван', 'Іванів', '0688926548', 7),
('STATE_VERIFICATOR_EMPLOYEE','lv_verif_spmo_lv','1234abc','STATE_VERIFICATOR_EMPLOYEE', 
'lv_verif_spmo_lv@gmail.com', 'Віктор', 'Вікторів', '0688926548', 8);





-- --------------------------- MANUFACTURER ---------------------------- --
INSERT INTO `measurement_devices`.`Manufacturer`
(`id`,`name`)
VALUES
(1,'самвода'),
(2,'самгаз'),
(3,'самелктро'),
(4,'самтепло');


-- ----------------------------- DEVICE ------------------------- --
INSERT INTO `measurement_devices`.`Device`
(`deviceType`, `id`,`number`,`manufacturer_id`,`provider_id`, `deviceSign`)
VALUES
('WATER',1,'58365',1,1,'СА3К'),
('GASEOUS',2,'58365',2,2,'А3КЕ'),
('ELECTRICAL',3,'58365',3,3,'СППП'),
('THERMAL',4,'58365',4,4,'ЕР4Н');


-- ---------------------------- VERIFICATION ------------------------- --
INSERT INTO `measurement_devices`.`Verification`
(`id`,
`postal_index`,`region`,`district`,`locality`,`street`,`building`,`flat`, -- client/device address
`firstName`,`lastName`,`middleName`,`email`,`phone`, -- client data
`code`, -- generated code that is to be sent to user via email
`status`,`verificationFinishedDate`, 
`calibrator_id`,`deviceId`,`provider_id`,`stateVerificator_id`,
`calibratorEmployee_username`,`providerEmployee_username`,`stateVerificatorEmployee_username`)

VALUES

(1,
'79045','Львівська','Львівський','м. Львів','вул. Морозенка','12а',null,
'Петро', 'Палій', 'Ігорович', 'oleg.paliy@gmail.com', '0687538954',
'877c48fh129fu1j10rf1hf10if21irh0fi',
'COMPLETED', '2015-4-04',
5,1,1,7,
'lv_calib_omega', 'lviv_vodoKanal_employee', 'lv_verif_sdgo_lv'
);




-- ---------------------------- CALIBRATION TEST ------------------------ --
INSERT INTO `measurement_devices`.`CalibrationTest`
(`id`,`verification_id`,
`document_name`,`document_sign`,
`dateTest`,
`consumptionStatus`,`latitude`,`longitude`,`name`,`photoPath`,`settingNumber`,`temperature`,`testResult`)

VALUES

(1,1,
'Державна система забезпечення єдності вимірювань', 'ДСТУ 2681-94',
'2015-4-04',
11.0,11.0,22.0,'Періодична повірка','/images/photo','2',12,'36');


-- -------------------------- CALIBRATION TEST DATA ------------------- --
INSERT INTO `measurement_devices`.`CalibrationTestData`
(`id`,`calibrationTest_id`,
`acceptableError`,`actualConsumption`,`consumptionStatus`,`endValue`,`givenConsumption`,`initialValue`,
`testTime`,`volumeInDevice`,`volumeOfStandart`)

VALUES

(1, 1, 
10.0, 20.0, 15.0, 17.6, 11.4, 23.4, 2.22, 2, 2);