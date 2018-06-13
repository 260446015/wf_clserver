package com.zkjl.wf_clserver.core.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OriginTest {
	/**
     * 省
     */
    private static final String PROVINCE = "省";
    /**
     * 市
     */
    private static final String CITY = "市";
    /**
     * 区
     */
    private static final String REGION_1 = "区";
    /**
     * 县
     */
    private static final String REGION_2 = "县";
    
    public static void main(String[] args) {
//      XX省XX市XX区；XX省XX市XX市；XX省XX市XX县；XX市XX区；XX市XX县
//      1.浙江省杭州市滨江区
//      2.上海上海市金山区
//      3.浙江省台州市玉环县
//      4.湖北省潜江市潜江经济开发区
      String[] placeList = new String[]{"山东省潍坊市昌乐县利民街45号","上海上海市金山区辉煌国际3号楼1单元203"};
      for (String place : placeList) {
          System.out.println(addressResolution(place));
      }
  }
    /**
     * 解析地址
     * @param address
     * @return
     */
    public static Map<String,String> addressResolution(String address){
        String regex="((?<province>[^省]+省|.+自治区)|上海|北京|天津|重庆)(?<city>[^市]+市|.+自治州)(?<county>[^县]+县|.+区|.+镇|.+局)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m=Pattern.compile(regex).matcher(address);
        String province=null,city=null,county=null,town=null,village=null;
        List<Map<String,String>> table=new ArrayList<Map<String,String>>();
        Map<String,String> row=null;
        while(m.find()){
            row=new LinkedHashMap<String,String>();
            province=m.group("province");
            row.put("province", province==null?"":province.trim());
            city=m.group("city");
            row.put("city", city==null?"":city.trim());
            county=m.group("county");
            row.put("county", county==null?"":county.trim());
            town=m.group("town");
            row.put("town", town==null?"":town.trim());
            village=m.group("village");
            row.put("village", village==null?"":village.trim());
            table.add(row);
        }
        return row;
    }
}
