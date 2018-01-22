DROP DATABASE IF EXISTS HotelReservationSystem;
CREATE DATABASE HotelReservationSystem;

CREATE TABLE HotelReservationSystem.ZipCodeInfo
(ZipCode VARCHAR(5) NOT NULL,
City VARCHAR(15) NOT NULL,
State VARCHAR(2) NOT NULL,
PRIMARY KEY (ZipCode)
);

CREATE TABLE HotelReservationSystem.Promotion
(PromotionCode VARCHAR(5) NOT NULL,
PromotionName VARCHAR(15) NOT NULL,
Description VARCHAR(20) NOT NULL,
Rate decimal NOT NULL,
PRIMARY KEY (PromotionCode)
);

CREATE TABLE HotelReservationSystem.Amneties
(AmnetyID varchar(5) NOT NULL auto_increment,
AmnetyName varchar(15) NOT NULL,
AmnetyDescription varchar(30) NOT NULL,
AmnetyRate decimal NOT NULL,
primary key(AmnetyID)
);

CREATE TABLE HotelReservationSystem.CustomerInformationTable
(CustomerID int AUTO_INCREMENT NOT NULL,
CustomerFirstName varchar(15) NOT NULL,
CustomerLastName varchar(15) NOT NULL,
CustomerAddress1 varchar(30) NOT NULL,
CustomerAddress2 varchar(30),
CustomerCity varchar(15) NOT NULL,
CustomerState varchar(2) NOT NULL,
CustomerZipCode varchar(5) NOT NULL,
CustomerPhone varchar(10) NOT NULL,
CustomerEmail varchar(30) NOT NULL,
primary key(CustomerID),
Foreign key (CustomerZipCode) REFERENCES ZipCodeInfo(ZipCode)
);


CREATE TABLE HotelReservationSystem.RoomType
(RoomTypeCode varchar(5) NOT NULL, 
Description varchar(30) NOT NULL,
primary key(RoomTypeCode)
);

CREATE TABLE HotelReservationSystem.RoomInformation
(RoomID varchar(5) NOT NULL, -- userassigned for each floor
RoomDescription varchar(100) NOT NULL,
Capacity int NOT NULL,
RoomType varchar(5) NOT NULL,
primary key(RoomID),
Foreign key (RoomType) REFERENCES RoomType(RoomTypeCode)
);

CREATE TABLE HotelReservationSystem.ReservationInfo
(ReservationID int NOT NULL auto_increment, 
CustomerID int NOT NULL,
DateFrom DateTime NOT NULL,
DateTO DateTime NOT NULL,
BookedDate DateTime ,
Confirmation varchar(30) , -- randomly generated
PaymentStatus Boolean default false,
primary key(ReservationID),
Foreign key (CustomerID) REFERENCES CustomerInformationTable(CustomerID)
);

CREATE TABLE HotelReservationSystem.RoomBookings
(RoomID varchar(5) NOT NULL, 
ReservationID int NOT NULL,
Notes varchar(100) NOT NULL,
BusyStatus Boolean NOT NULL,
foreign key(RoomID) REFERENCES  RoomInformation(RoomID),
foreign key(ReservationID) REFERENCES  ReservationInfo(ReservationID)
);

CREATE TABLE HotelReservationSystem.TaxInformation
(
LocalTax decimal,
StateTax decimal,
OtherTax decimal
);

CREATE TABLE HotelReservationSystem.GuestInfo
(GuestID INT NOT NULL AUTO_INCREMENT,
CustomerID INT NOT NULL,
GuestName VARCHAR(30) NOT NULL,
GuestAge int NOT NULL,
PRIMARY KEY (GuestID),
FOREIGN KEY(CustomerID) REFERENCES CustomerInformationTable(CustomerID)
);


CREATE TABLE HotelReservationSystem.Billing
(BillingID int AUTO_INCREMENT,
ReservationID int,
AmentiesCharge decimal,
AddonsTotal decimal,
Promotion decimal,
FlatDiscount decimal,
TotalTax decimal,
TotalAmountDue decimal,
primary key(BillingID),
Foreign key (ReservationID) REFERENCES ReservationInfo(ReservationID)
);
CREATE TABLE HotelReservationSystem.BillingPromotions
(BillingID int,
PromotionCode varchar(5),
FOREIGN KEY(BillingID) REFERENCES Billing(BillingID),
FOREIGN KEY(PromotionCode) REFERENCES Promotion(PromotionCode)
);

CREATE TABLE HotelReservationSystem.RoomAmneties
(RoomID varchar(5),
AmnetyID varchar(5),
FOREIGN KEY(RoomID) REFERENCES RoomInformation(RoomID),
FOREIGN KEY(AmnetyID) REFERENCES Amneties(AmnetyID)
);
