package com.xiaoyaotong.api.matchspu.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @author ：billHe
 * @description：标品的document
 * @date ：2019/12/2 7:26 PM
 */
@Data
@Document(indexName = "xiaoyaotong",type="standardspu")
public class ESMedicineSpu implements Serializable {

    public String getCommonName() {
        return commonName;
    }
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    @Field
    private String commonName; //通用名

    public void setId(int id) {
        this.id = id;
    }

    @Id
    private int id;


}
