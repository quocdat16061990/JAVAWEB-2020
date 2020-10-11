use javaweb11;

CREATE TABLE user (
    id bigint NOT NULL AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    fullname varchar(255) NULL,
    phone varchar(10) NULL,
    email varchar(50) NULL,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE role (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(20) NULL,
    code varchar(20) NULL,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_role (
    id bigint NOT NULL AUTO_INCREMENT,
    userid bigint NOT NULL,
    roleid bigint NOT NULL,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (userid) REFERENCES user(id),
    FOREIGN KEY (roleid) REFERENCES role(id)
);

CREATE TABLE customer (
    id bigint NOT NULL AUTO_INCREMENT,
    fullname varchar(255) NULL,
    phone varchar(10) NOT NULL,
    email varchar(50) NOT NULL,
    demand TEXT,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE transactiontype (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    code varchar(100),
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE transaction (
    id bigint NOT NULL AUTO_INCREMENT,
    content TEXT,
    transactiontypeid bigint NOT NULL,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (transactiontypeid) REFERENCES transactiontype(id)
);

CREATE TABLE customerassignment (
    id bigint NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id),
    customerid bigint NOT NULL,
    staffid bigint NOT NULL,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL,
    FOREIGN KEY (customerid) REFERENCES customer(id),
    FOREIGN KEY (staffid) REFERENCES user(id)
);

CREATE TABLE district (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(20) NOT NULL,
    code varchar(20) NOT NULL,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE building (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(30) NULL,
    floorarea int NULL,
    street varchar(255) NULL,
    ward varchar(255) NOT NULL,
    numberofbasement int NULL,
    direction varchar(20) NULL,
    rate varchar(20) NULL,
    leaseprice int NULL,
    leasepricedescription TEXT NULL,
    carcost varchar(30) NULL,
    motorcost varchar(30) NULL,
    electricitycost varchar(30) NULL,
    deposit varchar(30) NULL,
    payment varchar(20) NULL,
    leaseperiod varchar (10) NULL,
    decoration varchar(10) NULL,
    nameofmanager varchar(50) NULL,
    managerphone int (10) NULL,
    brokerfees varchar(100) NULL,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL,
    districtid bigint NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (districtid) REFERENCES district(id)
);

CREATE TABLE buildingassignment (
    id bigint NOT NULL AUTO_INCREMENT,
    buildingid bigint NOT NULL,
    staffid bigint NOT NULL,
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (staffid) REFERENCES user(id),
    FOREIGN KEY (buildingid) REFERENCES building(id)
);

CREATE TABLE buildingtype (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(50),
    code varchar(50),
    createddate datetime NULL,
    modifieddate datetime NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE buildingchosentype (
    id bigint NOT NULL AUTO_INCREMENT,
    buildingid bigint NOT NULL,
    buildingtypeid bigint NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (buildingid) REFERENCES building(id),
    FOREIGN KEY (buildingtypeid) REFERENCES buildingtype(id)
);

CREATE TABLE leasearea (
    id bigint NOT NULL AUTO_INCREMENT,
	value int NOT NULL,
    buildingid bigint NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (buildingid) REFERENCES building(id)
);