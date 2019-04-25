package com.tony.rpcprovider;

import com.tony.rpcinterface.Calculator;
import org.springframework.stereotype.Component;

/**
 * @author tony
 * 2019/4/25-16:05
 */
@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(Integer i, Integer j) {
        return i + j;
    }
}
