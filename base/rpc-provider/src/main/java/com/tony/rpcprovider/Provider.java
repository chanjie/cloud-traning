package com.tony.rpcprovider;

import com.tony.rpcinterface.Calculator;
import com.tony.rpcinterface.CalculatorRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author tony
 * 2019/4/25-16:05
 */
@SpringBootApplication
public class Provider {

    public static Log logger = LogFactory.getLog(Provider.class);

    public static void main(String[] args) {
        SpringApplication.run(Provider.class, args);
    }

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9000);
            logger.debug("Server started...");
            while (true) {
                Socket accept = serverSocket.accept();
                logger.debug("Request input...");
                ObjectInputStream objectInputStream = new ObjectInputStream(accept.getInputStream());
                Object o = objectInputStream.readObject();
                logger.debug("Recieved request: " + o.toString());
                CalculatorRequest request = (CalculatorRequest) o;

                Object bean = applicationContext.getBean(request.getClazz());
                Object[] params = request.getParams();

                Class[] classes = new Class[params.length];
                for (int i = 0; i < params.length; i++) {
                    classes[i] = params[i].getClass();
                }
                Method method = bean.getClass().getMethod(request.getMethodName(), classes);
                Object rtnValue = method.invoke(bean, params);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
                objectOutputStream.writeObject(rtnValue);
            }
        } catch (Exception e) {
            logger.debug(e);
        } finally {
            if (Objects.nonNull(serverSocket)) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    logger.debug(e);
                }
            }
        }
    }
}
