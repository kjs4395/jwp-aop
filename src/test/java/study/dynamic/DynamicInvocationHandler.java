package study.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created By kjs4395 on 2020-07-23
 */
public class DynamicInvocationHandler implements InvocationHandler {
    private Object target;

    private final Map<String , Method> methods = new HashMap<>();

    public DynamicInvocationHandler(Object target) {
        this.target = target;
        methods.putAll(Arrays.stream(target.getClass().getDeclaredMethods())
                .collect(Collectors.toMap(Method::getName, Function.identity())));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String result = (String) methods.get(method.getName()).invoke(target, args);
        return result.toUpperCase();
    }

}
