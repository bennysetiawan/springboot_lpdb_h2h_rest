CREATE TABLE authority (
	id varchar(55),
	authority varchar(25),
	primary key (id),
   KEY `K_authority_id` (`id`),
   KEY `K_authority_iauthority` (`authority`),
   UNIQUE KEY `UK_authority_id` (`id`),
   UNIQUE KEY `UK_authority_authority` (`authority`)
);

CREATE TABLE users (
   id varchar(55),
	username varchar(25) not null,
	code varchar(25),
	enabled boolean not null,
	password varchar(255) not null,
	primary key (id),
   KEY `K_users_id` (`id`),
   KEY `K_users_username` (`username`),
   KEY `K_users_code` (`code`),
   UNIQUE KEY `UK_users_id` (`id`),
   UNIQUE KEY `UK_users_username` (`username`),
   UNIQUE KEY `UK_users_code` (`code`)
);

CREATE TABLE users_authorities (
	users_id varchar(55) not null,
	authorities_id varchar(55) not null,
   CONSTRAINT `FK_users_authorities_users_id` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`),
   CONSTRAINT `FK_users_authorities_authorities_id` FOREIGN KEY (`authorities_id`) REFERENCES `authority` (`id`)
);

create table tb_pdc (
   id varchar(55) not null,
   id_mitra int(15) DEFAULT NULL,
   nama_mitra varchar(255),
   id_proposal bigint(20) NOT NULL,
   id_prop_pencairan_ke integer,
   pdc_acc_rekening_cust integer,
   pdc_ammount_cust decimal(15,0),
   pdc_bank_code_cust integer,
   pdc_bank_name_cust varchar(255),
   pdc_contract_no_cust integer,
   pdc_date_cust date,
   pdc_due_date_cust date,
   pdc_installment_cust integer,
   pdc_no_cust integer,
   pdc_note_cust varchar(255),
   pdc_input_date date,
   primary key (id)
);

create table tb_customer (
   pdc_id varchar(55) not null,
   `id_customer` varchar(55) not null,
   `id_koperasi` varchar(55) not null,
   `cust_nik` varchar(225) DEFAULT NULL,
   `cust_nama` varchar(225) DEFAULT NULL,
   `cust_age` int(3) DEFAULT NULL,
   `cust_jenis_kelamin` tinyint(1) DEFAULT NULL,
   `cust_nama_usaha` varchar(225) DEFAULT NULL,
   `cust_sektor_usaha` varchar(200) DEFAULT NULL,
   `cust_bidang_usaha` varchar(200) DEFAULT NULL,
   `cus_sektor_usaha_detil` mediumtext,
   `cust_omset` decimal(15,0) DEFAULT NULL,
   `cust_asset` decimal(15,0) DEFAULT NULL,
   `cust_alamat_usaha` varchar(225) DEFAULT NULL,
   `cust_penanggung_jawab` varchar(50) DEFAULT NULL,
   `cust_jum_tenaga_kerja` int(10) DEFAULT NULL,
   `cust_no_telp` varchar(45) DEFAULT NULL,
   `cust_alamat` varchar(225) DEFAULT NULL,
   `cust_prov` varchar(200) DEFAULT NULL,
   `cust_kab` varchar(200) DEFAULT NULL,
   `cust_kec` varchar(200) DEFAULT NULL,
   `cust_pemanfaatan` tinyint(3) DEFAULT NULL,
   `cust_plafon_pengajuan` decimal(15,0) DEFAULT NULL,
   `cust_akad_jenis` int(3) DEFAULT NULL,
   `cust_akad_tgl` date DEFAULT NULL,
   `cust_realisasi_tgl` date DEFAULT NULL,
   `cust_realisasi_nilai` decimal(15,0) DEFAULT NULL,
   `cust_sisa_dana` decimal(15,0) DEFAULT NULL,
   `cust_jangka_waktu` int(3) DEFAULT NULL,
   `cust_satuan_waktu` int(2) DEFAULT NULL,
   `cust_pola_bunga` tinyint(2) DEFAULT NULL,
   `cust_tingkat_bunga` varchar(50) DEFAULT NULL,
   `cust_tgl_jatuh_tempo` date DEFAULT NULL,
   `rev_no` int(11) DEFAULT NULL,
   `status_cust` int(3) DEFAULT NULL,
   primary key (pdc_id),
   constraint pdc_customer_foreign_key foreign key (pdc_id) references tb_pdc (id)
);

create table tb_pdc_detail (
   id_pdc_detail varchar(55) not null,
   id_pdc varchar(55),
   cust_angs_ke integer,
   cust_bayar_basil decimal(15,0),
   cust_bayar_denda decimal(15,0),
   cust_bayar_pokok decimal(15,0),
   cust_jumlah_denda decimal(15,0),
   cust_saldo_basil decimal(15,0),
   cust_saldo_pokok decimal(15,0),
   cust_tgl_bayar_basil date,
   cust_tgl_bayar_pokok date,
   cust_tgl_jt_tempo date,
   cust_tgl_bayar_denda date,
   rev_no integer,
   primary key (id_pdc_detail),
   constraint pdc_detail_foreign_key foreign key (id_pdc) references tb_pdc (id)
);

INSERT INTO `authority` (`id`, `authority`) VALUES
('A01', 'USER'),
('A02', 'ADMIN'),
('A03', 'MANAGER');

INSERT INTO `users` (`id`, code, `username`, `enabled`, `password`) VALUES
('U001', 'U001', 'user', b'1', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y'),
('U002', 'U002', 'admin', b'1', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y'),
('U003', 'U003', 'manager', b'1', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y'),
('U004', 'U004', 'user_h2h_amv', b'1', '$2a$10$v4ByLIrFdbQDzUIwpq75keBuCHkng8.sa1mJzDAxbM1Yd3N7ntYrW');

INSERT INTO `users_authorities` (`users_id`, `authorities_id`) VALUES
('U001', 'A01'),
('U002', 'A02'),
('U003', 'A03'),
('U004', 'A02');

-- #-- username : user_h2h_amv , password : lpdb_h2h_amv@2019
INSERT INTO `users` (`id`, code, `username`, `enabled`, `password`) VALUES
('U005', 'U005', 'abdul', b'1', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y');

INSERT INTO `users_authorities` (`users_id`, `authorities_id`) VALUES
('U005', 'A01');

-- #-- username : user_h2h_amv , password : lpdb_h2h_amv@2019

-- user : user_bpd_jateng
-- password : bpd_jateng_2019
INSERT INTO `users` (`id`, code, `username`, `enabled`, `password`) VALUES
('U006', 'U006', 'user_bpd_jateng', b'1', '$2a$10$5grURX.Dcw8zN.j3eRQGSu95vNIWTZ6DiXcwPIzovn7Ew3KkSf3c.');

INSERT INTO `users_authorities` (`users_id`, `authorities_id`) VALUES
('U006', 'A01');



INSERT INTO tb_customer (
   id_customer,
   id_koperasi,
   cust_nik,
   cust_name,
   cust_age,
   cust_jenis_kelamin,
   cust_nama_usaha,
   cust_sektor_usaha,
   cust_bidang_usaha,
   cus_sektor_usaha_detil,
   cust_omset,
   cust_asset,
   cust_alamat_usaha,
   cust_penanggung_jawab,
   cust_jum_tenaga_kerja,
   cust_no_telp,
   cust_alamat,
   cust_prov,
   cust_kab,
   cust_kec,
   cust_pemanfaatan,
   cust_plafon_pengajuan,
   cust_akad_jenis,
   cust_akad_tgl,
   cust_realisasi_tgl,
   cust_realisasi_nilai,
   cust_sisa_dana,
   cust_jangka_waktu,
   cust_satuan_waktu,
   cust_pola_bunga,
   cust_tingkat_bunga,
   cust_tgl_jatuh_tempo1,
   rev_no,status_cust
) VALUES
('C001','yose','1234576','yose',23,0,'as','aas','asd','sfessda',1000000,1000000,'jln. pancoran barat','yose',10,'00999','pancoran','jakar','jakse','panco',1,100000,12,'2019-11-11','2019-12-12',100000,10000,12,2,1,'hbos','2020-12-12',12,1),
('C002','yose','1234576','yose',23,0,'as','aas','asd','sfessda',1000000,1000000,'jln. pancoran barat','yose',10,'00999','pancoran','jakar','jakse','panco',1,100000,12,'2019-11-11','2019-12-12',100000,10000,12,2,1,'hbos','2020-12-12',12,1),
('C003','yose','1234576','yose',23,0,'as','aas','asd','sfessda',1000000,1000000,'jln. pancoran barat','yose',10,'00999','pancoran','jakar','jakse','panco',NULL,100000,12,'2019-11-11','2019-12-12',100000,10000,12,2,1,'hbos','2020-12-12',12,1);

INSERT INTO tb_pdc (
   id_pdc,
   id_mitra,
   id_customer,
   id_proposal,
   id_prop_pencarian_ke,
   pdc_no_cust,
   pdc_date_cust,
   nama_cust,
   pdc_bank_code_cust,
   pdc_bank_name_cust,
   pdc_acc_rekening_cust,
   pdc_installment_cust,
   pdc_contract_no_cust,
   pdc_note_cust,
   pdc_ammount_cust,
   pdc_due_date_cust
) VALUES
('P001',555,'C001', 66521223,45,2345,'2019-12-12','yose',12,'BNI',34525,2,123151,'great',88888,'2019-08-11'),
('P002',555,'C002', 66521223,45,2345,'2019-12-12','yose',12,'BNI',34525,2,123151,'great',88888,'2019-08-11'),
('P003',666,'C003', 66521223,45,2345,'2019-12-12','yose',12,'BNI',34525,2,123151,'great',88888,'2019-08-11');

INSERT INTO tb_pdc_detail (
   id_pdc_detail,
   id_pdc,
   cust_angs_ke,
   cust_tgl_jt_tempo,
   cust_saldo_pokok,
   cust_saldo_basil,
   cust_bayar_pokok,
   cust_bayar_basil,
   cust_tgl_bayar_pokok,
   cust_tgl_bayar_basil,
   cust_jumlah_denda,
   cust_bayar_denda,
   cust_tgl_bayar_denda,
   rev_no
) VALUES
('PD001','P001',1,'2019-10-01',0,0,1000000,0,'2019-12-25',NULL,0,0,NULL,0),
('PD002','P001',2,'2019-10-01',0,0,1000000,0,'2019-12-25',NULL,0,0,NULL,0),
('PD003','P002',1,'2019-10-01',0,0,1000000,0,'2019-12-25',NULL,0,0,NULL,0),
('PD004','P003',1,'2019-10-01',0,0,1000000,0,'2019-12-25',NULL,0,0,NULL,0),
('PD005','P003',2,'2019-10-01',0,0,1000000,0,'2019-12-25',NULL,0,0,NULL,0);
