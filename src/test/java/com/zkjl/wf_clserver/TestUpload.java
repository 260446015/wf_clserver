package com.zkjl.wf_clserver;

import com.alibaba.fastjson.JSONObject;
import com.monitorjbl.xlsx.StreamingReader;
import com.zkjl.wf_clserver.core.util.POIUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

/**
 * @author ydw
 * Created on 2018/7/10
 */

public class TestUpload {

    @Test
    public void test1(){
        String reg = "^.*\\d{6}.*$";
        String s = "青岛罡正橡塑机械有限公司　刘欣\t78039694-9\t山东省胶州市杜村镇工业园\t（2012）乐执字第1217号\t11340\t全部未履行";
        System.out.println(s.matches(reg));
    }

    @Test
    public void test2() throws FileNotFoundException {
        FileInputStream in = new FileInputStream("F:\\ceshi\\baixing_binzhou.xlsx");
        Workbook wk = StreamingReader.builder()
                .rowCacheSize(100)  //缓存到内存中的行数，默认是10
                .bufferSize(4096)  //读取资源时，缓存到内存的字节大小，默认是1024
                .open(in);  //打开资源，必须，可以是InputStream或者是File，注意：只能打开XLSX格式的文件
        Sheet sheet = wk.getSheetAt(0);
        //遍历所有的行
        for (Row row : sheet) {
            System.out.println("开始遍历第" + row.getRowNum() + "行数据：");
            //遍历所有的列
            for (Cell cell : row) {
                System.out.print(cell.getStringCellValue() + " ");
            }
            System.out.println(" ");
        }
    }

    @Test
    public void test3(){
        String s = "124";
    }

    @Test
    public void test4(){
        JSONObject obj = new JSONObject();
        JSONObject obj2 = new JSONObject();
        obj2.put("name","123");
        obj.putAll(obj2);
        System.out.println(obj2);

    }

}
