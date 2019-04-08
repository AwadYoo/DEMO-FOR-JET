package com.demo.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class GatheringData {

    private Integer assetspecid;
    private String alnvalue; //属性对应的变量名称
    private String assetattrid;
    private String assetnum; // 资产编码
    private String classstructureid;
    private Integer displaysequence;
    private String measureunitid;
    private Double numvalue; //属性对应的变量ID
    private String tablevalue;
    private String description; //属性名称
    private Double initvalue; //初始值
    private Double measurevalue; //设备属性测量值
    //private SysDomain sysdomain;


    @Override
    public String toString() {
        return "GatheringData{" +
                "assetspecid=" + assetspecid +
                ", alnvalue='" + alnvalue + '\'' +
                ", assetattrid='" + assetattrid + '\'' +
                ", assetnum='" + assetnum + '\'' +
                ", classstructureid='" + classstructureid + '\'' +
                ", displaysequence=" + displaysequence +
                ", measureunitid='" + measureunitid + '\'' +
                ", numvalue=" + numvalue +
                ", tablevalue='" + tablevalue + '\'' +
                ", description='" + description + '\'' +
                ", initvalue=" + initvalue +
                ", measurevalue=" + measurevalue +
                '}';
    }
}
