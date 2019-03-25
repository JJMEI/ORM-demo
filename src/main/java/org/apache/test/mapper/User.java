package org.apache.test.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * Created by meijunjie on 2019/1/30.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;


    public static void main(String[] args) {
        Constructor[] constructors = User.class.getConstructors();
        for (Constructor constructor : constructors){
            System.out.println("构造方法具体: " + constructor.toString());
            System.out.println("此构造方法的名称: " + constructor.getName());
            System.out.println("hashCode: " + constructor.hashCode());
            System.out.println("是否复合构造方法: " + constructor.isSynthetic());
            System.out.println("是否可带可变参数: " + constructor.isVarArgs());
            System.out.println("描述此Constructor的字符串，类型参数: " + constructor.toGenericString());
            System.out.println("此方法上声明的注解对象: " + Arrays.toString(constructor.getDeclaredAnnotations()));
            System.out.println("Constructor Java语言修饰符: " + constructor.getModifiers());
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
