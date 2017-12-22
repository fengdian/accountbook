package com.wxf.accountbook;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 怎么着也得有个马甲 on 2017/11/1.
 *
 * @fileName AnnotaionData
 * @date on 2017/11/1 15:21
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotaionData {
     String value() default  "";
}
