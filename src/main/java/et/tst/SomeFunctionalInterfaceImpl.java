package et.tst;

public class SomeFunctionalInterfaceImpl implements  SomeFunctionalInterface
{

    @Override
    public String doSomething(int c, String b)
    {
        String format = String.format("value of c = %d and value of b = %s", c, b);
        System.out.println(format);
        return format;
    }
}
