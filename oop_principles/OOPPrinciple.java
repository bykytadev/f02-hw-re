package ronin_engineer.oop_principles;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OOPPrinciple {

    public static void main(String[] args) {
        // Sử dụng phương thức equals và toString của các lớp Wrapper
        Integer int1 = new Integer(10);
        Integer int2 = new Integer(10);
        System.out.println("int1 equals int2: " + int1.equals(int2)); // true
        System.out.println("int1 toString: " + int1.toString()); // "10"

        // Sử dụng các phương thức của lớp String
        String str1 = "Hello";
        String str2 = "World";
        System.out.println("str1 length: " + str1.length()); // 5
        System.out.println("str1 concat str2: " + str1.concat(str2)); // "HelloWorld"
        System.out.println("str1 equals str2: " + str1.equals(str2)); // false

        // Sử dụng các phương thức của lớp StringBuilder
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println("StringBuilder: " + sb.toString()); // "Hello World"
        sb.reverse();
        System.out.println("StringBuilder reversed: " + sb.toString()); // "dlroW olleH"

        // Sử dụng các phương thức của lớp BigInteger
        BigInteger bigInt1 = new BigInteger("12345678901234567890");
        BigInteger bigInt2 = new BigInteger("98765432109876543210");
        BigInteger sum = bigInt1.add(bigInt2);
        System.out.println("BigInteger sum: " + sum.toString()); // "111111111011111111100"

        // Sử dụng các phương thức của lớp BigDecimal
        BigDecimal bigDec1 = new BigDecimal("123.456");
        BigDecimal bigDec2 = new BigDecimal("789.012");
        BigDecimal product = bigDec1.multiply(bigDec2);
        System.out.println("BigDecimal product: " + product.toString()); // "97408.265472"
    }
}

/*
 * Thực hiện viết code ví dụ sử dụng các method equals, toString và các method
 * của các Wrapper, String,
 * StringBuilder, BigInteger, BigDecimal class.
 */
