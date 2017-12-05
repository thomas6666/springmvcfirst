-- Create table
create table TB_ORDER_DETAILS
(
  detailid   NUMBER(10),
  itemid     NUMBER(10) not null,
  orderid    NUMBER(10) not null,
  count      NUMBER(10),
  totalprice NUMBER(10,2)
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
comment on column TB_ORDER_DETAILS.detailid
  is '��ϸ����';
comment on column TB_ORDER_DETAILS.itemid
  is '��Ʒ����';
comment on column TB_ORDER_DETAILS.orderid
  is '������';
comment on column TB_ORDER_DETAILS.count
  is '�µ���Ʒ����';
comment on column TB_ORDER_DETAILS.totalprice
  is '�µ���Ʒ�ܼ�';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TB_ORDER_DETAILS
  add constraint PK_TB_ITEMS_ORDERS primary key (ITEMID, ORDERID)
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
alter table TB_ORDER_DETAILS
  add constraint FK_TB_ITEMS_ITEMID foreign key (ITEMID)
  references TB_ITEMS (ITEMID) on delete cascade;
alter table TB_ORDER_DETAILS
  add constraint FK_TB_ORDERS_ORDERID foreign key (ORDERID)
  references TB_ORDERS (ORDERID) on delete cascade;
