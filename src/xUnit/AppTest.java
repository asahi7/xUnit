package xUnit;

public class AppTest extends TestCase
{
    private Fibonacci fibonacci;

    @Override
    public void setUp()
    {
        fibonacci = new Fibonacci();
    }

    public void testFirstFibonacciNumbers()
    {
        assert fibonacci.find(1) == 0;
        assert fibonacci.find(2) == 1;
        assert fibonacci.find(3) == 1;
        assert fibonacci.find(4) == 2;
    }

    public void testFibbonacci()
    {
        assert fibonacci.find(8) == 13;
    }

    public void testIllegalArgumentException()
    {
        try {
            fibonacci.find(0);
            fail();
        } catch (IllegalArgumentException expected) {
        }
    }

    public static void main(String[] args)
    {
        new AppTest().run();
    }
}
