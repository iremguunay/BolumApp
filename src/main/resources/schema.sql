create table bolum (
    no bigint generated by default as identity,
    ad varchar(255),
    sehir_no bigint not null,
    primary key (no)
);
