select * from tb_user;
select * from dept;
SELECT * from tb_user;
--��ȡ��ı�ռ�
select * from dba_tablespaces;
select * from dba_tables t where t.tablespace_name='TEMP' ;
--�޸ı�ı�ռ�
alter table SCOTT.TB_ITEMS move tablespace USERS;
alter table SCOTT.TB_ORDERS move tablespace USERS;
alter table SCOTT.TB_ORDER_DETAILS move tablespace USERS;

--��ȡֵ
select seq_online.nextval from dual
