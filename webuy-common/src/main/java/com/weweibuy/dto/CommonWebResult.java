package com.weweibuy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonWebResult implements Serializable {

    private Integer code; //状态码

    private String status; //状态 SUCCESS

    private String msg; //信息

    private Object data; //数据


}