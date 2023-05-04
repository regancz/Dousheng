package com.charles.dousheng.search.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author charles
 * @date 5/4/2023 6:37 PM
 */
@Document(indexName = "video")
@Setting(shards = 1,replicas = 0)
@Setter
@Getter
public class EsVideo implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    private Long id;

    private Long MCNId;

    @Field(type = FieldType.Keyword)
    private String MCNName;

    private Long videoCategoryId;

    @Field(type = FieldType.Keyword)
    private String videoCategoryName;

    private String playUrl;

    private String coverUrl;

    private Date createTime;

    private Long favoriteCount;

    private Long commentCount;

    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String title;

    @Field(type =FieldType.Nested)
    private List<EsVideoAttributeValue> attrValueList;
}
