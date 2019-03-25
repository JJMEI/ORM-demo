package org.apache.test.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * Created by meijunjie on 2019/1/30.
 */
public class Test {
    public static void main(String[] args) throws Throwable {
        MapperProxy proxy = new MapperProxy();

        Field field = System.class.getDeclaredField("props");
        field.setAccessible(true);
        Properties props = (Properties) field.get(null);
        props.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        UserMapper mapper = proxy.newInstance(UserMapper.class);


        User user = mapper.getUserById(101);

        InvocationHandler invocationHandler = Proxy.getInvocationHandler(mapper);

        invocationHandler.invoke(mapper,mapper.getClass().getMethod("getUserById", Integer.class),new Object[]{1});
        System.out.println("是否是生成的代理类: " + Proxy.isProxyClass(mapper.getClass()));




        System.out.println(user.toString());
    }
}
