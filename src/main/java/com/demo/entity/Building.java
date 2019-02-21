package com.demo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
//
//CREATE TABLE `tb_building` (
//        `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
//        `code` varchar(255) DEFAULT NULL COMMENT '建筑编码',
//        `name` varchar(80) DEFAULT NULL COMMENT '建筑名称',
//        `park_id` bigint(20) NOT NULL COMMENT '所属园区id',
//        `coordinate` varchar(80) DEFAULT NULL COMMENT '地图坐标',
//        `basic_para` json DEFAULT NULL COMMENT '基本参数（JSON数组）',
//        `monitor_para` json DEFAULT NULL COMMENT '采集或者计算参数（JSON数组）',
//        `energy_para` json DEFAULT NULL COMMENT '能源消耗/产生计算数据源（JSON数组）',
//        `cfg_pic` varchar(200) DEFAULT NULL COMMENT '组态画面',
//        `memo` varchar(255) DEFAULT NULL COMMENT '备注',
//        `create_user_id` bigint(20) DEFAULT NULL,
//        `created_at` datetime DEFAULT NULL,
//        `update_user_id` bigint(20) DEFAULT NULL,
//        `updated_at` datetime DEFAULT NULL,
//        `asset_code` varchar(100) DEFAULT NULL COMMENT '资产编码',
//        `sort_value` varchar(5) DEFAULT NULL COMMENT '排序字段',
//        PRIMARY KEY (`id`) USING BTREE
//        ) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


@Entity
@Table(name = "tb_building")
@Data
@NoArgsConstructor
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "identity")
    @GenericGenerator(name = "identity", strategy = "identity")
    @Column(name = "id")
    protected Long id;

    @Column(name = "create_user_id")
    protected Long createUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    @Column(name = "created_at")
    protected LocalDateTime createdAt;

    @Column(name = "update_user_id")
    protected Long updateUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "park_id")
    private Long parkId;

    @Column(name = "coordinate")
    private String coordinate;

    @Column(name = "cfg_pic")
    private String cfgPic;

    @Column(name = "basic_para")

    private String basicPara;

    @Column(name = "monitor_para")

    private String monitorPara;

    @Column(name = "energy_para")
    private String energyPara;

    @Column(name = "memo")
    private String memo;
}


