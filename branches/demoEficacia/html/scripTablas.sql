CREATE TABLE PIF_COMPROBANTE(
CMP_ID bigserial NOT NULL,
CMP_NUMERO VARCHAR (50) NOT NULL,
CMP_FECHA_GENERACION Date NOT NULL,
CMP_ID_USUARIO Varchar (50) NOT NULL,
CMP_PAGO_CONFIRMADO Varchar (1) NOT NULL,
CMP_PAGO_NOTIFICADO Varchar (1) NOT NULL,
CMP_CODIGO_AUTORIZACION Varchar(50) NULL,
CMP_FIRMA_DIGITAL_GENERADA Varchar(150) NULL,
CMP_NUMERO_TRANSACCION Varchar(20) NULL,
CMP_METODO_PAGO Varchar(50) NULL
);

select * from dual;

ALTER TABLE PIF_COMPROBANTE ADD CONSTRAINT CMP_ID PRIMARY KEY (CMP_ID);

CREATE TABLE PIF_FACTURA(
FAC_ID bigserial NOT NULL,
CMP_ID  Integer NOT NULL,
FAC_NUMERO_FACTURA Varchar (50) NOT NULL
);

ALTER TABLE PIF_FACTURA ADD CONSTRAINT FAC_ID PRIMARY KEY (FAC_ID);

ALTER TABLE PIF_FACTURA ADD CONSTRAINT FACTURA_COMPROBANTE FOREIGN KEY (CMP_ID) REFERENCES PIF_COMPROBANTE (CMP_ID);

commit;
