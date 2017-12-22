package com.wxf.serviceport.util;

import android.database.Cursor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */

public class CursorUtil {
    public static List arrayFromCursor(Cursor c,Class d) throws IllegalAccessException, InstantiationException {
        List list=new ArrayList();
        while (c.moveToNext()){
            Object obj=d.newInstance();
            Field[] fields=new Field[0];
            fields=getClassAllField(d,fields);
            for(Field f:fields){
                f.setAccessible(true);
                int index=c.getColumnIndex(f.getName());
                if(index>=0){
                    if(f.getType().getSimpleName().equals("int")){
                        f.set(obj,c.getInt(index));
                    }else if(f.getType().getSimpleName().equals("long")){
                        f.set(obj,c.getLong(index));
                    }else if(f.getType().getSimpleName().equals("float")){
                        f.set(obj,c.getFloat(index));
                    }else if(f.getType().getSimpleName().equals("String")){
                        f.set(obj,c.getString(index));
                    }else if(f.getType().getSimpleName().equals("java.util.Date")){
                        f.set(obj,c.getString(index));
                    }
                }
            }
            list.add(obj);
        }
        c.close();
        return list;
    }

    public static Field[] getClassAllField(Class c,Field[] fields){
        int fieldsLength=fields.length;
        Field[] temFields=c.getDeclaredFields();
        fields= Arrays.copyOf(fields,fieldsLength+temFields.length);
        System.arraycopy(temFields,0,fields,fieldsLength,temFields.length);
        Class superClass=c.getSuperclass();
        if(null!=superClass){
            fields=getClassAllField(superClass,fields);
        }
        return fields;
    }
}
