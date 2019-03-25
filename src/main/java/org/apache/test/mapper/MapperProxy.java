package org.apache.test.mapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author meijunjie
 * @date 2019/1/30
 *
 * InvocationHandler
 */
public class MapperProxy implements InvocationHandler{


    /**
     * 生成代理对象
     * @param clz   被代理的对象
     * @param <T>   返回生成的代理对象
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T newInstance(Class<T> clz){
        return (T) Proxy.newProxyInstance(clz.getClassLoader(),new Class[]{clz},this);
    }


    /**
     *
     * @param proxy     生成的代理对象
     * @param method    真正要执行的方法
     * @param args      执行方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Object.class.equals(method.getDeclaringClass())){
            try{
                // object的方法
                System.out.println("执行Object对象的方法...");
                return method.invoke(this,args);
            }catch (Throwable t){

            }
        }

        System.out.println("执行目标接口方法...");
        return new User((Integer) args[0],"zhangsan",18);
    }
}
