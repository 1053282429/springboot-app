package leetcode;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test0612 {



//    @Test
    public void test0612(){
        System.out.println(longestPalindrome("c"));
    }

    /**
     *   cbbd   对字符串处理  c*b*b*d*
     *   从每一个元素开始，比较它前k个元素和后k个元素是否相同,如果回文字符串长度是偶数则会出现问题，故对字符串进行处理
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int k = 1;
        String returnStr = null;
        int strLength = 0;
        s = s.replace("", "*");
        for (int i = 0; i < s.length(); i++) {
            while (i - k >= 0 && i + k < s.length()) {
                if (s.charAt(i - k) == s.charAt(i + k)) {
                    strLength = Math.max(2 * k + 1, strLength);
                    if (strLength == 2 * k +1) {            //*c*b* 5    *c*b*b* 7
                        returnStr = s.substring(i - k, i + k + 1);
                    }
                    k++;
                } else {
                    break;
                }
            }
            k = 1;
        }
        return returnStr.replace("*", "");
    }


//    @Test
    public void test0613() {

        System.out.println(convert("ABCDE",4));
    }

    /**
     *PAYPALISHIRING   12  14 15 18
     * P   A   H   N   3    4  4   5          0   4   8    12  i + k+1       4-3 =1
     * A P L S I I G   6    7  7   8          1 3 5 7 9 11 13  i + k-1
     * Y   I   R       3    3  4   5          2   6   10       i + k+1
     *
     *
     *                                          0        8
     *                                          1      7  9
     *                                          2    6  10
     *                                          3  5    11
     *                                          4       12              3 % 5 ==3  5%5 ==0 + 5
     */
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()){
            return s;
        }
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0;i < numRows; i++) {
            List<Character> objects = new ArrayList<>();
            list.add(objects);
        }
        for (int i = 0;i < s.length(); i++){
            if (i % (numRows-1) == 0 && (i / (numRows-1)) % 2 == 1) {
                List<Character> t = list.get(numRows - 1);
                t.add(s.charAt(i));
                int len = s.length() - i -1;
                len = Math.min(len, numRows -2);
                for (int j = 0;j < len; j++) {
                    List<Character> x = list.get(numRows - j -2);
                    x.add(s.charAt(i + j + 1));
                }
                i = i + numRows - 2;
                continue;
            }
            int len = s.length() - i;
            len = Math.min(len, numRows -1);
            for (int k = 0;k < len; k++) {
                List<Character> t = list.get(k);
                t.add(s.charAt(i + k));
            }
            i = i + numRows - 2;
        }


        StringBuilder sb =new StringBuilder();
        for (int i = 0;i < numRows; i++) {
            List<Character> characters = list.get(i);
            characters.forEach(sb::append);
        }
        return sb.toString();
    }

    public void test0614() {
        System.out.println(reverse(1534236469));
    }

    /**
     *
     *
     *
     *
     * 312   213
     */

    public int reverse(int x) {
        String s = String.valueOf(x);
        boolean flag = false;
        if (x < 0){
            s = s.substring(1);
            flag = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1;i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        if (sb.length() == 10 && Integer.parseInt(sb.substring(0,9).toString()) > 214748364) {
            return 0;
        }
        if (flag) {
            sb.insert(0,"-");
        }
        return  Integer.parseInt(sb.toString());

    }


//    48 - 57  45

    @Test
    public void test0615(){
        System.out.println(myAtoi("-2147483649"));
    }

    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        boolean iszero = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (48 <= c && c <= 57) {
                if (sb.length() == 0 && c == 48) {
                    iszero = true;
                } else if (sb.length() == 1 && c == 48 && sb.charAt(0) == 43) {
                    iszero = true;
                }else {
                    sb.append(c);
                }
            } else if (c == 45) {
                if (sb.length() == 0 && !flag && !iszero) {
                    flag = true;
                } else {
                    break;
                }
            } else if (c == 43) {
                if (sb.length() == 0 && !flag && !iszero) {
                    sb.insert(0,"+");
                } else {
                    break;
                }
            } else if (c == 32 && !flag && !iszero){
                if (sb.length() == 0){
                    continue;
                }
                break;
            } else {
                break;
            }
        }
        if (sb.length() > 0 && sb.charAt(0) == 43) {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) {
            return 0;
        }

        if (sb.length() > 10) {
            if (flag) {
                return -2147483648;
            } else {
                return 2147483647;
            }
        }
        if (sb.length() == 10 && Integer.parseInt(sb.substring(0,9)) >= 214748364) {
            if (flag) {
                if (Integer.parseInt(sb.substring(0,9)) == 214748364 && sb.charAt(9) < 56) {
                    return Integer.parseInt("-214748364"+sb.charAt(9));
                }
                return -2147483648;
            } else {
                if (Integer.parseInt(sb.substring(0,9)) == 214748364 && sb.charAt(9) < 55) {
                    return Integer.parseInt("214748364"+sb.charAt(9));
                }
                return 2147483647;
            }
        }
        if (flag) {
            sb.insert(0,"-");
        }
        return Integer.parseInt(sb.toString());



    }

}
