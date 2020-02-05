CREATE SCHEMA IF NOT EXISTS users;
INSERT INTO user (user_nickname,user_name,user_lastname,modified_at) VALUES ('bvalero','brayan','valero',CAST(NOW() AS DATE));
INSERT INTO user (user_nickname,user_name,user_lastname,modified_at) VALUES ('amonroy','andres','monroy',CAST(NOW() AS DATE));
INSERT INTO user (user_nickname,user_name,user_lastname,modified_at) VALUES ('root','administrador','admin',CAST(NOW() AS DATE));