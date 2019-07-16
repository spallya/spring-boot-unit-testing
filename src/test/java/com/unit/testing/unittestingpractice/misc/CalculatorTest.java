package com.unit.testing.unittestingpractice.misc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class CalculatorTest {

    private int expected;
    private int firstVal;
    private int secondVal;

    private Calculator calculator;

    public CalculatorTest(int expected, int firstVal, int secondVal) {
        this.expected = expected;
        this.firstVal = firstVal;
        this.secondVal = secondVal;
    }

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() throws Exception {
        System.out.println(expected + " " + firstVal + " " + secondVal);
        assertThat(calculator.add(firstVal, secondVal)).isEqualTo(expected);
    }

    @Parameters
    public static Collection<Object[]> testData() {
        Object[][] data = new Object[][]{ {5,1,4}, {9,6,3}, {11,6,5}};
        return Arrays.asList(data);
    }
}