package com.charles.dousheng.search.domain;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * 搜索视频的属性信息
 *
 * @author charles
 * @date 5/4/2023 10:01 PM
 */
public class EsVideoAttributeValue implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long videoAttributeId;

    // 属性值
    @Field(type = FieldType.Keyword)
    private String value;

    // 属性参数：0->规格；1->参数
    private Integer type;

    // 属性名称
    @Field(type=FieldType.Keyword)
    private String name;
}
