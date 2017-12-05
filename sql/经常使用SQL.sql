select * from tb_user;
select * from dept;
SELECT * from tb_user;
--获取库的表空间
select * from dba_tablespaces;
select * from dba_tables t where t.tablespace_name='TEMP' ;
--修改表的表空间
alter table SCOTT.TB_ITEMS move tablespace USERS;
alter table SCOTT.TB_ORDERS move tablespace USERS;
alter table SCOTT.TB_ORDER_DETAILS move tablespace USERS;

--获取值
select seq_online.nextval from dual
