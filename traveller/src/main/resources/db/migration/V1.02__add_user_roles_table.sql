CREATE TABLE dbo.[user_role] (
	id_user_role int IDENTITY(1,1) PRIMARY KEY,
	id_user bigint NOT NULL,
	role varchar(20) NOT NULL,
  CONSTRAINT UQ_id_user_role UNIQUE (role, id_user),
	CONSTRAINT FK_user_role_user FOREIGN KEY (id_user)
	REFERENCES dbo.[user](id_user)
)

CREATE NONCLUSTERED INDEX IX_user_role_id_user
    ON dbo.[user_role] (id_user);