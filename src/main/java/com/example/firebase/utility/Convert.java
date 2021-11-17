package com.example.firebase.utility;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Convert<T> {

    public static <T> Map<String, Object> toMap(T obj) {
        MethodHelper<Object> _helper = new MethodHelper<>();

        var map = new HashMap<String, Object>();
        var fields = obj.getClass().getDeclaredFields();
        for (var field : fields) {
            try {
                map.put(field.getName(), _helper.invokeGetter(obj, field.getName()));
            } catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException
                    | IntrospectionException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
