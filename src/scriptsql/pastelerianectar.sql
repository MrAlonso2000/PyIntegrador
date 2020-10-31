create database pastelerianectar
go
use pastelerianectar
go
create table usuario(
id int identity(1,1) not null primary key,
nombre varchar(30) not null,
apellido varchar(30) not null,
correo varchar(30) not null,
pwd varchar(30) not null,
direccion varchar(30) not null,
perfil varchar(30) not null
)

