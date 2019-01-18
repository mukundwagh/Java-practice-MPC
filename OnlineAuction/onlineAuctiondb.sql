 `online_auction_db`.CREATE DATABASE "online_auction_db" /*!40100 DEFAULT CHARACTER SET latin1 */;

DROP TABLE IF EXISTS "online_auction_db"."auctions";
CREATE TABLE  "online_auction_db"."auctions" (
  "auctionId" int(11) NOT NULL AUTO_INCREMENT,
  "itemId" int(11) NOT NULL,
  "startDate" date NOT NULL,
  "endDate" date NOT NULL,
  "minimumIncrement" double NOT NULL,
  "shippingCharges" double NOT NULL,
  PRIMARY KEY ("auctionId"),
  KEY "FK_auctions_items" ("itemId"),
  CONSTRAINT "FK_auctions_items" FOREIGN KEY ("itemId") REFERENCES "items" ("itemId")
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS "online_auction_db"."bids";
CREATE TABLE  "online_auction_db"."bids" (
  "bidId" int(11) NOT NULL AUTO_INCREMENT,
  "itemId" int(11) NOT NULL,
  "bidAmount" double NOT NULL,
  PRIMARY KEY ("bidId"),
  KEY "FK_bids_items" ("itemId"),
  CONSTRAINT "FK_bids_items" FOREIGN KEY ("itemId") REFERENCES "items" ("itemId")
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS "online_auction_db"."items";
CREATE TABLE  "online_auction_db"."items" (
  "itemId" int(11) NOT NULL AUTO_INCREMENT,
  "userId" int(11) NOT NULL,
  "itemName" varchar(32) NOT NULL,
  "description" varchar(128) NOT NULL,
  "startingPrice" double NOT NULL,
  "quantity" int(11) NOT NULL,
  PRIMARY KEY ("itemId")
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;