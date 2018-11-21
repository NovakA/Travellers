CREATE TABLE dbo.[user] (
	id_user bigint IDENTITY(1,1) PRIMARY KEY,
	user_name varchar(50) NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
  password varchar(500) NOT NULL,
  salt varchar(1000) NOT NULL,
  email varchar(100) NOT NULL,
  is_active bit NOT NULL,
	birth_date date NOT NULL,
	id_cat_sex int NOT NULL,
	CONSTRAINT FK_user_cat_sex FOREIGN KEY (id_cat_sex)
	REFERENCES dbo.[cat_sex](id_cat_sex)
)