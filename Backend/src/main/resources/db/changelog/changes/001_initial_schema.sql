create table if not exists presuda (
    id  INT AUTO_INCREMENT,
    sudija varchar(255),
    kazna INT,
    hladno_oruzje boolean,

    primary key (id)
);