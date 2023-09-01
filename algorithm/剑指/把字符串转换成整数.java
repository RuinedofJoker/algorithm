package 剑指;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 67. 把字符串转换成整数
 */
public class 把字符串转换成整数 {
    public static void main(String[] args) {
        System.out.println(new 把字符串转换成整数().strToInt("-13+8"));
    }

    Map<State, Map<CharType, State>> stateMap = new HashMap<>(){{
        put(State.start, new HashMap<>(){{
            put(CharType.space, State.start);
            put(CharType.sign, State.sign);
            put(CharType.number, State.in_number);
        }});
        put(State.sign, new HashMap<>(){{
            put(CharType.number, State.in_number);
        }});
        put(State.in_number, new HashMap<>(){{
            put(CharType.number, State.in_number);
        }});
    }};

    public int strToInt(String str) {
        State currentState = State.start;
        char[] strChars = str.toCharArray();
        StringBuilder builder = new StringBuilder("0");
        boolean isPos = true;

        for (char c : strChars) {
            if (currentState.equals(State.end)) break;
            Map<CharType, State> nextBeState = stateMap.get(currentState);
            currentState = nextBeState.getOrDefault(getCharType(c), State.end);
            if (getCharType(c).equals(CharType.number)) {
                builder.append(c);
            }
            if (getCharType(c).equals(CharType.sign) && State.sign.equals(currentState)) {
                isPos = c == '+';
            }
        }

        try {
            return isPos ? Integer.parseInt(builder.toString()) : -Integer.parseInt(builder.toString());
        }catch (Exception e) {
            return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }

    private CharType getCharType(char c) {
        if (c == ' ') {
            return CharType.space;
        }else if (c >= '0' && c <= '9') {
            return CharType.number;
        }else if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == '.') {
            return CharType.word;
        }else if (c == '+' || c == '-') {
            return CharType.sign;
        }else {
            return null;
        }
    }

    enum State {
        start,
        sign,
        in_number,
        end
    }

    enum CharType {
        space,
        number,
        word,
        sign,
        point
    }
}
