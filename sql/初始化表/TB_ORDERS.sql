-- Create table
create table TB_ORDERS
(
  orderid    NUMBER not null,
  userid     NUMBER,
  createtime DATE,
  state      NUMBER
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
comment on column TB_ORDERS.orderid
  is '订单号';
comment on column TB_ORDERS.userid
  is '用户ID';
comment on column TB_ORDERS.createtime
  is '下单时间';
comment on column TB_ORDERS.state
  is '状态 0未支付 1 已支付 2取消订单';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TB_ORDERS
  add constraint PK_TB_ORDERS_ORDERID primary key (ORDERID)
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
alter table TB_ORDERS
  add constraint FK_TB_ORDERS_USERS_USERID foreign key (USERID)
  references TB_USER (USERID) on delete cascade;
