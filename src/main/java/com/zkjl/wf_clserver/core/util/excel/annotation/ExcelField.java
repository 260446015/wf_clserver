package com.zkjl.wf_clserver.core.util.excel.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author Goofy
 * Excel注解，用以生成Excel表格文件
 */
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelField {

    public abstract String value();

    public abstract String title();

    public abstract int type();

    public abstract int align();

    public abstract int sort();

    public abstract String dictType();

    public abstract Class<?> fieldType();

    public abstract int[] groups();


}