package com.deemo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

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


