package xUnit;

public class XUnitTests
{

    public void testExecutionSequence()
    {
        StringBuilder sequence = new StringBuilder();
        TestCase testCase = new TestCase()
        {
            protected void setUp()
            {
                sequence.append("setUp ");
            }

            @SuppressWarnings("unused")
            public void testThis()
            {
                sequence.append("test ");
            }

            protected void tearDown()
            {
                sequence.append("tearDown");
            }
        };
        String result = testCase.run();
        assert sequence.toString().equals("setUp test tearDown");
        assert result.equals(formatTestResult(1, 0));
    }

    public void testFailedTest()
    {
        TestCase testCase = new TestCase()
        {
            @SuppressWarnings("unused")
            public void testFailed()
            {
                assert 1 == 2;
            }
        };
        String result = testCase.run();
        assert result.equals(formatTestResult(1, 1));
    }

    public void testFail()
    {
        TestCase testCase = new TestCase()
        {
            @SuppressWarnings("unused")
            public void testFail()
            {
                int a = 2, b = 3;
                try {
                    int c = a + b;
                    fail();
                } catch (ArithmeticException expected) {
                }
            }
        };
        String result = testCase.run();
        assert result.equals(formatTestResult(1, 1));
    }

    public void testExpectedException()
    {
        TestCase testCase = new TestCase()
        {
            @SuppressWarnings("unused")
            public void testExpected()
            {
                int a = 2, b = 0;
                try {
                    int c = a / b;
                    fail();
                } catch (ArithmeticException expected) {
                }
            }
        };
        String result = testCase.run();
        assert result.equals(formatTestResult(1, 0));
    }

    private String formatTestResult(int run, int failed)
    {
        return String.format(TestCase.testResultFormat, run, failed);
    }

    public static void main(String[] args)
    {
        XUnitTests xTests = new XUnitTests();
        xTests.testExecutionSequence();
        xTests.testFailedTest();
        xTests.testFail();
        xTests.testExpectedException();

    }
}
