
Insert into subsidiary(name,location,phone)
values
('Walles Corporation SRL','Chisinau , str.Ioan Cuza 78','+37323722520'),
('AutoMall SRL','Chisinau , str.Mihai Viteazu 8','+37323722987'),
('Tires','Balti, str. Independenti 5', '+37369658473');


insert into employee(name,surname,role,phone,email,id_subsidiary,address)
values
('Gonta','Ion','Manager','+3735689202','ion.gonta@gmail.com',1,'Straseni,str. Stefan cel Mare 2'),
('Radu','Galina','Seller','+37369653214','galina.radu@gmail.com',2,'Chisinau,str.Florilor 21'),
('Calmis','Mihai','Administrator','+3736023333','mihai.calmis@gmail.com',1,'Durlesti, str. Teilor 8');

insert into product(id,name,price,manufacturer,id_subsidiary)
values
( '0224327', 'Arm assy right upper front',31.76, 'CAN-AM', 1),
( '0224328', 'Arm assy left upper front',34.92, 'OS-RAM', 1),
( 'L3K913111', 'Gasket intake manifold',12.67, 'OS-RAM', 3),
( 'MPH35', 'Brake pad set rear',12.92, 'CAN-AM', 1),
( '219102H150', 'Engine mount bracket front',33.73, 'CAN-AM',3),
( '872141H000', 'Cover moulding',2.06, 'FEBEST', 3),
( '553302S150', 'Bracket rear shock absorber',21.28, 'TOYOTA',2),
( '577193Q000', 'Yoke assy rack-support',22.78, 'TOYOTA', 2),
( '565213Q000', 'Bush-rack',13.56, 'FEBEST', 1),
( '565211H000', 'Bush-rack',5.22, 'FEBEST', 2),
( '565221H000', 'Yoke assy rack-support',19.96, 'CAN-AM', 1),
( 'L3K910230', 'Gasket engine valve cover',21.08, 'OS-RAM', 2);
