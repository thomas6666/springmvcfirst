-- Create table
create table TB_USER
(
  userid      NUMBER not null,
  username    VARCHAR2(50),
  password    VARCHAR2(50),
  email       VARCHAR2(50),
  description VARCHAR2(150)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 1M
    next 1M
    minextents 1
    maxextents unlimited
  )
nologging;
-- Create/Recreate primary, unique and foreign key constraints 
alter table TB_USER
  add constraint PK_TB_USER_USERID primary key (USERID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
