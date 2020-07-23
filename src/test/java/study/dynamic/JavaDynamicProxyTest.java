package study.dynamic;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created By kjs4395 on 2020-07-23
 */
public class JavaDynamicProxyTest {

    @Test
    public void javaDynamicProxy() {
        Hello proxyInstance = (Hello) Proxy.newProxyInstance(JavaDynamicProxyTest.class.getClassLoader(),
                new Class[] {Hello.class},
                new DynamicInvocationHandler(new HelloTarget()));

        assertEquals(proxyInstance.sayHello("test"),"HELLO TEST" );
        assertEquals(proxyInstance.sayHi("test"), "HI TEST");
        assertEquals(proxyInstance.sayThankyou("test"),"THANK YOU TEST");

    }

}
