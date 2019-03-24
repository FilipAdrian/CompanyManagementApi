CREATE SEQUENCE public.subsidiary_id_seq
START WITH 100
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

create table public.subsidiary
(
    id integer primary key Default nextval('public.subsidiary_id_seq'::regclass),
    name varchar(255) unique not null,
    location varchar(255) unique not null,
    phone varchar(100) UNIQUE NOT NULL
);

Insert into subsidiary(name,location,phone)
values
('Walles Corporation SRL','Chisinau , str.Ioan Cuza 78','+37323722520'),
('AutoMall SRL','Chisinau , str.Mihai Viteazu 8','+37323722987'),
('Tires','Balti, str. Independenti 5', '+37369658473');

CREATE SEQUENCE public.employee_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

create table public.employee
(
    id integer primary key Default nextval('public.employee_id_seq'::regclass),
    name varchar(255) unique not null,
    surname varchar(255) unique not null,
    role varchar (50) NOT NULL,
    phone varchar(100) UNIQUE,
    email varchar(255) UNIQUE NOT NULL,
    id_subsidiary integer not null,
    address varchar (200) NOT NULL,
    	FOREIGN KEY (id_subsidiary) REFERENCES subsidiary (id)
);

insert into employee(name,surname,role,phone,email,id_subsidiary,address)
values
('Gonta','Ion','Manager','+3735689202','ion.gonta@gmail.com',100,'Straseni,str. Stefan cel Mare 2'),
('Radu','Galina','Seller','+37369653214','galina.radu@gmail.com',101,'Chisinau,str.Florilor 21'),
('Calmis','Mihai','Administrator','+3736023333','mihai.calmis@gmail.com',100,'Durlesti, str. Teilor 8');

CREATE TABLE public.product
(
    id varchar (100) PRIMARY KEY,
    name varchar(255) NOT NULL,
	price money NOT NULL,
	manufacturer varchar(255) NOT NULL,
    id_subsidiary integer NOT NULL,
	FOREIGN KEY (id_subsidiary) REFERENCES subsidiary (id)
);

insert into product
values
( '0224327', 'Arm assy right upper front',31.76, 'CAN-AM', 100),
( '0224328', 'Arm assy left upper front',34.92, 'OS-RAM', 100),
( 'L3K913111', 'Gasket intake manifold',12.67, 'OS-RAM', 102),
( 'MPH35', 'Brake pad set rear',12.92, 'CAN-AM', 100),
( '219102H150', 'Engine mount bracket front',33.73, 'CAN-AM',102),
( '872141H000', 'Cover moulding',2.06, 'FEBEST', 102),
( '553302S150', 'Bracket rear shock absorber',21.28, 'TOYOTA',101),
( '577193Q000', 'Yoke assy rack-support',22.78, 'TOYOTA', 101),
( '565213Q000', 'Bush-rack',13.56, 'FEBEST', 100),
( '565211H000', 'Bush-rack',5.22, 'FEBEST', 101),
( '565221H000', 'Yoke assy rack-support',19.96, 'CAN-AM', 100),
( 'L3K910230', 'Gasket engine valve cover',21.08, 'OS-RAM', 101);
