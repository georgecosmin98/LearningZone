package com.challanges;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    private static Utilities util;

    @BeforeAll
    public static void beforeClass() {
        util = new Utilities();
    }

    @Test
    void everyNthChar() {
        // I put all this asserts into this method just for simplicity
        char[] output = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[]{'e', 'l'}, output);

        // Test if the n is greater then the length of the string
        char[] output1 = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 6);
        assertArrayEquals(new char[]{'h', 'e', 'l', 'l', 'o'}, output1);
    }

    @Test
    void removePairs() {
        // I put all this asserts into this method just for simplicity
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        assertNull(util.removePairs(null), "Did not get null returned when argument passes was null");
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForRemovePairs")
    void removePairs_parametrized(String actual, String expected) {
        // I put all this asserts into this method just for simplicity
        assertEquals(expected, util.removePairs(actual));
        assertEquals(expected, util.removePairs(actual));
        assertEquals(expected, util.removePairs(actual));
        assertEquals(expected, util.removePairs(actual));
        assertEquals(expected, util.removePairs(actual));
    }

    @Test
    void converter() {
        assertEquals(300,util.converter(10,5));
    }

    @Test
    void converter_arithmeticException(){
        assertThrows(ArithmeticException.class,() -> util.converter(10,0));
    }

    @Test
    void nullIfOddLength() {
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));
    }


    private static Stream<Arguments> provideArgumentsForRemovePairs() {
        return Stream.of(
                Arguments.of("ABCDEFF","ABCDEF"),
                Arguments.of("AB88EFFG","AB8EFG"),
                Arguments.of("112233445566","123456"),
                Arguments.of("ZYZQQB","ZYZQB"),
                Arguments.of("A","A"));
    }
}