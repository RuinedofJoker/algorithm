package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 汉诺塔问题
 */
public class HanotaQuestion {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        List<Integer> C = new ArrayList<>();
        new HanotaQuestion().hanota(A,new ArrayList<>(), C);
        System.out.println(C);
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanotaRecursion(A.size(), A, B, C);
    }

    public void hanotaRecursion(int num, List<Integer> A, List<Integer> B, List<Integer> C) {
        //A柱上只有一个元素，直接移到C柱上
        if (num == 1){

            C.add(0, A.remove(0));
        }else {
            //将A柱上的size()-1个元素移到B柱上
            hanotaRecursion(num-1, A, C, B);
            C.add(0, A.remove(0));
            hanotaRecursion(num-1,B,A,C);
        }
    }
}
