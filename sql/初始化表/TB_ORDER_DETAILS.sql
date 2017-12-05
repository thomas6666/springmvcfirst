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
  is '详细单号';
comment on column TB_ORDER_DETAILS.itemid
  is '商品单号';
comment on column TB_ORDER_DETAILS.orderid
  is '订单号';
comment on column TB_ORDER_DETAILS.count
  is '下单商品数量';
comment on column TB_ORDER_DETAILS.totalprice
  is '下单商品总价';
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
