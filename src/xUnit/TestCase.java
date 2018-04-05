package xUnit;

import java.lang.reflect.Method;

/**
 * 
 * @author Aibek Smagulov
 * Simple xUnit implementation as described in the book Test Driven Development: By Example
 * by Kent Beck.
 * Extend this class, define test methods with names starting with "test" and run.
 * Coverage is 100%.
 */
public class TestCase
{
    public static final String testResultFormat = "Run: %d, Failed: %d";

    protected void setUp()
    {
    }

    protected void test(String methodName)
    {
        setUp();
        try {
            Method method = this.getClass().getMethod(methodName, new Class[] {});
            method.invoke(this, new Object[] {});
        } catch (Exception e) {
            throw new RuntimeException("Failed test " + e.getMessage());
        } finally {
            tearDown();
        }
    }

    public String run()
    {
        int run = 0, failed = 0;
        Method[] methods = this.getClass().getMethods();
        for (Method method : methods) {
            String methodName = method.getName(); // TODO Search by @Test
                                                  // annotation
            if (methodName.startsWith("test")) {
                run++;
                try {
                    test(methodName);
                } catch (Exception e) {
                    failed++;
                }
            }
        }
        String result = String.format(testResultFormat, run, failed);
        System.out.println(result);
        return result;
    }

    protected void fail()
    {
        throw new RuntimeException("Unreachable code");
    }

    protected void tearDown()
    {
    }
}
