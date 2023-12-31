--Mariel Daniela Rojas S�nchez
--208030487
--Septiembre 2023

-- Creaci�n de la base de datos
CREATE DATABASE VETERINARIA
GO

USE VETERINARIA
GO

--DROP DATABASE  VETERINARIA

--------------------------------------------------------------------------------------------------------------------
-- CRREACION DE LAS TABLAS 

CREATE TABLE CLIENTE(
	ID_CLIENTE INT PRIMARY KEY IDENTITY(1,1),
	NOMBRE VARCHAR(50) NOT NULL,
	APELLIDO VARCHAR(50) NOT NULL,
	TELEFONO VARCHAR(11) NULL,
	EMAIL  VARCHAR(45) NOT NULL,
)
GO
-- tabla trabajadoress
CREATE TABLE TRABAJADOR(
	ID_TRABAJADOR INT PRIMARY KEY IDENTITY(1,1),
	NOMBRE VARCHAR(50) NOT NULL,
	APELLIDO VARCHAR(50) NOT NULL,
	TELEFONO VARCHAR(11) NULL,
	EMAIL  VARCHAR(45) NOT NULL,
	PUESTO_TRABAJO VARCHAR(35) CONSTRAINT CHK_PUESTO CHECK(PUESTO_TRABAJO IN ('Vendedor','Veterinaria','Veterinario','Vendedora'))  NOT NULL
)
GO

-- tabla Productos/servicios
CREATE TABLE PRODUCTO(
    ID_PRODUCTO INT IDENTITY(1,1) PRIMARY KEY,
    NOMBRE VARCHAR(100) NOT NULL, -- poder agregar servicios en nombre
    PRECIO DECIMAL(10, 2) NOT NULL,
    CANTIDAD_DISPONIBLE INT CHECK(CANTIDAD_DISPONIBLE>=0),  -- como puede ser un servicio, no necesariamente tiene que haber cantidad,no puede ser menor a cero
	--FECHA_VENCIMIENTO DATE DEFAULT NULL,
	--LOTE VARCHAR(15),
	CATEGORIA VARCHAR(25) --CONSTRAINT CHK_CATEGORIA CHECK(CATEGORIA IN ('Alimento','Juguetes','Medicamentos','Servicios'))
);
GO

--  Facturas compra
CREATE TABLE FACTURA_COMPRA (
    ID_FACTURA_COMPRA INT IDENTITY(1,1) PRIMARY KEY,
	TOTAL DECIMAL(10, 2) CHECK (TOTAL >= 0) NOT NULL,
    FECHA DATE DEFAULT GETDATE(),
	ESTADO VARCHAR(10) CONSTRAINT CHK_ESTADO1
        CHECK(ESTADO IN ('Cancelada', 'Pendiente', 'Anulada')) DEFAULT 'Cancelada',
	PROVEEDOR VARCHAR(65) NOT NULL
);
GO

--DetalleFactura compra
CREATE TABLE DETALLE_FACTURA_COMPRA (
    ID_DETALLE_COMPRA INT IDENTITY(1,1) PRIMARY KEY,
	ID_FACTURA_COMPRA INT FOREIGN KEY REFERENCES FACTURA_COMPRA(ID_FACTURA_COMPRA),
	ID_PRODUCTO INT FOREIGN KEY REFERENCES PRODUCTO(ID_PRODUCTO),
    CANTIDAD INT CHECK (CANTIDAD >= 0) NOT NULL,
	PRECIO_COMPRA DECIMAL(10, 2)CHECK (PRECIO_COMPRA >= 0) NOT NULL,
);
GO

--  Facturas venta
CREATE TABLE FACTURA (
    ID_FACTURA INT IDENTITY(1,1) PRIMARY KEY,
	FECHA DATE NOT NULL DEFAULT GETDATE(),
    ID_CLIENTE INT NOT NULL FOREIGN KEY REFERENCES CLIENTE(ID_CLIENTE), -- llave foranea
	SUBTOTAL DECIMAL(10, 2) CHECK (SUBTOTAL >= 0) NOT NULL,
    IMPUESTO DECIMAL(10, 2),
	DESCUENTO DECIMAL(10, 2),
	ESTADO VARCHAR(10)CONSTRAINT CHK_ESTADO2
        CHECK(ESTADO IN ('Cancelada', 'Pendiente', 'Anulada')) DEFAULT 'Pendiente',
	

);
GO

--DetalleFactura venta
CREATE TABLE DETALLE_FACTURA (
	ID_FACTURA INT FOREIGN KEY REFERENCES FACTURA(ID_FACTURA), -- llave foranea
	ID_PRODUCTO INT FOREIGN KEY REFERENCES PRODUCTO(ID_PRODUCTO), -- llave foranea
    CANTIDAD INT NOT NULL,
    PRECIO_VENTA DECIMAL(10, 2) NOT NULL,
);
GO

-- Crear la tabla de Mascotas
--CREATE TABLE MASCOTA (
--    ID_MASCOTA INT IDENTITY(1,1) PRIMARY KEY,
--    NOMBRE VARCHAR(100),
--    ESPECIE VARCHAR(50),
--    RAZA VARCHAR(50),
--    FECHA_NACIMIENTO DATE,
--    ID_CLIENTE INT NOT NULL FOREIGN KEY REFERENCES CLIENTE(ID_CLIENTE) -- llave foranea
--);
--GO

---- Historial Medicos
--CREATE TABLE HISTORIAL_MEDICO (
--	ID_HISTORIAL INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
--    ID_MASCOTA INT NOT NULL FOREIGN KEY REFERENCES MASCOTA(ID_MASCOTA),
--    ID_TRABAJADOR INT NOT NULL FOREIGN KEY REFERENCES TRABAJADOR(ID_TRABAJADOR),
--    DESCRIPCION VARCHAR(200) NOT NULL,
--    FECHA DATE NOT NULL
--);
--GO


--------------------------------------------------------------------------------------------------------------------
-- INSERTAR DATOS EN LAS TABLAS 

-- tabla clientes
INSERT INTO CLIENTE(NOMBRE,APELLIDO,TELEFONO,EMAIL) 
			VALUES('Mariel','Rojas','83912061','marielrojas50@gmail.com'),
				  ('Veronica','Blanco','60227090','vero.bro14@gmail.com'),
				  ('Mauren','S�nchez','688360383','sanc64@gmail.com'),
				  ('Estefany','Rojas','85684516','tefyro@gmail.com');
								

INSERT INTO TRABAJADOR(NOMBRE,APELLIDO,TELEFONO,EMAIL,PUESTO_TRABAJO) 
			VALUES('Juan','Pacheco','83915648','juan50@gmail.com','Vendedor'),
				  ('Andres','Lopez','60228040','andre@gmail.com','Veterinaria');
	
	
INSERT INTO PRODUCTO(NOMBRE,PRECIO,CANTIDAD_DISPONIBLE,CATEGORIA)
			VALUES('Purina Cat Show',1300,94,'Alimento'),
				 ('S�per Perro',1400,58,'Alimento'),
				 ('Bola goma',1700,8,'Juguetes'),
				 ('Purina Pro Plan',2000,26,'Alimento'),
				 ('Peluche dinosaurio',1400,11,'Juguetes'),
				 ('NexGard',5400,30,'Medicamentos');

--INSERT INTO MASCOTA(NOMBRE,ESPECIE,RAZA,FECHA_NACIMIENTO,ID_CLIENTE)
--			VALUES('Brisa','Canina','Poodle','28/05/2022',1),
--				  ('Luna','Canina','Beagle','12/04/2020',2),
--				  ('Nala','Canina',NULL,'28/05/2017',3),
--				  ('Milan','Canina',NULL,'24/08/2015',4),
--				  ('Charlie','Ave',NULL,'25/08/2023',1);

--INSERT INTO FACTURA_COMPRA(TOTAL,FECHA,ESTADO,PROVEEDOR)
--			VALUES(122100,'15/08/2023','Cancelada','Purina'),
--				  (30000,'11/09/2023','Cancelada','Super Perro'),
--				  (25000,'04/08/2023','Cancelada','DogToy'),
--				  (26000,'01/08/2023','Cancelada','Purina');

--INSERT INTO DETALLE_FACTURA_COMPRA(ID_FACTURA_COMPRA,ID_PRODUCTO,CANTIDAD,PRECIO_COMPRA)
--			VALUES(1,1,100,1100),
--				  (2,2,25,1200),
--				  (3,3,5,1500),
--				  (1,1,11,1100);

--INSERT INTO FACTURA_VENTA(ID_CLIENTE,TOTAL,FECHA,ESTADO,METODO_PAGO)
--			VALUES(1,1,2400,'18/9/2023','Cancelada','Efectivo'),
--				  (2,1,2800,'18/9/2023','Cancelada','Efectivo'),
--				  (3,1,1700,'18/9/2023','Cancelada','Sinpe'),
--				  (1,1,1100,'18/9/2023','Cancelada','Efectivo');

--INSERT INTO DETALLE_FACTURA_VENTA(ID_FACTURA_VENTA,ID_PRODUCTO,CANTIDAD,PRECIO_VENTA)
--			VALUES(1,1,1,1300),
--				  (2,2,2,1400),
--				  (3,3,1,1700),
--				  (1,1,1,1100);
-----------------------------------------------------------------
--TRIGGERS
-- ACTUALIZAR INVENTARIO
GO
CREATE or alter TRIGGER TR_ACTUALIZAR_INVENTARIO
ON DETALLE_FACTURA 
INSTEAD OF DELETE
AS
	DECLARE @ID_FACTURA INT,
			@CODIGO_PRODUCTO INT, 
	        @CANTIDAD_VENDIDA INT,
			@EXISTENCIA INT

	SELECT @ID_FACTURA = ID_FACTURA FROM deleted
	SELECT @CODIGO_PRODUCTO = ID_PRODUCTO FROM deleted
	SELECT @CANTIDAD_VENDIDA = CANTIDAD FROM deleted
	
	SELECT @EXISTENCIA = (SELECT CANTIDAD_DISPONIBLE
								   FROM PRODUCTO P INNER JOIN deleted
								   ON P.ID_PRODUCTO = deleted.ID_PRODUCTO)
	UPDATE PRODUCTO SET CANTIDAD_DISPONIBLE = @EXISTENCIA + @CANTIDAD_VENDIDA WHERE ID_PRODUCTO = @CODIGO_PRODUCTO  
	DELETE DETALLE_FACTURA WHERE ID_PRODUCTO = @CODIGO_PRODUCTO AND ID_FACTURA =  @ID_FACTURA

GO 


GO
-- ACTUALIZAR INVENTARIO
CREATE or alter TRIGGER TR_ACTUALIZA_INVENTARIO
ON DETALLE_FACTURA 
INSTEAD OF INSERT, UPDATE
AS
	DECLARE @ID_FACTURA INT, @CODIGO_PRODUCTO INT,  @CANTIDAD_VENDIDA INT,
			@EXISTENCIA INT, @PRECIOVENTA INT, @CANTIDADANTERIOR INT

	SELECT @ID_FACTURA = ID_FACTURA FROM inserted
	SELECT @CODIGO_PRODUCTO = ID_PRODUCTO FROM inserted
	SELECT @CANTIDAD_VENDIDA = CANTIDAD FROM inserted
	SELECT @PRECIOVENTA = PRECIO_VENTA FROM inserted
	
	SELECT @EXISTENCIA = (SELECT CANTIDAD_DISPONIBLE FROM PRODUCTO P INNER JOIN inserted
								           ON P.ID_PRODUCTO = inserted.ID_PRODUCTO)
	--IF (@CANTIDAD_VENDIDA <= @EXISTENCIA)
	--	BEGIN
			IF NOT EXISTS(SELECT 1 FROM DETALLE_FACTURA WHERE ID_FACTURA=@ID_FACTURA AND ID_PRODUCTO = @CODIGO_PRODUCTO) 
					BEGIN
						UPDATE PRODUCTO SET CANTIDAD_DISPONIBLE = @EXISTENCIA - @CANTIDAD_VENDIDA WHERE ID_PRODUCTO = @CODIGO_PRODUCTO
						INSERT INTO DETALLE_FACTURA(ID_FACTURA,ID_PRODUCTO,CANTIDAD,PRECIO_VENTA)
							VALUES( @ID_FACTURA,@CODIGO_PRODUCTO,@CANTIDAD_VENDIDA,@PRECIOVENTA)
					END
				ELSE
					BEGIN
						SET @CANTIDADANTERIOR = (SELECT CANTIDAD FROM DETALLE_FACTURA 
													WHERE ID_FACTURA=@ID_FACTURA AND ID_PRODUCTO = @CODIGO_PRODUCTO)
						UPDATE PRODUCTO SET CANTIDAD_DISPONIBLE = @EXISTENCIA - (@CANTIDAD_VENDIDA-@CANTIDADANTERIOR) 
											WHERE ID_PRODUCTO = @CODIGO_PRODUCTO
						UPDATE DETALLE_FACTURA SET CANTIDAD = @CANTIDAD_VENDIDA 
												WHERE ID_FACTURA=@ID_FACTURA AND ID_PRODUCTO = @CODIGO_PRODUCTO
					END
		--END
GO
-------------------------------------------------
--GUARDAR FACTURA
GO
CREATE PROCEDURE GUARDAR_FACTURA
	@ID_FACTURA INT OUT,
	@FECHA DATE,
	@ID_CLIENTE INT,
	@SUBTOTAL DECIMAL(10,2),
	@IMPUESTO DECIMAL(10, 2),
	@DESCUENTO DECIMAL(10, 2),
	@ESTADO VARCHAR(10),
	@MSJ VARCHAR(200) OUTPUT
	AS BEGIN
		IF NOT EXISTS(SELECT 1 FROM FACTURA WHERE ID_FACTURA=@ID_FACTURA) 
			BEGIN
				INSERT INTO FACTURA(FECHA,ID_CLIENTE,SUBTOTAL,IMPUESTO,DESCUENTO,ESTADO) 
				VALUES (@FECHA,@ID_CLIENTE,@SUBTOTAL,@IMPUESTO,@DESCUENTO,@ESTADO)
				SET @MSJ='FACTURA INGRESADA'
				SET @ID_FACTURA=IDENT_CURRENT('FACTURA')
			END
		ELSE
			BEGIN
				IF EXISTS(SELECT 1 FROM FACTURA WHERE ID_FACTURA=@ID_FACTURA AND ESTADO='PENDIENTE') 
					BEGIN
						UPDATE FACTURA SET 
						FECHA=@FECHA,ID_CLIENTE=@ID_CLIENTE,SUBTOTAL=@SUBTOTAL,IMPUESTO=@IMPUESTO,DESCUENTO=@DESCUENTO WHERE ID_FACTURA=@ID_FACTURA
						SET @MSJ='FACTURA MODIFICADA'
					END
				ELSE
					SET @MSJ='NO SE PUEDE MODIFICAR LA FACTURA YA QUE NO ESTA PENDIENTE'
			END
	END

GO
-------------------------------------------------

--GUARDAR DETALLE
CREATE OR ALTER PROCEDURE GUARDAR_DETALLE
	@ID_FACTURA INT out,
	@ID_PRODUCTO INT,
	@CANTIDAD INT,
	@PRECIO_VENTA INT,
	@MSJ VARCHAR(200) OUT

	AS BEGIN
		DECLARE @CANT INT
		DECLARE @EXT INT
		DECLARE @DESCRIPCION VARCHAR(200)
		SET @EXT = (SELECT CANTIDAD_DISPONIBLE FROM PRODUCTO WHERE ID_PRODUCTO=@ID_PRODUCTO)

		IF NOT EXISTS(SELECT 1 FROM FACTURA WHERE ID_FACTURA = @ID_FACTURA) 
			BEGIN
				SET @MSJ='NO SE PUEDE AGREGAR EL DETALLE YA QUE LA FACTURA NO EXISTE'
			END
		ELSE
			BEGIN
				IF EXISTS(SELECT 1 FROM FACTURA WHERE ID_FACTURA = @ID_FACTURA AND ESTADO='PENDIENTE') 
					BEGIN
						IF (@EXT < @CANTIDAD )
							BEGIN
								SET @MSJ='CANTIDAD INSUFICIENTE'
							END
						ELSE
							BEGIN 
							IF NOT EXISTS(SELECT 1 FROM DETALLE_FACTURA WHERE ID_FACTURA=@ID_FACTURA AND ID_PRODUCTO=@ID_PRODUCTO) 
								IF @CANTIDAD <= 0
									SET @MSJ='LA CANTIDAD DE PRODUCTOS DEBE SER MAYOR A 0'
								ELSE
									BEGIN
										INSERT INTO DETALLE_FACTURA(ID_FACTURA,ID_PRODUCTO,CANTIDAD,PRECIO_VENTA) 
										VALUES (@ID_FACTURA,@ID_PRODUCTO,@CANTIDAD,@PRECIO_VENTA) 
										SET @MSJ='DETALLE DE FACTURA INGRESADO'
									END
							ELSE
								BEGIN
									SET @CANT = (SELECT CANTIDAD FROM DETALLE_FACTURA WHERE ID_FACTURA = @ID_FACTURA AND ID_PRODUCTO=@ID_PRODUCTO)
									IF ((@CANT + @CANTIDAD) <= 0)
										BEGIN
											DELETE DETALLE_FACTURA WHERE ID_FACTURA = @ID_FACTURA AND ID_PRODUCTO=@ID_PRODUCTO
											IF ((SELECT COUNT(ID_PRODUCTO) FROM DETALLE_FACTURA WHERE ID_FACTURA=@ID_FACTURA)=0)
												BEGIN
													DELETE FACTURA WHERE ID_FACTURA=@ID_FACTURA SET 
													@MSJ='SE ELIMINO DETALLE Y LA FACTURA'
												END
										END											
									ELSE
										IF ((@CANTIDAD) < 0)
											BEGIN
												SET @DESCRIPCION = (SELECT NOMBRE FROM PRODUCTO WHERE ID_PRODUCTO = @ID_PRODUCTO)
												SET @MSJ='SE DEVOLVIERON '+ CAST(@CANT AS varchar) + ' PRODUCTOS DE ' + CAST(@DESCRIPCION AS varchar)
												UPDATE DETALLE_FACTURA SET CANTIDAD=@CANTIDAD + @CANT WHERE ID_FACTURA= @ID_FACTURA AND ID_PRODUCTO=@ID_PRODUCTO
											END
										ELSE
											BEGIN
												UPDATE DETALLE_FACTURA SET CANTIDAD= @CANTIDAD + @CANT WHERE ID_FACTURA = @ID_FACTURA AND ID_PRODUCTO=@ID_PRODUCTO
												SET @DESCRIPCION = (SELECT NOMBRE FROM PRODUCTO WHERE ID_PRODUCTO = @ID_PRODUCTO)
												SET @MSJ= 'SE AGREGARON '+ CAST(@CANTIDAD AS varchar) + ' PRODUCTOS DE ' + CAST(@DESCRIPCION AS varchar)
										END
								END--
						END -- CANTIDAD SUFICIENTE
					END --ESTADO='PENDIENTE'
				ELSE 
					SET @MSJ='NO SE PUEDE MODIFICAR LA FACTURA YA QUE NO ESTA PENDIENTE'
			END
	END

GO

-------------------------------------------------
-- GUARDAR CLIENTE
GO
CREATE OR ALTER PROCEDURE GUARDAR
	@ID_CLIENTE INT OUT,
	@NOMBRE VARCHAR(50),
	@APELLIDO VARCHAR(50),
    @TELEFONO VARCHAR(11),
    @EMAIL VARCHAR(45),
    @MENSAJE VARCHAR(255) OUTPUT
AS BEGIN
		IF NOT EXISTS(SELECT * FROM CLIENTE WHERE ID_CLIENTE=@ID_CLIENTE) 
			BEGIN
				INSERT INTO CLIENTE(NOMBRE,APELLIDO,TELEFONO,EMAIL) 
				VALUES (@NOMBRE,@APELLIDO,@TELEFONO,@EMAIL)
				SET @MENSAJE='CLIENTE INGRESADO'
				SET @ID_CLIENTE=IDENT_CURRENT('CLIENTE')
			END
		ELSE
			BEGIN
				UPDATE CLIENTE SET NOMBRE=@NOMBRE,APELLIDO=@APELLIDO, 
				TELEFONO=@TELEFONO,EMAIL=@EMAIL
				WHERE ID_CLIENTE=@ID_CLIENTE
				SET @MENSAJE='CLIENTE MODIFICADO'
			END
	END
--------------------------------------------------------------------
-- GUARDAR PRODUCTO
GO
CREATE OR ALTER PROCEDURE GUARDARPRODUCTO
	@ID_PRODUCTO INT OUT,
	@NOMBRE VARCHAR(100),
	@PRECIO DECIMAL(10,2),
    @CANTIDAD_DISPONIBLE INT,
    @CATEGORIA VARCHAR(25),
    @MENSAJE VARCHAR(255) OUTPUT
AS BEGIN
		IF NOT EXISTS(SELECT * FROM PRODUCTO WHERE ID_PRODUCTO=@ID_PRODUCTO) 
			BEGIN
				INSERT INTO PRODUCTO(NOMBRE,PRECIO,CANTIDAD_DISPONIBLE,CATEGORIA) 
				VALUES (@NOMBRE,@PRECIO,@CANTIDAD_DISPONIBLE,@CATEGORIA)
				SET @MENSAJE='PRODUCTO INGRESADO'
				SET @ID_PRODUCTO=IDENT_CURRENT('CLIENTE')
			END
		ELSE
			BEGIN
				UPDATE PRODUCTO SET NOMBRE=@NOMBRE,PRECIO=@PRECIO, 
				CANTIDAD_DISPONIBLE=@CANTIDAD_DISPONIBLE,CATEGORIA=@CATEGORIA
				WHERE ID_PRODUCTO=@ID_PRODUCTO
				SET @MENSAJE='PRODUCTO MODIFICADO'
			END
	END
	-------------------------------------------------
-- GUARDAR TRABAJADOR
CREATE TABLE TRABAJADOR(
	ID_TRABAJADOR INT PRIMARY KEY IDENTITY(1,1),
	NOMBRE VARCHAR(50) NOT NULL,
	APELLIDO VARCHAR(50) NOT NULL,
	TELEFONO VARCHAR(11) NULL,
	EMAIL  VARCHAR(45) NOT NULL,
	PUESTO_TRABAJO VARCHAR(35) CONSTRAINT CHK_PUESTO CHECK(PUESTO_TRABAJO IN ('Vendedor','Veterinaria','Veterinario','Vendedora'))  NOT NULL
)
GO

GO
CREATE OR ALTER PROCEDURE GUARDARTRABAJADOR
	@ID_TRABAJADOR INT OUT,
	@NOMBRE VARCHAR(50),
	@APELLIDO VARCHAR(50),
    @TELEFONO VARCHAR(11),
    @EMAIL VARCHAR(45),
	@PUESTO_TRABAJO VARCHAR(35),
    @MENSAJE VARCHAR(255) OUTPUT
AS BEGIN
		IF NOT EXISTS(SELECT * FROM TRABAJADOR WHERE ID_TRABAJADOR=@ID_TRABAJADOR) 
			BEGIN
				INSERT INTO TRABAJADOR(NOMBRE,APELLIDO,TELEFONO,EMAIL,PUESTO_TRABAJO) 
				VALUES (@NOMBRE,@APELLIDO,@TELEFONO,@EMAIL,@PUESTO_TRABAJO)
				SET @MENSAJE='TRABAJADOR INGRESADO'
				SET @ID_TRABAJADOR = IDENT_CURRENT('TRABAJADOR')
			END
		ELSE
			BEGIN
				UPDATE TRABAJADOR SET NOMBRE=@NOMBRE,APELLIDO=@APELLIDO, 
				TELEFONO=@TELEFONO,EMAIL=@EMAIL,PUESTO_TRABAJO=@PUESTO_TRABAJO
				WHERE ID_TRABAJADOR=@ID_TRABAJADOR
				SET @MENSAJE='TRABAJADOR MODIFICADO'
			END
	END

--------------------------------------------------------------------
-- ELIMINAR
GO
CREATE OR ALTER PROCEDURE ELIMINARCLIENTE
    @ID_CLIENTE INT,
    @MENSAJE VARCHAR(50) OUTPUT
	AS BEGIN 
		IF (NOT EXISTS (SELECT 1 FROM CLIENTE WHERE ID_CLIENTE = @ID_CLIENTE)) -- prinmero pregunta que si lel cliente existe
				SET @MENSAJE = 'EL CLIENTE NO EXISTE';
		ELSE
			BEGIN
				IF NOT EXISTS(SELECT 1 FROM FACTURA WHERE ID_CLIENTE=@ID_CLIENTE) 
						BEGIN
							DELETE FROM CLIENTE WHERE ID_CLIENTE=@ID_CLIENTE
							SET @MENSAJE='CLIENTE ELIMINADO'
						END
					ELSE
						SET @MENSAJE='EL CLIENTE NO SE PUEDE ELIMINAR YA QUE TIENE FACTURAS ASOCIADOS'
				END

	END	
	--------------------------------------------------------------------
-- ELIMINAR TRABAJADOR
GO
CREATE OR ALTER PROCEDURE ELIMINARTRABAJADOR
    @ID_TRABAJADOR INT,
    @MENSAJE VARCHAR(50) OUTPUT
	AS BEGIN 
		IF (NOT EXISTS (SELECT 1 FROM TRABAJADOR WHERE ID_TRABAJADOR = @ID_TRABAJADOR)) -- prinmero pregunta que si lel cliente existe
				SET @MENSAJE = 'EL TRABAJADOR NO EXISTE';
		ELSE
			DELETE FROM TRABAJADOR WHERE ID_TRABAJADOR=@ID_TRABAJADOR
			SET @MENSAJE='TRABAJADOR ELIMINADO'
		END

-- ELIMINAR producto
GO
CREATE OR ALTER PROCEDURE ELIMINARPRODUCTO
    @ID_PRODUCTO INT,
    @MENSAJE VARCHAR(50) OUTPUT
AS BEGIN 
	IF NOT EXISTS(SELECT 1 FROM PRODUCTO WHERE ID_PRODUCTO=@ID_PRODUCTO) 
				SET @MENSAJE='EL PRODUCTO NO EXISTE'
			ELSE
				BEGIN
					IF NOT EXISTS(SELECT 1 FROM DETALLE_FACTURA WHERE ID_PRODUCTO=@ID_PRODUCTO) 
						BEGIN
							DELETE FROM PRODUCTO WHERE ID_PRODUCTO=@ID_PRODUCTO
							SET @MENSAJE='PRODUCTO ELIMINADO'
						END
					ELSE
						SET @MENSAJE='EL PRODUCTO NO SE PUEDE ELIMINAR YA QUE TIENE FACTURAS ASOCIADAS'
				END
		END
GO
-------------------------------------------
--ELIMINAR DETALLE
CREATE OR ALTER PROCEDURE ELIMINAR_DETALLE 
		@ID_FACTURA INT, 
		@ID_PRODUCTO INT,
		@MSJ VARCHAR(200) OUT
	AS BEGIN
		BEGIN TRY
			IF NOT EXISTS(SELECT 1 FROM FACTURA WHERE ID_FACTURA=@ID_FACTURA) 
				SET @MSJ='LA FACTURA NO EXISTE'
			ELSE
				BEGIN
					IF EXISTS(SELECT 1 FROM FACTURA WHERE ID_FACTURA=@ID_FACTURA AND ESTADO='PENDIENTE') 
						BEGIN
							BEGIN TRAN
								DELETE DETALLE_FACTURA WHERE ID_FACTURA=@ID_FACTURA AND ID_PRODUCTO=@ID_PRODUCTO
								IF ((SELECT COUNT(ID_PRODUCTO) FROM DETALLE_FACTURA WHERE ID_FACTURA=@ID_FACTURA)=0)
									BEGIN
										DELETE FACTURA WHERE ID_FACTURA=@ID_FACTURA
										SET @MSJ='EL DETALLE Y LA FACTURA FUERON ELIMINADOS'
									END
								ELSE
									SET @MSJ='DETALLE ELIMINAD0'
							COMMIT
						END
					ELSE
						SET @MSJ='LA FACTURA NO SE PUEDE MODIFICAR YA QUE SE ENCUENTRA CANCELADA O ANULADA'
				END
		END TRY
		BEGIN CATCH
			SET @MSJ=ERROR_MESSAGE()
			ROLLBACK TRAN
		END CATCH
	END

GO



----  Calcular� autom�ticamente el total de la factura de compra correspondiente en la tabla FACTURA_COMPRA segun nuevos registros insertados o actualizados en DETALLE_FACTURA_COMPRA. 
--GO
--CREATE OR ALTER TRIGGER TR_CALCULAR_TOTAL_COMPRA
--ON DETALLE_FACTURA_COMPRA
--AFTER INSERT, UPDATE
--AS
--BEGIN
--    UPDATE FC
--    SET FC.TOTAL = (
--        SELECT SUM(DFC.CANTIDAD * DFC.PRECIO_COMPRA)
--        FROM INSERTED DFC
--        WHERE DFC.ID_FACTURA_COMPRA = FC.ID_FACTURA_COMPRA
--    )
--    FROM FACTURA_COMPRA FC
--    INNER JOIN INSERTED I ON FC.ID_FACTURA_COMPRA = I.ID_FACTURA_COMPRA;
--END;
--GO

------ Calcular el total para FACTURA_venta
--CREATE OR ALTER TRIGGER TR_CALCULAR_TOTAL_VENTA
--ON DETALLE_FACTURA_VENTA
--AFTER INSERT, UPDATE
--AS
--BEGIN
--    UPDATE FV
--    SET FV.TOTAL = (
--        SELECT SUM(DFV.CANTIDAD * DFV.PRECIO_VENTA)
--        FROM INSERTED DFV
--        WHERE DFV.ID_FACTURA_VENTA = FV.ID_FACTURA_VENTA
--    )
--    FROM FACTURA_VENTA FV
--    INNER JOIN INSERTED I ON FV.ID_FACTURA_VENTA = I.ID_FACTURA_VENTA;
--END;
--GO



SELECT ID_FACTURA, DETALLE_FACTURA.ID_PRODUCTO,NOMBRE,CANTIDAD,PRECIO_VENTA FROM DETALLE_FACTURA 
INNER JOIN PRODUCTO ON DETALLE_FACTURA.ID_PRODUCTO = PRODUCTO.ID_PRODUCTO

SELECT ID_FACTURA,F.ID_CLIENTE,NOMBRE,FECHA,IMPUESTO,SUBTOTAL,DESCUENTO,ESTADO FROM Factura F INNER JOIN CLIENTE ON CLIENTE.ID_CLIENTE=F.ID_CLIENTE

SELECT D.ID_FACTURA, D.ID_PRODUCTO, P.NOMBRE, D.CANTIDAD,D.PRECIO_VENTA FROM DETALLE_FACTURA D INNER JOIN PRODUCTO P ON D.ID_PRODUCTO = P.ID_PRODUCTO


------------------- CONSULTAS -------------------
SELECT * FROM CLIENTE
SELECT * FROM TRABAJADOR
SELECT * FROM PRODUCTO
SELECT * FROM FACTURA_COMPRA
SELECT * FROM DETALLE_FACTURA_COMPRA
SELECT * FROM FACTURA
SELECT * FROM DETALLE_FACTURA

---------------------------------------------------