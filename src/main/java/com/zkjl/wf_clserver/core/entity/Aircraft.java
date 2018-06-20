package com.zkjl.wf_clserver.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * 飞机
 *
 */
@Data
@Document(collection = "aircraft")
public class Aircraft {
    /**
     * 飞机记录id
     *
     */
    @Id
    private String id;
    /**
     * 身份证号
     *
     */
    @Field(value = "id_card")
    private String idCard;
    /**
     * 航班号
     *
     */
    @Field(value = "flight_number")
    private String flightNumber;
    /**
     * 出发地
     *
     */
    @Field(value = "from_address")
    private String fromAddress;
    /**
     * 目的地
     *
     */
    private String destination;
    /**
     * 座位号
     *
     */
    private String seat;
    /**
     * 出发时间
     *
     */
    @Field(value = "departure_time")
    private Date departureTime;
    /**
     * 到达时间
     *
     */
    @Field(value = "arrival_time")
    private Date arrivalTime;
    /**
     * 舱位
     */
    private String berth;

}