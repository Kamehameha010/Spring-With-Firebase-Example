package com.example.firebase.utility;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class MethodHelper<T> {

    public Object invokeGetter(T obj, String propertyName)
            throws IntrospectionException, InvocationTargetException, IllegalAccessException, IllegalArgumentException {
        var pd = new PropertyDescriptor(propertyName, obj.getClass());
        var getter = pd.getReadMethod();
        return getter.invoke(obj);
    }

    public void invokeSetter(T obj, String propertyName, Object propertValue)
            throws IntrospectionException, InvocationTargetException, IllegalAccessException, IllegalArgumentException {
        var pd = new PropertyDescriptor(propertyName, obj.getClass());
        var setter = pd.getWriteMethod();
        setter.invoke(obj, propertValue);
    }

}
