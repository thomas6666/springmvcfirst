-- Create table
create table TB_ITEMS
(
  itemid      NUMBER(10) not null,
  name        VARCHAR2(50),
  price       NUMBER(10,2),
  mark        VARCHAR2(10),
  count       NUMBER(10),
  type        VARCHAR2(50),
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
-- Add comments to the columns 
comment on column TB_ITEMS.name
  is '名称';
comment on column TB_ITEMS.price
  is '价格';
comment on column TB_ITEMS.mark
  is '标签';
comment on column TB_ITEMS.count
  is '库存';
comment on column TB_ITEMS.type
  is '类型 1 衣服 2 食品 3 家具';
comment on column TB_ITEMS.description
  is '描述';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TB_ITEMS
  add constraint PK_TB_ITEMS_ITEMID primary key (ITEMID)
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
