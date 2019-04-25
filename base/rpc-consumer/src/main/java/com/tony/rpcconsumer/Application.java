package com.tony.rpcconsumer;

import com.tony.rpcinterface.Calculator;
import com.tony.rpcinterface.CalculatorRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.util.Objects;

/**
 * @author tony
 * 2019/4/25-16:13
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    public static class CalculatorController {

        public static Log logger = LogFactory.getLog(CalculatorController.class);

        @GetMapping("/add/{i}/{j}")
        public int add(@PathVariable("i") int i, @PathVariable("j") int j) {
            Calculator calculator = (Calculator) Proxy.newProxyInstance(Application.class.getClassLoader(), new Class[]{Calculator.class}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Socket socket = null;
                    try {
                        socket = new Socket("127.0.0.1", 9000);
                        CalculatorRequest request = this.generateRequest(Calculator.class, method.getName(), i, j);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        objectOutputStream.writeObject(request);

                        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                        Object object = objectInputStream.readObject();
                        logger.debug("Recieve result: " + object.toString());
                        return object;
                    } catch (Exception e) {
                        logger.debug(e);
                    } finally {
                        if (Objects.nonNull(socket)) {
                            socket.close();
                        }
                    }
                    return null;
                }

                private CalculatorRequest generateRequest(Class clazz, String methodName, Object...params) {
                    return new CalculatorRequest(clazz, methodName, params);
                }
            });

            return calculator.add(i, j);
        }
    }

}
