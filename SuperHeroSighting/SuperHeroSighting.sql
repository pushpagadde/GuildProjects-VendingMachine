drop database if exists SuperHeroSighting;
create database superHerosighting;

CREATE TABLE SuperHeroSighting.ZipCodeInfo
(ZipCode VARCHAR(5) NOT NULL,
City VARCHAR(20) NOT NULL,
State VARCHAR(2) NOT NULL,
PRIMARY KEY (ZipCode)
);

CREATE TABLE  superHerosighting.Location (
 `LocationID` int(5) NOT NULL AUTO_INCREMENT,
 `Description` varchar(20) NOT NULL,
 `Address` varchar(20) NOT NULL,
 `Latitude` varchar(8) NOT NULL,
 `Longitude` varchar(8) NOT NULL,
 `ZipCode` varchar(5) NOT NULL,
 PRIMARY KEY (`LocationID`),
 FOREIGN KEY (ZipCode) REFERENCES ZipCodeInfo(ZipCode)
);

CREATE TABLE superHerosighting.SuperHero (
HeroID int NOT NULL auto_increment,
HeroName varchar(20) NOT NULL,
HeroPower varchar(20) NOT NULL,
PRIMARY KEY (HeroID)
);

CREATE TABLE superHerosighting.Members (
MemberID int NOT NULL auto_increment,
FirstName varchar(20),
LastName varchar(20),
Address varchar(20),
ZipCode varchar(5),
primary key (MemberID),
foreign key (ZipCode) references ZipCodeInfo(ZipCode)
);

CREATE TABLE superHerosighting.Organizations (
OrganizationID int NOT NULL auto_increment,
OrganizationName varchar(20) NOT NULL,
Address varchar(20),
ZipCode varchar(5),
Phone varchar(10),
primary key (organizationID),
foreign key (ZipCode) references ZipCodeInfo(ZipCode)
);

CREATE TABLE  superHerosighting.Hero_Organization (
HeroID int NOT NULL,
OrganizationID int NOT NULL,
foreign key (HeroID) references SuperHero(HeroID),
foreign key (OrganizationID) references Organizations(OrganizationID)
);

CREATE TABLE superHerosighting.OrganizationMember (
OrganizationID INT NOT NULL auto_increment,
MemberID int NOT NULL,
foreign key (OrganizationID) references Organizations(OrganizationID),
foreign key (MemberID) references Members(MemberID)
);


CREATE TABLE superHerosighting.Sightings (
HeroId int NOT NULL auto_increment,
LocationID int NOT NULL,
DateOfSighting DateTime NOT NULL,
FOREIGN KEY (HeroID) REFERENCES SuperHero(HeroID),
FOREIGN KEY (LocationID) REFERENCES Location(LocationID) 
);

