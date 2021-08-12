BEGIN TRANSACTION;

DROP TABLE IF EXISTS maintenance;
DROP TABLE IF EXISTS applications;
DROP TABLE IF EXISTS payments;
DROP TABLE IF EXISTS property;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS owner;


CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,

	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('Shareeque','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Halis','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Yasin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Amy','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

CREATE TABLE address (
   address_id serial,
   address_line varchar(64) not null,
   city varchar(50) not null,
   state varchar(50) not null,
   zip int not null,

   CONSTRAINT pk_address PRIMARY KEY (address_id)

);


CREATE TABLE property (
  property_id serial,
  image_name varchar(15) ,
  address_id int not null,
  square_ft int,
  number_of_bathrooms int,
  number_of_bedrooms int,
  price decimal(12,2) not null,
  short_description varchar(2000),
  property_type varchar(50) not null,
  pets boolean,
  washer boolean,
  dryer boolean,
  dishwasher boolean,
  owner_id int not null,
  is_available boolean DEFAULT true,



  CONSTRAINT pk_property PRIMARY KEY (property_id),
  CONSTRAINT fk_property_address FOREIGN KEY (address_id) references address (address_id),
  CONSTRAINT fk_property_user FOREIGN KEY (owner_id) references users (user_id)

);

CREATE TABLE applications (
application_id serial,
first_name varchar(20),
last_name varchar(20),
email varchar(60),
phone varchar(60),
income varchar(20),
property_id int,
status varchar(60),
user_id int DEFAULT 1,
application_date DATE,

CONSTRAINT pk_applications PRIMARY KEY (application_id),
CONSTRAINT fk_applications_property FOREIGN KEY (property_id) references property (property_id),
CONSTRAINT fk_applications_users FOREIGN KEY (user_id) references users(user_id)
);

CREATE TABLE maintenance (
maintenance_id serial,
first_name varchar(20),
last_name varchar(20),
email varchar(60),
phone varchar(60),
property_id int,
status varchar(60),
user_id int DEFAULT 1,
issue varchar(1000),
request_date DATE,

CONSTRAINT pk_maintenance PRIMARY KEY (maintenance_id),
CONSTRAINT fk_maintenance_property FOREIGN KEY (property_id) references property (property_id),
CONSTRAINT fk_maintenance_users FOREIGN KEY (user_id) references users(user_id)
);

CREATE TABLE payments(
payment_id serial,
property_id int,
user_id int,
payment_date DATE,
payment_amount decimal(12,2),

CONSTRAINT pk_payments PRIMARY KEY (payment_id),
CONSTRAINT fk_payments_property FOREIGN KEY (property_id) references property (property_id),
CONSTRAINT fk_payments_users FOREIGN KEY (user_id) references users(user_id));


--House 1
INSERT INTO address (address_line, city, state, zip) VALUES ('3116 Hayden Rd', 'Dublin', 'Ohio', 43017);
INSERT INTO property (image_name, address_id, square_ft, number_of_bathrooms, number_of_bedrooms, price, short_description, property_type, owner_id) values('1000.jpg', 1, 1200, 3, 3, 1500.00,'BRAND NEW UPDATED CONDO! Be sure to stop and check out the new and improved look! Location, location, location! We are just minutes away from Rt. 315, Rt. 33 (Riverside Dr.), I-270 and The Ohio State University. Our Condo offers three master-sized bedrooms and three full baths, your new home features spacious closets, washer & dryer connection and a fully equipped kitchen. Call, or stop by, and ask our professional, on-site management team how a newly refurbished and spacious Condo can be yours today!', 'Condo', 2);

--House 2
INSERT INTO address (address_line, city, state, zip) VALUES ('233 E 1st Ave', 'Columbus', 'Ohio', 43215);
INSERT INTO property (image_name, address_id, square_ft, number_of_bathrooms, number_of_bedrooms, price, short_description, property_type, owner_id) values('1002.jpg', 2, 1500, 3, 3, 1000.00,'Located at Jeffrey Park, in the historic Italian Village neighborhood, Jeffrey Park Homes provides a unique urban living experience. This spacious home features contemporary floor plans, finishes, and amenities.', 'Single-Family Home', 2);

--House 3
INSERT INTO address (address_line, city, state, zip) VALUES ('644 Chlois Ln', 'Columbus', 'Ohio', 42215);
INSERT INTO property (image_name, address_id, square_ft, number_of_bathrooms, number_of_bedrooms, price, short_description, property_type, owner_id) values('1003.jpg', 3, 2000, 4, 2, 2000.00,'Located near Grandview, The Reach on Goodale is just minutes from the Arena District, Short North, Downtown and Italian Village. Whether you want to share cocktails or dine in style, enjoy music or catch a game, or simply relax by the River. The Reach is located next to the newly renovated White Castle headquarters, which the family-owned business has called home since 1934. White Castle is committed to the community and devoted to empowering its team members and the neighborhoods it serves to reach their full potential. This is why we seized the opportunity to transform the property into a place to live, work and play for generations to come. As the property is re-imagined, the hope is that it serves as the smile that greets you as you make your way to a thriving downtown Columbus.', 'Apartment', 4);

--House 4
INSERT INTO address (address_line, city, state, zip) VALUES ('1005 W 5th Ave,', 'Columbus', 'Ohio', 43212);
INSERT INTO property (image_name, address_id, square_ft, number_of_bathrooms, number_of_bedrooms, price, short_description, property_type, owner_id) values('1004.jpg', 4, 2500, 4, 3, 1600.00,'This home is in one of the most walkable communities in Columbus. That means you can do most of your day to day errands on foot; dozens of bars and restaurants, galleries, shops, art festivals, and green spaces mean there is always lots to do. Living here, you will be at the hub of all the best that Columbus has to offer: Lennox Town Center to the north, The Ohio State University and The James Cancer Hospital to the east, Grandview Yard to the south, and Grandview Avenue to the west. There is easy, nearby access to State Rte 315 and I 670. Come see for yourself what living on Fifth Avenue means. Stop by for a tour today.', 'Single-Family Home', 2);

--House 5
INSERT INTO address (address_line, city, state, zip) VALUES ('223 E Town St', 'Columbus', 'Ohio', 43215);
INSERT INTO property (image_name, address_id, square_ft, number_of_bathrooms, number_of_bedrooms, price, short_description, property_type, owner_id) values('1005.jpg', 5, 900, 3, 3, 980.00,'This Condo pairs flexible living with style and luxurious downtown views. With pricing that is friendly to your wallet, you will experience a modern living environment that fits your vibe and budget. Offering a spacious Condo with an industrial feel; 223 E. Town puts you at the epicenter of downtown living. Whether you choose to visit the restaurants, bars and nightlife around the corner or stay in at the clubhouse, rec room and fitness center, you will feel the city vibes because when you are downtown bound, you are finally home.', 'Condo', 2);

--House 6
INSERT INTO address (address_line, city, state, zip) VALUES ('800 Burr Ave', 'Grandview Heights', 'Ohio', 43212);
INSERT INTO property (image_name, address_id, square_ft, number_of_bathrooms, number_of_bedrooms, price, short_description, property_type, owner_id) values('1001.jpg', 6, 3000, 4, 2, 2500.00,'Along with designer selected finishes throughout including ceramic tile, granite countertops, wood plank flooring options and stainless steel appliances, you can also enjoy access to the Yard Club amenity building. The Yard Club is a 13,000 sq. ft. clubhouse featuring a fitness facility, outdoor resort-style swimming pool and spa, and a community room. In addition, our apartment is pet friendly, has convenient parking options and include access to the Residents at the Yard VIP program offering special discounts and promotions from neighborhood bars, restaurant and entertainment venues in both Grandview Yard and the Arena District. We have been awarded a variety of accolades including CBUS Top Picks, ColumBEST and consecutive CEL industry awards for excellent customer service and is located within booming Grandview Heights.', 'Apartment', 2);

--House 7
INSERT INTO address (address_line, city, state, zip) VALUES ('5188 Warner Rd', 'Westerville', 'Ohio', '43215');
INSERT INTO property (image_name, address_id, square_ft, number_of_bathrooms, number_of_bedrooms, price, short_description, property_type, owner_id) values('1001.jpg', 7, 1200, 4, 2, 950.00,'Welcome home to a place where warm earth tones accented with richly grained oak beamed ceilings and custom six inch wood plank flooring complement the views of the pool deck seen from the oversized arch windows upon entrance to the Clubhouse. Hints of the aesthetic flow into the coordinated design of your home. Your kitchen boasts stainless steel appliances with Luna-granite and features shaker style Maybrook gray cabinetry and silver bullet gray adhere on the pearly white backsplash. Matte blacks, alabaster glass and brushed steel lighting combine to illuminate your living spaces. Every color, texture, and style selection was made with you in mind.', 'Single-Family Home', 4);

--House 8
INSERT INTO address (address_line, city, state, zip) VALUES ('272 S Front St', 'Columbus', 'Ohio', 43200);
INSERT INTO property (image_name, address_id, square_ft, number_of_bathrooms, number_of_bedrooms, price, short_description, property_type, owner_id) values('1001.jpg', 8, 1000, 2, 2, 1200.00,'The Julian is a historic, re-imagined 90-unit apartment community in Downtown Columbus. The Julian features seven stories of loft-style apartments with breathtaking views of the city and amenities to fit your modern lifestyle. With our stunning views on the rooftop patio, 24 hour fitness center, community garden, walkable community, and unlimited access to entertainment and dining, be prepared to fall in love with The Julian. What makes The Julian special is our unique location. Perfect for festivals such as the Ribs Fest, views of the Red, White and Boom Festival, walking distance to various Moonlight Markets and Farmers Markets. Not to mention, rich in history and unbeatable views of the Columbus skyline!We cant wait to welcome you home to The Julian!', 'Apartment', 2);

--Application 1
INSERT INTO applications(first_name,last_name, email, phone, income, property_id, status, user_id, application_date) VALUES('Yasin', 'kusan','halis@','111','10000',1,'approved',1, '8/12/2021');
INSERT INTO applications(first_name,last_name, email, phone, income, property_id, status, user_id, application_date) VALUES('Halis', 'Yigin','halis@','111','10000',2,'approved',3, '8/10/2021');


-- UPDATING SEQUENCES SO THERE ARE NO CLASHES WHEN APP RUNS WITH EXISTING KEYS...
-- ALTER SEQUENCE address_address_id_seq RESTART WITH 100;
-- ALTER SEQUENCE property_property_id_seq RESTART WITH 100;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO final_capstone_appuser;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO final_capstone_appuser; 
GRANT USAGE ON SCHEMA public TO final_capstone_appuser;


COMMIT TRANSACTION;
