package com.tony.rpcinterface;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author tony
 * 2019/4/25-16:28
 */
public class CalculatorRequest implements Serializable {
    private Class clazz;
    private String methodName;
    private Object[] params;


    @Override
    public String toString() {
        return "CalculatorRequest{" +
                "params=" + Arrays.toString(params) +
                ", methodName='" + methodName + '\'' +
                '}';
    }

    public CalculatorRequest() {
        super();
    }

    public CalculatorRequest(Class clazz, String methodName, Object[] params) {
        this.clazz = clazz;
        this.methodName = methodName;
        this.params = params;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public String getMethodName() {
        return methodName;
    }
}
