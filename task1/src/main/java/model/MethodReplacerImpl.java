package model;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class MethodReplacerImpl implements MethodReplacer {
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("Heh, Hi again instead of buy!");
        return null;
    }
}
