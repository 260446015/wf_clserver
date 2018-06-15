package com.zkjl.wf_clserver.core.entity;
/***********************************************************************
 * Module:  aircraft.java
 * Author:  Administrator
 * Purpose: Defines the Class aircraft
 ***********************************************************************/

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * 飞机
 *
 * @pdOid a37124ff-e481-496d-a395-e0104f9de0b5
 */
@Data
@Document(collection = "aircraft")
public class Aircraft {
    /**
     * 飞机记录id
     *
     * @pdOid e3cacf20-8795-4a46-80e6-c1810cb23302
     */
    @Id
    public String id;
    /**
     * 身份证号
     *
     * @pdOid c3e41b7f-4b4b-4d1c-b897-86a8c0fd62ed
     */
    @Field(value = "id_card")
    public String idCard;
    /**
     * 航班号
     *
     * @pdOid df462fad-ec83-487f-915a-ca9c87f3e04e
     */
    @Field(value = "flight_number")
    public String flightNumber;
    /**
     * 出发地
     *
     * @pdOid c3a6fd24-87eb-4c04-86a0-bc30b96793d6
     */
    @Field(value = "from_address")
    public String fromAddress;
    /**
     * 目的地
     *
     * @pdOid dc30f038-c40c-4925-a008-179476b403fe
     */
    public String destination;
    /**
     * 座位号
     *
     * @pdOid 46c6431b-5e56-43ec-8dd5-36b2f3b9a027
     */
    public String seat;
    /**
     * 出发时间
     *
     * @pdOid 81c0a585-9f0e-45e9-9860-b32807635c4d
     */
    @Field(value = "departure_time")
    public Date departureTime;
    /**
     * 到达时间
     *
     * @pdOid 0e170f1c-10fa-4625-abcf-70089c987282
     */
    @Field(value = "arrival_time")
    public Date arrivalTime;
    /**
     * 舱位
     *
     * @pdOid d57a33c4-b4f1-49c0-92ac-7eb884c7a535
     */
    public String berth;

}