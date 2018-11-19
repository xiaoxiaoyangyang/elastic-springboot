package com.example.createdata.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JSONType(ignores = {"date"})
public class ScrollID implements Serializable {
    @JSONField(name = "scroll_id")
    private String scrollId;

    @JSONField(format = "yyyy-mm-dd")
    private Date date;
}
