CREATE TABLE CUSTOMER (
    CUSTOMERID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    USERNAME VARCHAR(255) NOT NULL UNIQUE,
    "NAME" VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(100) NOT NULL,
    STATUS VARCHAR(100) NOT NULL,
    PHONE VARCHAR(13) NOT NULL,
    MAIL VARCHAR(255) NOT NULL,
    DELIVERYADDRESS VARCHAR (255),
    IMAGE BLOB,
	IMAGETYPE VARCHAR(8), 
	OTP VARCHAR(8), 
    CREATEDDATE TIMESTAMP,
    CREATEDBY VARCHAR(255),
    UPDATEDDATE TIMESTAMP,
    UPDATEDBY VARCHAR(255)
);

CREATE TABLE USERGROUP (
    USERGROUPID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    USERGROUPNAME VARCHAR(255) UNIQUE NOT NULL,
    CREATEDDATE TIMESTAMP,
    CREATEDBY VARCHAR(255),
    UPDATEDDATE TIMESTAMP,
    UPDATEDBY VARCHAR(255)
);

CREATE TABLE PRODUCT(
    PRODUCTID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    PRODUCTNO VARCHAR(255) NOT NULL UNIQUE,
    PRODUCTNAME VARCHAR(255) NOT NULL,
    PRODUCTDESC LONG VARCHAR NOT NULL,
    STATUS VARCHAR(100) NOT NULL,
    CATEGORY VARCHAR(255) NOT NULL,
    ISFEATURED INTEGER NOT NULL,
    PRICE DOUBLE NOT NULL,
    CREATEDDATE TIMESTAMP,
    CREATEDBY VARCHAR(255),
    UPDATEDDATE TIMESTAMP,
    UPDATEDBY VARCHAR(255)
);

CREATE TABLE COURIER (
    COURIERID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    COURIERNAME VARCHAR(255) NOT NULL,
    COURIERPRICE DOUBLE NOT NULL,
    STATUS VARCHAR(100) NOT NULL,
    CREATEDDATE TIMESTAMP,
    CREATEDBY VARCHAR(255),
    UPDATEDDATE TIMESTAMP,
    UPDATEDBY VARCHAR(255)
); 

CREATE TABLE "USER" (
    USERID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    USERGROUPID INTEGER NOT NULL,
    USERNAME VARCHAR(255) NOT NULL UNIQUE,
    "NAME" VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(100) NOT NULL,
    STATUS VARCHAR(100) NOT NULL,
    PHONE VARCHAR(13) NOT NULL,
    MAIL VARCHAR(255) NOT NULL,
    CREATEDDATE TIMESTAMP,
    CREATEDBY VARCHAR(255),
    UPDATEDDATE TIMESTAMP,
    UPDATEDBY VARCHAR(255),
    FOREIGN KEY (USERGROUPID) REFERENCES USERGROUP(USERGROUPID)
);

CREATE TABLE PRODUCTDETAIL(
    PRODUCTDETAILID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    PRODUCTID INTEGER NOT NULL,
    "SIZE" VARCHAR(255) NOT NULL,
    COLOR VARCHAR(255) NOT NULL,
    MINSTOCKQTY INTEGER NOT NULL,
    SALESOUTQTY INTEGER DEFAULT 0,
    PHYSICALQTY INTEGER NOT NULL,
    CREATEDDATE TIMESTAMP,
    CREATEDBY VARCHAR(255),
    UPDATEDDATE TIMESTAMP,
    UPDATEDBY VARCHAR(255),
    FOREIGN KEY (PRODUCTID) REFERENCES PRODUCT(PRODUCTID)
);

CREATE TABLE PRODUCTIMAGE(
    PRODUCTIMAGEID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    PRODUCTID INTEGER NOT NULL,
    IMAGE BLOB NOT NULL,
	IMAGETYPE VARCHAR(8), 
    CREATEDDATE TIMESTAMP,
    CREATEDBY VARCHAR(255),
    UPDATEDDATE TIMESTAMP,
    UPDATEDBY VARCHAR(255),
    FOREIGN KEY (PRODUCTID) REFERENCES PRODUCT(PRODUCTID)
);

CREATE TABLE CART (
    CARTID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    CUSTOMERID INTEGER NOT NULL,
    CREATEDDATE TIMESTAMP,
    CREATEDBY VARCHAR(255),
    UPDATEDDATE TIMESTAMP,
    UPDATEDBY VARCHAR(255),
    FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID)
);

CREATE TABLE "ORDER" (
    ORDERID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    CUSTOMERID INTEGER NOT NULL,
    COURIERID INTEGER NOT NULL,
    ORDERNO VARCHAR(255) NOT NULL UNIQUE,
    RECEIVERNAME VARCHAR(255) NOT NULL,
    TRACKINGNO VARCHAR (255),
    STATUS VARCHAR(100) NOT NULL,
    PRICE DOUBLE NOT NULL,
    DELIVERYADDRESS VARCHAR (255) NOT NULL,
    DELIVERYFEE DOUBLE NOT NULL,
    CREATEDDATE TIMESTAMP,
    CREATEDBY VARCHAR(255),
    UPDATEDDATE TIMESTAMP,
    UPDATEDBY VARCHAR(255),
    FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID),
    FOREIGN KEY (COURIERID) REFERENCES COURIER(COURIERID)
);

CREATE TABLE CARTDETAIL (
    CARTDETAILID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    CARTID INTEGER NOT NULL,
    PRODUCTDETAILID INTEGER NOT NULL,
    QUANTITY INTEGER NOT NULL,
    CREATEDDATE TIMESTAMP,
    CREATEDBY VARCHAR(255),
    UPDATEDDATE TIMESTAMP,
    UPDATEDBY VARCHAR(255),
    FOREIGN KEY (CARTID) REFERENCES CART(CARTID),
    FOREIGN KEY (PRODUCTDETAILID) REFERENCES PRODUCTDETAIL(PRODUCTDETAILID)
);

CREATE TABLE ORDERDETAIL (
    ORDERDETAILID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    ORDERID INTEGER NOT NULL,
    PRODUCTDETAILID INTEGER NOT NULL,
	PRODUCTID INTEGER NOT NULL,
	PRODUCTNO VARCHAR(255) NOT NULL,
    PRODUCTNAME VARCHAR(255) NOT NULL,
    PRICE DOUBLE NOT NULL,
    QUANTITY INTEGER NOT NULL,
    COLOR VARCHAR(255) NOT NULL,
    "SIZE" VARCHAR(255) NOT NULL,
    CREATEDDATE TIMESTAMP,
    CREATEDBY VARCHAR(255),
    UPDATEDDATE TIMESTAMP,
    UPDATEDBY VARCHAR(255),
    FOREIGN KEY (ORDERID) REFERENCES "ORDER"(ORDERID),
    FOREIGN KEY (PRODUCTDETAILID) REFERENCES PRODUCTDETAIL(PRODUCTDETAILID)
);

CREATE TABLE PAYMENT (
    PAYMENTID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    ORDERID INTEGER NOT NULL,
    PAYMENTNO VARCHAR(255) NOT NULL UNIQUE,
    CUSTOMERNAME VARCHAR(255) NOT NULL,
    PAYMENTMETHOD VARCHAR(255) NOT NULL,
    PRICE DOUBLE NOT NULL,
    DELIVERYFEE DOUBLE NOT NULL,
    BANKTYPE VARCHAR(255),
    CREATEDDATE TIMESTAMP,
    CREATEDBY VARCHAR(255),
    UPDATEDDATE TIMESTAMP,
    UPDATEDBY VARCHAR(255),
    FOREIGN KEY (ORDERID) REFERENCES "ORDER"(ORDERID)
);