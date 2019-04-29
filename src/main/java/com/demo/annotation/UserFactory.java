package com.demo.annotation;

import com.demo.annotation.testModel.User;
import org.springframework.context.expression.MapAccessor;

import java.lang.reflect.Method;

public class UserFactory {

    public static User create() {
        User user = new User();

        Method[] methods = User.class.getMethods();
//        User.class.getFields();

        try {

            for (Method method : methods) {
                Init init = method.getAnnotation(Init.class);
                method.invoke(user, init.value());
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }



    public void inits(){

        System.out.println(MapAccessor.AASTORE);

    }
}
