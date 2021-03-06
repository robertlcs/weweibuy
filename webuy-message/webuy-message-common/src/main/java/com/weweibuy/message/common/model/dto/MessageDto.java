package com.weweibuy.message.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName MessageDto
 * @Description
 * @Author durenhao
 * @Date 2019/3/31 23:14
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("消息输出信息载体")
public class MessageDto {

    @ApiModelProperty(value = "消息id")
    private String messageCorrelationId;

    @ApiModelProperty(value = "消息发送次数")
    private Byte messageSendTime;

    @ApiModelProperty(value = "消息是否死亡")
    private Byte isDead;

    @ApiModelProperty(value = "消息是状态")
    private Byte messageStatus;

}
