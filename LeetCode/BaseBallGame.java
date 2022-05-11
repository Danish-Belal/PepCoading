package LeetCode;

import java.util.ArrayList;
import java.util.Objects;

/*
You are keeping score for a baseball game with strange rules.
 The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.

At the beginning of the game, you start with an empty record. You are given a list of strings ops,
 where ops[i] is the ith operation you must apply to the record and is one of the following:

An integer x - Record a new score of x.
"+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
"D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
"C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.
Return the sum of all the scores on the record. The test cases are generated so that the answer fits in a 32-bit integer.

https://leetcode.com/problems/baseball-game/
 */
public class BaseBallGame {
    public static void main(String[]args){
        String[]  str = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(str));
    }
    public static int calPoints(String[] ops) {

        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0 ;

        for(String str : ops){
            if(Objects.equals(str, "C") || Objects.equals(str, "D") || Objects.equals(str, "+")){
                if(str.equals("D")){
                    list.add(list.get(list.size()-1)*2);
                }else if(str.equals("+")){
                    list.add(list.get(list.size()-1)+list.get(list.size()-2));
                }
                else{
                    list.remove(list.size()-1);
                }
            }else{
                list.add(Integer.parseInt(str));
            }
        }

        for (Integer integer : list) sum += integer;
        return sum;


    }
}
