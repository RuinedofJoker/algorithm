package 剑指;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 20. 表示数值的字符串
 */
public class 表示数值的字符串 {

    Map<Float_State, Map<CharType, Float_State>> floatStateMap = new HashMap<>(){{
        put(Float_State.Start, new HashMap<>(){{
            put(CharType.Sign, Float_State.Sign);
            put(CharType.Number, Float_State.Not_Point_Num);
            put(CharType.Point, Float_State.Not_Num_Point);
        }});
        put(Float_State.Sign, new HashMap<>(){{
            put(CharType.Number, Float_State.Not_Point_Num);
            put(CharType.Point, Float_State.Not_Num_Point);
        }});
        put(Float_State.Not_Point_Num, new HashMap<>(){{
            put(CharType.Number, Float_State.Not_Point_Num);
            put(CharType.Point, Float_State.Num_Point);
            put(CharType.EOS, Float_State.End);
        }});
        put(Float_State.Not_Num_Point, new HashMap<>(){{
            put(CharType.Number, Float_State.Point_Num);
        }});
        put(Float_State.Num_Point, new HashMap<>(){{
            put(CharType.Number, Float_State.Point_Num);
            put(CharType.EOS, Float_State.End);
        }});
        put(Float_State.Point_Num, new HashMap<>(){{
            put(CharType.Number, Float_State.Point_Num);
            put(CharType.EOS, Float_State.End);
        }});
        put(Float_State.End, new HashMap<>(){{
        }});
    }};

    Map<Integer_State, Map<CharType, Integer_State>> integerStateMap = new HashMap<>(){{
        put(Integer_State.Start, new HashMap<>(){{
            put(CharType.Sign, Integer_State.Sign);
            put(CharType.Number, Integer_State.Num);
        }});
        put(Integer_State.Sign, new HashMap<>(){{
            put(CharType.Number, Integer_State.Num);
        }});
        put(Integer_State.Num, new HashMap<>(){{
            put(CharType.Number, Integer_State.Num);
            put(CharType.EOS, Integer_State.End);
        }});
        put(Integer_State.End, new HashMap<>(){{
        }});
    }};

    public boolean isNumber(String s) {
        try {
            s = s.trim();
            if (s.length() == 0) return false;
            if (checkIsFloat(s)) {
                return true;
            }
            if (checkIsFloat(s)) {
                return true;
            }
            if (checkCharType(s.charAt(0)).equals(CharType.E) || checkCharType(s.charAt(s.length() - 1)).equals(CharType.E)) {
                return false;
            }
            String[] es = null;
            if (s.contains("e") && s.contains("E")) {
                return false;
            }else if (s.contains("e")) {
                es = s.split("e");
            }else if (s.contains("E")){
                es = s.split("E");
            }else {
                return false;
            }
            if (es.length != 2) {
                return false;
            }
            if (!checkIsFloat(es[0]) && !checkIsInteger(es[0])) {
                return false;
            }
            if (!checkIsInteger(es[1])) {
                return false;
            }
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    private boolean checkIsFloat(String s) {
        Float_State currentState = Float_State.Start;
        for (char c : s.toCharArray()) {
            Map<CharType, Float_State> nextCanBeState = floatStateMap.get(currentState);
            CharType nextState = checkCharType(c);
            if (nextCanBeState.containsKey(nextState)) {
                currentState = nextCanBeState.get(nextState);
            }else {
                return false;
            }
        }
        try {
            if (floatStateMap.get(currentState).get(CharType.EOS).equals(Float_State.End)) {
                return true;
            }else {
                return false;
            }
        }catch (Exception e) {
            return false;
        }
    }

    private boolean checkIsInteger(String s) {
        Integer_State currentState = Integer_State.Start;
        for (char c : s.toCharArray()) {
            Map<CharType, Integer_State> nextCanBeState = integerStateMap.get(currentState);
            CharType nextState = checkCharType(c);
            if (nextCanBeState.containsKey(nextState)) {
                currentState = nextCanBeState.get(nextState);
            }else {
                return false;
            }
        }
        if (integerStateMap.get(currentState).get(CharType.EOS).equals(Integer_State.End)) {
            return true;
        }else {
            return false;
        }
    }
    private CharType checkCharType(char currentChar) {
        if (currentChar <= '9' && currentChar >= '0') {
            return CharType.Number;
        }
        if (currentChar == '.') {
            return CharType.Point;
        }
        if (currentChar == '+' || currentChar == '-') {
            return CharType.Sign;
        }
        if (currentChar == 'e' || currentChar == 'E') {
            return CharType.E;
        }
        if (currentChar == ' ') {
            return CharType.Space;
        }
        return CharType.EOS;
    }

    enum Float_State {
        Start,  //开始
        Sign,  //符号
        Not_Point_Num,  //不带点的数
        Not_Num_Point,  //不带数的点
        Num_Point,  //带数的点
        Point_Num,  //带点的数
        End  //结束
    }

    enum Integer_State {
        Start,  //开始
        Sign,  //符号
        Num,  //数字
        End  //结束
    }

    enum CharType {
        Number,
        Point,
        Sign,
        E,
        Space,
        EOS
    }
}
