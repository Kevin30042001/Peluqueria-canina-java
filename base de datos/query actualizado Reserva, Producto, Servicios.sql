create database PeluqueriaCanina;
go

USE PeluqueriaCanina
GO

--------------Tabla de Roles-----------------

CREATE TABLE Rol (
    IdRol INT IDENTITY(1,1) PRIMARY KEY,
    NombreRol VARCHAR(50) UNIQUE NOT NULL
);
GO

INSERT INTO Rol (NombreRol)
VALUES ('Administrador'),
       ('Gerente'),
       ('Supervisor'),
       ('Cajero'),
       ('Peluquero'),
       ('Veterinario'),
       ('Director'),
       ('Presidente');
GO

--------------Tabla de Empleados -----------------

CREATE TABLE Empleados (
    IdEmpleado INT IDENTITY(1,1) PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    UserName VARCHAR(25) NOT NULL,
    Clave VARBINARY(500) NOT NULL,
    Email VARCHAR(50) UNIQUE NOT NULL,
    IdRol INT,
    Estado BIT,
    Confirmado BIT,
    Restablecer BIT,
    Token VARCHAR(200),
    Fecha DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (IdRol) REFERENCES Rol (IdRol)
);
GO

--------------Tabla de Clientes -----------------

CREATE TABLE Clientes (
    IdCliente INT IDENTITY(1,1) PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Raza VARCHAR(50) NOT NULL,
    Color VARCHAR(50) NOT NULL,
    Alergico BIT,
    AtencionEsp BIT,
    NombreDueno VARCHAR(100) NOT NULL,
    Telefono VARCHAR(9) NOT NULL,
    Observaciones VARCHAR(100)
);
GO

--------------Tabla de Servicios -----------------

CREATE TABLE Servicios (
    IdServicio INT IDENTITY(1,1) PRIMARY KEY,
    Nombre VARCHAR(100),
    Precio DECIMAL(10, 2)
);
GO

--------------Tabla de Reservas -----------------

CREATE TABLE Reservas (
    CodigoReserva INT IDENTITY(1,1) PRIMARY KEY,
    FechaReserva DATE,
    Hora TIME,
    IdCliente INT,
    Total DECIMAL(10, 2),
    FOREIGN KEY (IdCliente) REFERENCES Clientes(IdCliente)
);
GO

--------------Tabla de Productos -----------------

CREATE TABLE Productos (
    IdProducto INT IDENTITY(1,1) PRIMARY KEY,
    Nombre VARCHAR(100),
    Precio DECIMAL(10, 2)
);
GO

--------------Tabla de DetalleReserva -----------------

CREATE TABLE DetalleReserva (
    CodigoTratamiento INT IDENTITY(1,1) PRIMARY KEY,
    CodigoReserva INT,
    IdServicio INT,
    IdProducto INT,
    Precio DECIMAL(10, 2),
    FOREIGN KEY (CodigoReserva) REFERENCES Reservas(CodigoReserva),
    FOREIGN KEY (IdServicio) REFERENCES Servicios(IdServicio),
    FOREIGN KEY (IdProducto) REFERENCES Productos(IdProducto)
);
GO

--------------Tabla de Pago -----------------

CREATE TABLE Pago (
    IdPago INT IDENTITY(1,1) PRIMARY KEY,
    IdCliente INT,
    CodigoReserva INT,
    FechaPago DATE,
    Total DECIMAL(10, 2),
    FOREIGN KEY (IdCliente) REFERENCES Clientes(IdCliente),
    FOREIGN KEY (CodigoReserva) REFERENCES Reservas(CodigoReserva)
);
GO

--------------Tabla de DetallePago -----------------

CREATE TABLE DetallePago (
    CodigoPago INT IDENTITY(1,1) PRIMARY KEY,
    CodigoTratamiento INT,
    IdProducto INT,
    Precio DECIMAL(10, 2),
    FOREIGN KEY (CodigoTratamiento) REFERENCES DetalleReserva(CodigoTratamiento),
    FOREIGN KEY (IdProducto) REFERENCES Productos(IdProducto)
);
GO





---------------Procedimiento validar Login-----------------------
Create Procedure SP_ValidarLogin
    @UserName varchar(25),
    @Clave varchar(25),
    @Patron varchar(25)
As
Begin
    -- Consulta para validar el inicio de sesi�nus
    Select e.*, r.NombreRol 
    From Empleados e
    Inner Join Rol r On e.Idrol = r.Idrol
    Where e.UserName = @UserName 
        And Convert(varchar(25), DECRYPTBYPASSPHRASE(@Patron, e.Clave)) = @Clave;
End

--SP_ValidarUsuario 'KV','User123*','Pr09r@3'


-------------------Proceso Almacenado Agregar Empleado--------------------------------------------
go
Create Procedure SP_AgregarEmpleado
@Nombre varchar(50),
@UserName varchar(25),
@Clave varchar(25),
@Email varchar(50),
@IdRol int,
@Estado bit,
@Confirmado bit,
@Restablecer bit,
@Patron varchar(25),
@IdEmpleado int output
As
Begin
    -- Insertar un nuevo empleado en la tabla Empleados
    Insert Into Empleados
    (Nombre, UserName, Clave, Email, IdRol, Estado, Confirmado, Restablecer)
    Values
    (@Nombre, @UserName, ENCRYPTBYPASSPHRASE(@Patron, @Clave), @Email, @IdRol, @Estado, @Confirmado, @Restablecer);
    
    -- Obtener el ID del empleado reci�n insertado
    Set @IdEmpleado = (Select @@IDENTITY);
    
    -- Retornar el ID del empleado reci�n insertado
    Return @IdEmpleado;
End
--SP_AgregarEmpleado 'Enzor Reyes','ER','Utec2024*','ER@gmail.com',2,1,0,0,'Pr09r@3',0
------------------ Proceso Almacenado Modificar Empleado ------------------------------------------------
go
CREATE Procedure SP_ModificarEmpleado
@IdEmpleado int,
@Nombre varchar(50),
@UserName varchar(25),
@Clave varchar(25),
@Email varchar(50),
@IdRol int,
@Estado bit,
@Confirmado bit,
@Restablecer bit,
@Patron varchar(25),
@Resp int output
As
Begin
    -- Modificar un empleado en la tabla Empleados
    Update Empleados
    Set
        Nombre = @Nombre,
        UserName = @UserName,
        Clave = ENCRYPTBYPASSPHRASE(@Patron, @Clave),
        Email = @Email,
        IdRol = @IdRol,
        Estado = @Estado,
        Confirmado = @Confirmado,
        Restablecer = @Restablecer
    Where IdEmpleado = @IdEmpleado;
    
    -- Indicar que la modificaci�n fue exitosa
    Set @Resp = 1;
    Return @Resp;
End
--SP_ModificarEmpleado 3,'Mar�a Esperanza Flores Ayala','MF','Utec2024*','mf@gmail.com',2,1,1,0,'Pr09r@3',0


------------------- Proceso Almacenado Eliminar Empleado ------------------------------------------
go
CREATE Procedure SP_EliminarEmpleado
@IdEmpleado int,
@Resp int output
As
Begin
    -- Eliminar un empleado de la tabla Empleados
    Delete From Empleados Where IdEmpleado = @IdEmpleado;
    
    -- Indicar que la eliminaci�n fue exitosa
    Set @Resp = 1;
    Return @Resp;
End
--SP_EliminarEmpleado 4,0

-------------- Proceso Almacenado Buscar Empleado ----------------------------------------------

go
CREATE Procedure SP_BuscarEmpleado
@IdEmpleado int,
@Nombre varchar(50),
@UserName varchar(25),
@Email varchar(50),
@IdRol int,
@Estado char(1) --A=Activos, I=Inactivos y T=Todos
As
Begin
    If (@IdEmpleado > 0)
        Select e.*, r.NombreRol 
        From Empleados e 
        Inner Join Rol r On e.IdRol = r.IdRol 
        Where IdEmpleado = @IdEmpleado
    Else If (Len(@Nombre) > 0)
    Begin
        If (Upper(@Estado) = 'A')
            Select e.*, r.NombreRol 
            From Empleados e 
            Inner Join Rol r On e.IdRol = r.IdRol 
            Where Nombre Like '%' + @Nombre + '%'
            And Estado = 1
        Else If (Upper(@Estado) = 'I')
            Select e.*, r.NombreRol 
            From Empleados e 
            Inner Join Rol r On e.IdRol = r.IdRol 
            Where Nombre Like '%' + @Nombre + '%'
            And Estado = 0
        Else
            Select e.*, r.NombreRol 
            From Empleados e 
            Inner Join Rol r On e.IdRol = r.IdRol 
            Where Nombre Like '%' + @Nombre + '%'
    End
    Else If (Len(@UserName) > 0)
        Select e.*, r.NombreRol 
        From Empleados e 
        Inner Join Rol r On e.IdRol = r.IdRol 
        Where UserName = @UserName
    Else If (Len(@Email) > 0)
        Select e.*, r.NombreRol 
        From Empleados e 
        Inner Join Rol r On e.IdRol = r.IdRol 
        Where Email = @Email
    Else If (@IdRol > 0)
    Begin
        If (Upper(@Estado) = 'A')
            Select e.*, r.NombreRol 
            From Empleados e 
            Inner Join Rol r On e.IdRol = r.IdRol 
            Where e.IdRol = @IdRol
            And Estado = 1
        Else If (Upper(@Estado) = 'I')
            Select e.*, r.NombreRol 
            From Empleados e 
            Inner Join Rol r On e.IdRol = r.IdRol 
            Where e.IdRol = @IdRol
            And Estado = 0
        Else
            Select e.*, r.NombreRol 
            From Empleados e 
            Inner Join Rol r On e.IdRol = r.IdRol 
            Where e.IdRol = @IdRol
    End
    Else
    Begin
        If (Upper(@Estado) = 'A')
            Select e.*, r.NombreRol 
            From Empleados e 
            Inner Join Rol r On e.IdRol = r.IdRol 
            Where Estado = 1
        Else If (Upper(@Estado) = 'I')
            Select e.*, r.NombreRol 
            From Empleados e 
            Inner Join Rol r On e.IdRol = r.IdRol 
            Where Estado = 0
        Else
            Select e.*, r.NombreRol 
            From Empleados e 
            Inner Join Rol r On e.IdRol = r.IdRol
    End
End


--SP_BuscarEmpleado 3,'Mar�a Esperanza Flores Ayala','MF','mf@gmail.com',2,1

------------SP VALIDACION DE ROL-----------------------------

go
CREATE Procedure SP_Rol
As
Begin
	Select * From Rol
End

SP


-------------------Proceso Almacenado Agregar Clientes--------------------------------------------
go
CREATE PROCEDURE SP_AgregarCliente
    @Nombre VARCHAR(50),
    @Raza VARCHAR(50),
    @Color VARCHAR(50),
    @Alergico BIT,
    @AtencionEsp BIT,
    @NombreDueno VARCHAR(100),
    @Telefono VARCHAR(9),
    @Observaciones VARCHAR(100),
    @IdCliente INT OUTPUT
AS
BEGIN
    -- Insertar un nuevo cliente en la tabla Clientes
    INSERT INTO Clientes
    (Nombre, Raza, Color, Alergico, AtencionEsp, NombreDueno, Telefono, Observaciones)
    VALUES
    (@Nombre, @Raza, @Color, @Alergico, @AtencionEsp, @NombreDueno, @Telefono, @Observaciones);

    -- Obtener el ID del cliente reci�n insertado
    SET @IdCliente = SCOPE_IDENTITY();
END
   
END

--SP_AgregarCliente 'zeus','doberman','Blanco',0,0,'kevin','7190-6302','Prueba'
------------------ Proceso Almacenado Modificar Clientes ------------------------------------------------
go
CREATE PROCEDURE SP_ModificarCliente
    @IdCliente INT,
    @Nombre VARCHAR(50),
    @Raza VARCHAR(50),
    @Color VARCHAR(50),
    @Alergico BIT,
    @AtencionEsp BIT,
    @NombreDueno VARCHAR(100),
    @Telefono VARCHAR(9),
    @Observaciones VARCHAR(100),
    @Resp INT OUTPUT
AS
BEGIN
    -- Modificar un cliente en la tabla Clientes
    UPDATE Clientes
    SET
        Nombre = @Nombre,
        Raza = @Raza,
        Color = @Color,
        Alergico = @Alergico,
        AtencionEsp = @AtencionEsp,
        NombreDueno = @NombreDueno,
        Telefono = @Telefono,
        Observaciones = @Observaciones
    WHERE IdCliente = @IdCliente;
    
    -- Indicar que la modificaci�n fue exitosa
    SET @Resp = 1;
    SELECT @Resp AS 'Respuesta';
END

--SP_ModificarCliente 2,'Oso','Pastor Aleman','Cafe con Negro',0,0,'Saul Tejada','7190-6302','Prueba',0


------------------- Proceso Almacenado Eliminar Cliente ------------------------------------------
go
CREATE PROCEDURE SP_EliminarCliente
    @IdCliente INT,
    @Resp INT OUTPUT
AS
BEGIN
    -- Eliminar un cliente de la tabla Clientes
    DELETE FROM Clientes WHERE IdCliente = @IdCliente;
    
    -- Indicar que la eliminaci�n fue exitosa
    SET @Resp = 1;
    SELECT @Resp AS 'Respuesta';
END

--SP_EliminarCliente 1,0

-------------- Proceso Almacenado Buscar Cliente ----------------------------------------------

go
CREATE PROCEDURE SP_BuscarCliente
    @IdCliente INT = NULL,
    @Nombre VARCHAR(50) = NULL,
    @Raza VARCHAR(50) = NULL,
    @Color VARCHAR(50) = NULL,
    @NombreDueno VARCHAR(100) = NULL
	@DUI VARCHAR(10) = NULL

AS
BEGIN
    SELECT *
    FROM Clientes
    WHERE
        (COALESCE(@IdCliente, 0) = 0 OR IdCliente = COALESCE(@IdCliente, 0))
        AND (COALESCE(@Nombre, '') = '' OR Nombre LIKE COALESCE(@Nombre, '') + '%')
        AND (COALESCE(@Raza, '') = '' OR Raza LIKE COALESCE(@Raza, '') + '%')
        AND (COALESCE(@Color, '') = '' OR Color LIKE COALESCE(@Color, '') + '%')
        AND (COALESCE(@NombreDueno, '') = '' OR NombreDueno LIKE COALESCE(@NombreDueno, '') + '%')
        AND (COALESCE(@DUI, '') = '' OR DUI = COALESCE(@DUI,�''));
END


--SP_BuscarCliente 'Benji',1,'Pastor','Cafe','Saul Tejada'