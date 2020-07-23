package study.dynamic;

/**
 * Created By kjs4395 on 2020-07-23
 */
public class HelloTarget implements Hello {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public String sayHi(String name) {
        return "Hi " + name;
    }

    @Override
    public String sayThankyou(String name) {
        return "Thank You " + name;
    }
}
