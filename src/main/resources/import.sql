INSERT INTO ROLES (ROL, FECHA_CREACION) VALUES('ADMIN', SYSDATE);
INSERT INTO ROLES (ROL, FECHA_CREACION) VALUES('USER', SYSDATE);
INSERT INTO ROLES (ROL, FECHA_CREACION) VALUES('CONSULTOR', SYSDATE);


INSERT INTO USUARIOS (NOMBRE, APELLIDO, PASSWORD, EMAIL, TELEFONO, ROL, FECHA_CREACION)VALUES ('FRANCISCO', 'RUIZ', 'PASSWORD', 'FRANCISCO@EMAIL.COM', 123456789, 1, SYSDATE);
INSERT INTO USUARIOS (NOMBRE, APELLIDO, PASSWORD, EMAIL, TELEFONO, ROL, FECHA_CREACION)VALUES ('JAVIER', 'GUZMÁN', 'PASSWORD', 'JAVIER@EMAIL.COM', 987654321, 2, SYSDATE);
INSERT INTO USUARIOS (NOMBRE, APELLIDO, PASSWORD, EMAIL, TELEFONO, ROL, FECHA_CREACION)VALUES ('ANTONIO', 'MORA', 'PASSWORD', 'ANTONIO@EMAIL.COM', 123987456, 3, SYSDATE);
INSERT INTO USUARIOS (NOMBRE, APELLIDO, PASSWORD, EMAIL, TELEFONO, ROL, FECHA_CREACION)VALUES ('OSCAR', 'PÉREZ', 'PASSWORD', 'OSCAR@EMAIL.COM', 654123789, 3, SYSDATE);
INSERT INTO USUARIOS (NOMBRE, APELLIDO, PASSWORD, EMAIL, TELEFONO, ROL, FECHA_CREACION)VALUES ('LUCAS', 'ABALDE', 'PASSWORD', 'LUCAS@EMAIL.COM', 465231897, 2, SYSDATE);

