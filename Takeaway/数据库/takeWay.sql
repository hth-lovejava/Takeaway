-- 创建数据库
CREATE DATABASE IF NOT EXISTS `takeWay`;
USE `takeWay`;
-- 创建用户表
CREATE TABLE account (
    userId INT(255) AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    username VARCHAR(20) NOT NULL UNIQUE COMMENT '用户名',
    password VARCHAR(255) NOT NULL COMMENT '密码',
    cname VARCHAR(20) COMMENT '名称',
    phone CHAR(11) UNIQUE COMMENT '手机号码',
    address JSON DEFAULT NULL COMMENT '地址',
    createdDate DATETIME DEFAULT NOW() NOT NULL COMMENT '注册时间'
) COMMENT='用户表';
-- 创建商户表
CREATE TABLE merchant (
    merchantId INT(255) AUTO_INCREMENT PRIMARY KEY COMMENT '商户id',
    merchantName VARCHAR(20) NOT NULL UNIQUE COMMENT '商户名字',
    phone CHAR(11) NOT NULL UNIQUE COMMENT '电话',
    adress VARCHAR(255) NOT NULL UNIQUE COMMENT '地址',
    rating FLOAT(2,1) DEFAULT NULL COMMENT '评分',
    createdDate DATETIME NOT NULL COMMENT '创建时间'
) COMMENT='商户表';
-- 创建商品表
CREATE TABLE product (
    productId INT(255) AUTO_INCREMENT PRIMARY KEY COMMENT '商品id',
    merchantId INT(255) NOT NULL COMMENT '商户id',
    name VARCHAR(20) NOT NULL COMMENT '名字',
    description VARCHAR(255) DEFAULT '店家还没有添加描述' COMMENT '描述',
    categoryId INT(255) NOT NULL COMMENT '分类id',
    FOREIGN KEY (merchantId) REFERENCES merchant(merchantId) ON DELETE CASCADE ON UPDATE CASCADE
) COMMENT='商品表';
-- 创建商品分类表
CREATE TABLE category (
    categoryId INT(255) AUTO_INCREMENT PRIMARY KEY COMMENT '分类id',
    name VARCHAR(20) NOT NULL COMMENT '名字',
    description VARCHAR(255) DEFAULT '该分类没有描述' COMMENT '描述'
) COMMENT='商品分类表';
-- 创建订单表
CREATE TABLE `order` (
    orderId INT(255) AUTO_INCREMENT PRIMARY KEY COMMENT '订单id',
    userId INT(255) NOT NULL COMMENT '用户id',
    merchantId INT(255) NOT NULL COMMENT '商户id',
    totalAmount INT(255) NOT NULL COMMENT '总金额',
    status VARCHAR(10) DEFAULT '未完成' COMMENT '状态',
    createdDate DATETIME NOT NULL COMMENT '创建时间',
    updatedDate DATETIME NOT NULL COMMENT '更新时间',
    FOREIGN KEY (userId) REFERENCES account(userId) ON DELETE CASCADE ON UPDATE CASCADE
) COMMENT='订单表';
-- 创建订单详情表
CREATE TABLE orderItem (
    itemId INT(255) AUTO_INCREMENT PRIMARY KEY COMMENT '详情id',
    orderId INT(255) NOT NULL COMMENT '订单id',
    productId INT(255) NOT NULL COMMENT '商品id',
    quantity INT(255) NOT NULL COMMENT '数量',
    price INT(255) NOT NULL COMMENT '价格',
    FOREIGN KEY (orderId) REFERENCES `order`(orderId) ON DELETE CASCADE ON UPDATE CASCADE
) COMMENT='订单详情表';
-- 创建支付表
CREATE TABLE payment (
    paymentId INT(255) AUTO_INCREMENT PRIMARY KEY COMMENT '支付Id',
    orderId INT(255) NOT NULL COMMENT '订单id',
    amount INT(255) NOT NULL COMMENT '金额',
    paymentMethod VARCHAR(20) DEFAULT '余额' COMMENT '支付方式',
    status VARCHAR(20) DEFAULT '未支付' COMMENT '状态',
    createdDate DATETIME NOT NULL COMMENT '创建时间',
    FOREIGN KEY (orderId) REFERENCES `order`(orderId) ON DELETE CASCADE ON UPDATE CASCADE
) COMMENT='支付表';
-- 创建评价表
CREATE TABLE review (
    reviewId INT(255) AUTO_INCREMENT PRIMARY KEY COMMENT '评价id',
    userId INT(255) NOT NULL COMMENT '用户id',
    merchantId INT(255) NOT NULL COMMENT '商户id',
    rating FLOAT(2,1) NOT NULL COMMENT '评分',
    comment TEXT NOT NULL COMMENT '评价内容',
    createdDate DATETIME NOT NULL COMMENT '创建时间',
    FOREIGN KEY (merchantId) REFERENCES merchant(merchantId) ON DELETE CASCADE ON UPDATE CASCADE
) COMMENT='评价表';
-- 创建配送表
CREATE TABLE deliver (
    deliveryId INT(255) AUTO_INCREMENT PRIMARY KEY COMMENT '配送id',
    orderId INT(255) NOT NULL COMMENT '订单id',
    deliveryAddress VARCHAR(255) NOT NULL COMMENT '配送地址',
    deliveryTime DATETIME NOT NULL COMMENT '配送时间',
    status ENUM('已接到订单', '正在配送', '已完成') DEFAULT '已接到订单' COMMENT '状态',
    createdDate DATETIME NOT NULL COMMENT '创建时间',
    FOREIGN KEY (orderId) REFERENCES `order`(orderId) ON DELETE CASCADE ON UPDATE CASCADE
) COMMENT='配送表';