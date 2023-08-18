INSERT INTO CUSTOMER (
		USERNAME, 
		"NAME", 
		PASSWORD, 
		STATUS, 
		PHONE, 
		MAIL, 
		DELIVERYADDRESS,
		CREATEDDATE, 
		CREATEDBY)
	VALUES (
		'nike',
		'nike customer',
		'nike2022',
		'Activate',
		'012 345 6789',
		'nikecustomer@gmail.com',
		'One street, Two sky, Three boy.13400.Butterworth.Pulau Pinang',
		'2022-03-07 00:12:20',
		'System');

INSERT INTO CUSTOMER (
		USERNAME, 
		"NAME", 
		PASSWORD, 
		STATUS, 
		PHONE, 
		MAIL, 
		DELIVERYADDRESS,
		CREATEDDATE, 
		CREATEDBY)
	VALUES (
		'Moonbyul2da',
		'Moonbyuli',
		'5212222moon',
		'Activate',
		'0134567888',
		'moonbyul2da@gmail.com',
		'One street, Two sky, Three boy.13400.Butterworth.Pulau Pinang', 
		'2022-03-07 00:12:20',
		'System');

INSERT INTO USERGROUP (
		USERGROUPNAME,
		CREATEDDATE, 
		CREATEDBY)
	VALUES (
		'Admin',
		'2022-03-07 00:12:20',
		'System');

INSERT INTO USERGROUP (
		USERGROUPNAME,
		CREATEDDATE, 
		CREATEDBY)
	VALUES (
		'Staff',
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO PRODUCT (
		PRODUCTNO,
		PRODUCTNAME,
		PRODUCTDESC,
		STATUS,
		CATEGORY,
		ISFEATURED,
		PRICE,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		'SKU/202203/000001',
		'Nike Air Force 1 07 Essential',
		'The radiance lives on in the Nike Air Force 1 07, the b-ball original that puts a fresh spin on what you know best: stitched overlays, bold colours and the perfect amount of hoops style to make heads turn. The paisley print Swoosh and heel are cheerful, cool and add a timeless elegance.',
		'Activate',
		'Men',
		1,
		415,
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO PRODUCT (
		PRODUCTNO,
		PRODUCTNAME,
		PRODUCTDESC,
		STATUS,
		CATEGORY,
		ISFEATURED,
		PRICE,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		'SKU/202203/000002',
		'Humble Bee',
		'Very beautiful, very powerful',
		'Activate',
		'Kids',
		1,
		299,
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO COURIER (
		COURIERNAME,
		COURIERPRICE,
		STATUS,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		'J&T Express',
		5,
		'Activate',
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO COURIER (
		COURIERNAME,
		COURIERPRICE,
		STATUS,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		'Poslaju',
		6,
		'Activate',
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO "USER" (
		USERGROUPID, 
		USERNAME, 
		"NAME", 
		PASSWORD, 
		STATUS, 
		PHONE, 
		MAIL, 
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		1,
		'ADMIN',
		'LIM ADMIN',
		'admin123',
		'Activate',
		'019 8765432',
		'admin@nike.com',
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO "USER" (
		USERGROUPID, 
		USERNAME, 
		"NAME", 
		PASSWORD, 
		STATUS, 
		PHONE, 
		MAIL, 
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		2,
		'Staff',
		'Lin Staff',
		'staff123',
		'Activate',
		'018 8765432',
		'stafflin@nike.com',
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO PRODUCTDETAIL (
		PRODUCTID, 
		"SIZE", 
		COLOR, 
		MINSTOCKQTY, 
		PHYSICALQTY, 
		SALESOUTQTY,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		1, 
		'UK 3.5',
		'White',
		10,
		9,
		1,
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO PRODUCTDETAIL (
		PRODUCTID, 
		"SIZE", 
		COLOR, 
		MINSTOCKQTY, 
		PHYSICALQTY, 
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		1, 
		'UK 4.5',
		'White',
		10,
		100,
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO PRODUCTDETAIL (
		PRODUCTID, 
		"SIZE", 
		COLOR, 
		MINSTOCKQTY, 
		PHYSICALQTY, 
		SALESOUTQTY,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		1, 
		'UK 4.5',
		'Green',
		10,
		100,
		2,
		'2022-03-07 00:12:20',
		'System');

INSERT INTO PRODUCTDETAIL (
		PRODUCTID, 
		"SIZE", 
		COLOR, 
		MINSTOCKQTY, 
		PHYSICALQTY, 
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		2, 
		'36',
		'White',
		10,
		100,
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO PRODUCTDETAIL (
		PRODUCTID, 
		"SIZE", 
		COLOR, 
		MINSTOCKQTY, 
		PHYSICALQTY, 
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		2, 
		'37',
		'Yellow',
		10,
		100,
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO PRODUCTDETAIL (
		PRODUCTID, 
		"SIZE", 
		COLOR, 
		MINSTOCKQTY, 
		PHYSICALQTY, 
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		2, 
		'38',
		'Red',
		10,
		100,
		'2022-03-07 00:12:20',
		'System');

INSERT INTO CART (
		CUSTOMERID,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		1,
		'2022-03-07 00:12:20',
		'System');

INSERT INTO CART (
		CUSTOMERID,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		2,
		'2022-03-07 00:12:20',
		'System');

INSERT INTO CARTDETAIL (
		CARTID, 
		PRODUCTDETAILID,
		QUANTITY,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		1,
		1,
		2,
		'2022-03-07 00:12:20', 
		'System');
		
INSERT INTO CARTDETAIL (
		CARTID, 
		PRODUCTDETAILID,
		QUANTITY,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		1,
		2,
		2,
		'2022-03-07 00:12:20', 
		'System');
		
INSERT INTO CARTDETAIL (
		CARTID, 
		PRODUCTDETAILID,
		QUANTITY,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		1,
		3,
		2,
		'2022-03-07 00:12:20', 
		'System');
		
INSERT INTO CARTDETAIL (
		CARTID, 
		PRODUCTDETAILID,
		QUANTITY,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		1,
		5,
		2,
		'2022-03-07 00:12:20', 
		'System');

INSERT INTO "ORDER" (
		CUSTOMERID, 
		COURIERID, 
		ORDERNO, 
		RECEIVERNAME,
		STATUS, 
		PRICE, 
		DELIVERYADDRESS, 
		DELIVERYFEE, 
		CREATEDDATE, 
		CREATEDBY) 
	VALUES (
		1, 
		1, 
		'SO/202203/000001', 
		'Nike receiver', 
		'Pending', 
		1660, 
		'One street, Two sky, Three boy.Butterworth.13400.Pulau Pinang', 
		5.0,
		'2022-03-07 03:17:04.189', 
		'System');

INSERT INTO ORDERDETAIL (
		ORDERID, 
		PRODUCTDETAILID,
		PRODUCTID,
		PRODUCTNO,
		PRODUCTNAME,
		PRICE,
		QUANTITY,
		"SIZE", 
		COLOR, 
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		1, 
		1,
		1,
		'SKU/202203/000001',
		'Nike Air Force 1 07 Essential',
		415,
		2,
		'UK 3.5',
		'White',
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO ORDERDETAIL (
		ORDERID, 		
		PRODUCTDETAILID,
		PRODUCTID,
		PRODUCTNO,
		PRODUCTNAME,
		PRICE,
		QUANTITY,
		"SIZE", 
		COLOR, 
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		1, 
		2,
		1,
		'SKU/202203/000001',
		'Nike Air Force 1 07 Essential',
		415,
		1,
		'UK 4.5',
		'White',
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO ORDERDETAIL (
		ORDERID, 
		PRODUCTDETAILID,
		PRODUCTID, 
		PRODUCTNO,
		PRODUCTNAME,
		PRICE,
		QUANTITY,
		"SIZE", 
		COLOR, 
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		1, 
		3,
		1,
		'SKU/202203/000001',
		'Nike Air Force 1 07 Essential',
		415,
		1,
		'UK 4.5',
		'Green',
		'2022-03-07 00:12:20',
		'System');	
		
---------------------------------------------
		
INSERT INTO "ORDER" (
		CUSTOMERID, 
		COURIERID, 
		ORDERNO, 
		RECEIVERNAME,
		STATUS, 
		PRICE, 
		DELIVERYADDRESS, 
		DELIVERYFEE, 
		CREATEDDATE, 
		CREATEDBY, 
		UPDATEDDATE, 
		UPDATEDBY) 
	VALUES (
		1, 
		1, 
		'SO/202203/000002', 
		'Nike receiver', 
		'Paid', 
		835, 
		'One street, Two sky, Three boy.Butterworth.13400.Pulau Pinang', 
		5.0,
		'2022-03-09 03:17:04.189', 
		'System',
		'2022-03-10 00:12:20',
		'System');

INSERT INTO ORDERDETAIL (
		ORDERID, 
		PRODUCTDETAILID,
		PRODUCTID,
		PRODUCTNO,
		PRODUCTNAME,
		PRICE,
		QUANTITY,
		"SIZE", 
		COLOR, 
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		2, 
		1,
		1,
		'SKU/202203/000001',
		'Nike Air Force 1 07 Essential',
		415,
		2,
		'UK 3.5',
		'White',
		'2022-03-09 00:12:20',
		'System');
		
INSERT INTO PAYMENT (
		ORDERID,
		PAYMENTNO,
		CUSTOMERNAME,
		PAYMENTMETHOD,
		PRICE,
		DELIVERYFEE,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		2,
		'INV/202203/000001',
		'nike',
		'TNG E-wallet',
		835,
		5,
		'2022-03-10 00:12:20',
		'System');
		
---------------------------------------------
		
INSERT INTO "ORDER" (
		CUSTOMERID, 
		COURIERID, 
		ORDERNO, 
		RECEIVERNAME,
		STATUS, 
		PRICE, 
		DELIVERYADDRESS, 
		DELIVERYFEE, 
		CREATEDDATE, 
		CREATEDBY, 
		UPDATEDDATE, 
		UPDATEDBY) 
	VALUES (
		1, 
		1, 
		'SO/202203/000003', 
		'Nike receiver', 
		'Packaging', 
		835, 
		'One street, Two sky, Three boy.Butterworth.13400.Pulau Pinang', 
		5.0,
		'2022-03-11 03:17:04.189', 
		'System',
		'2022-03-13 00:12:20',
		'System');

INSERT INTO ORDERDETAIL (
		ORDERID, 
		PRODUCTDETAILID,
		PRODUCTID,
		PRODUCTNO,
		PRODUCTNAME,
		PRICE,
		QUANTITY,
		"SIZE", 
		COLOR, 
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		3, 
		1,
		1,
		'SKU/202203/000001',
		'Nike Air Force 1 07 Essential',
		415,
		2,
		'UK 3.5',
		'White',
		'2022-03-11 00:12:20',
		'System');
		
INSERT INTO PAYMENT (
		ORDERID,
		PAYMENTNO,
		CUSTOMERNAME,
		PAYMENTMETHOD,
		PRICE,
		DELIVERYFEE,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		3,
		'INV/202203/000002',
		'nike',
		'TNG E-wallet',
		835,
		5,
		'2022-03-12 00:12:20',
		'System');
		
---------------------------------------------
		
INSERT INTO "ORDER" (
		CUSTOMERID, 
		COURIERID, 
		ORDERNO, 
		RECEIVERNAME,
		STATUS, 
		PRICE, 
		DELIVERYADDRESS, 
		TRACKINGNO, 
		DELIVERYFEE, 
		CREATEDDATE, 
		CREATEDBY, 
		UPDATEDDATE, 
		UPDATEDBY) 
	VALUES (
		1, 
		1, 
		'SO/202203/000004', 
		'Nike receiver', 
		'Shipping', 
		835, 
		'One street, Two sky, Three boy.Butterworth.13400.Pulau Pinang', 
		'CF1234CY34',
		5.0,
		'2022-03-12 03:17:04.189', 
		'System',
		'2022-03-13 05:12:20',
		'System');

INSERT INTO ORDERDETAIL (
		ORDERID, 
		PRODUCTDETAILID,
		PRODUCTID,
		PRODUCTNO,
		PRODUCTNAME,
		PRICE,
		QUANTITY,
		"SIZE", 
		COLOR, 
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		4, 
		1,
		1,
		'SKU/202203/000001',
		'Nike Air Force 1 07 Essential',
		415,
		2,
		'UK 3.5',
		'White',
		'2022-03-12 00:12:20',
		'System');
		
INSERT INTO PAYMENT (
		ORDERID,
		PAYMENTNO,
		CUSTOMERNAME,
		PAYMENTMETHOD,
		BANKTYPE,
		PRICE,
		DELIVERYFEE,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		4,
		'INV/202203/000003',
		'nike',
		'Online Banking',
		'Public Bank',
		835,
		5,
		'2022-03-13 00:12:20',
		'System');
		
---------------------------------------------
		
INSERT INTO "ORDER" (
		CUSTOMERID, 
		COURIERID, 
		ORDERNO, 
		RECEIVERNAME,
		STATUS, 
		PRICE, 
		DELIVERYADDRESS, 
		TRACKINGNO, 
		DELIVERYFEE, 
		CREATEDDATE, 
		CREATEDBY, 
		UPDATEDDATE, 
		UPDATEDBY) 
	VALUES (
		1, 
		1, 
		'SO/202203/000005', 
		'Nike receiver', 
		'Delivered', 
		835, 
		'One street, Two sky, Three boy.Butterworth.13400.Pulau Pinang', 
		'SRTY234VUK3CXX',
		5.0,
		'2022-03-10 03:17:04.189', 
		'System',
		'2022-03-14 00:12:20',
		'System');

INSERT INTO ORDERDETAIL (
		ORDERID, 
		PRODUCTDETAILID,
		PRODUCTID,
		PRODUCTNO,
		PRODUCTNAME,
		PRICE,
		QUANTITY,
		"SIZE", 
		COLOR, 
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		5, 
		1,
		1,
		'SKU/202203/000001',
		'Nike Air Force 1 07 Essential',
		415,
		2,
		'UK 3.5',
		'White',
		'2022-03-11 00:12:20',
		'System');
		
INSERT INTO PAYMENT (
		ORDERID,
		PAYMENTNO,
		CUSTOMERNAME,
		PAYMENTMETHOD,
		PRICE,
		DELIVERYFEE,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		5,
		'INV/202203/000004',
		'nike',
		'Master Card',
		835,
		5,
		'2022-03-11 00:12:20',
		'System');
		
---------------------------------------------
		
INSERT INTO "ORDER" (
		CUSTOMERID, 
		COURIERID, 
		ORDERNO, 
		RECEIVERNAME,
		STATUS, 
		PRICE, 
		DELIVERYADDRESS, 
		TRACKINGNO, 
		DELIVERYFEE, 
		CREATEDDATE, 
		CREATEDBY, 
		UPDATEDDATE, 
		UPDATEDBY) 
	VALUES (
		1, 
		1, 
		'SO/202203/000006', 
		'Nike receiver', 
		'Completed', 
		835, 
		'One street, Two sky, Three boy.Butterworth.13400.Pulau Pinang', 
		'NJ1234BUIO',
		5.0,
		'2022-03-14 03:17:04.189', 
		'System',
		'2022-03-27 00:12:20',
		'System');

INSERT INTO ORDERDETAIL (
		ORDERID, 
		PRODUCTDETAILID,
		PRODUCTID,
		PRODUCTNO,
		PRODUCTNAME,
		PRICE,
		QUANTITY,
		"SIZE", 
		COLOR, 
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		6, 
		1,
		1,
		'SKU/202203/000001',
		'Nike Air Force 1 07 Essential',
		415,
		2,
		'UK 3.5',
		'White',
		'2022-03-13 00:12:20',
		'System');
		
INSERT INTO PAYMENT (
		ORDERID,
		PAYMENTNO,
		CUSTOMERNAME,
		PAYMENTMETHOD,
		PRICE,
		DELIVERYFEE,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		6,
		'INV/202203/000005',
		'nike',
		'Master Card',
		835,
		5,
		'2022-03-15 00:12:20',
		'System');
		
---------------------------------
		
INSERT INTO "ORDER" (
		CUSTOMERID, 
		COURIERID, 
		ORDERNO, 
		RECEIVERNAME,
		STATUS, 
		PRICE, 
		DELIVERYADDRESS, 
		DELIVERYFEE, 
		CREATEDDATE, 
		CREATEDBY, 
		UPDATEDDATE, 
		UPDATEDBY) 
	VALUES (
		1, 
		1, 
		'SO/202203/000007', 
		'Nike receiver', 
		'Cancelled', 
		835, 
		'One street, Two sky, Three boy.Butterworth.13400.Pulau Pinang', 
		5.0,
		'2022-03-20 03:17:04.189', 
		'System',
		'2022-03-24 00:12:20',
		'System');

INSERT INTO ORDERDETAIL (
		ORDERID, 
		PRODUCTDETAILID,
		PRODUCTID,
		PRODUCTNO,
		PRODUCTNAME,
		PRICE,
		QUANTITY,
		"SIZE", 
		COLOR, 
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		7, 
		1,
		1,
		'SKU/202203/000001',
		'Nike Air Force 1 07 Essential',
		415,
		2,
		'UK 3.5',
		'White',
		'2022-03-20 03:17:04.189',
		'System');
		
INSERT INTO PRODUCT (
		PRODUCTNO,
		PRODUCTNAME,
		PRODUCTDESC,
		STATUS,
		CATEGORY,
		ISFEATURED,
		PRICE,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		'SKU/202203/000003',
		'PG E-XY',
		'Niceeya',
		'Activate',
		'Kids',
		1,
		299,
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO PRODUCTDETAIL (
		PRODUCTID, 
		"SIZE", 
		COLOR, 
		MINSTOCKQTY, 
		PHYSICALQTY, 
		SALESOUTQTY,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		3, 
		'38',
		'White',
		10,
		100,
		120,
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO PRODUCT (
		PRODUCTNO,
		PRODUCTNAME,
		PRODUCTDESC,
		STATUS,
		CATEGORY,
		ISFEATURED,
		PRICE,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		'SKU/202203/000004',
		'Zoom-Beautiful',
		'A part of you',
		'Activate',
		'Unisex',
		1,
		299,
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO PRODUCTDETAIL (
		PRODUCTID, 
		"SIZE", 
		COLOR, 
		MINSTOCKQTY, 
		PHYSICALQTY, 
		SALESOUTQTY,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		4, 
		'38',
		'White',
		10,
		100,
		110,
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO PRODUCT (
		PRODUCTNO,
		PRODUCTNAME,
		PRODUCTDESC,
		STATUS,
		CATEGORY,
		ISFEATURED,
		PRICE,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		'SKU/202203/000005',
		'Manta',
		'Lia ya',
		'Activate',
		'Women',
		0,
		299,
		'2022-03-07 00:12:20',
		'System');
		
INSERT INTO PRODUCTDETAIL (
		PRODUCTID, 
		"SIZE", 
		COLOR, 
		MINSTOCKQTY, 
		PHYSICALQTY, 
		SALESOUTQTY,
		CREATEDDATE,
		CREATEDBY)
	VALUES (
		5, 
		'38',
		'White',
		10,
		100,
		110,
		'2022-03-07 00:12:20',
		'System');