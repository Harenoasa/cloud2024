package com.atguigu.cloud;


import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public boolean isPalindrome(int x) {

        String str = String.valueOf(x);
        char[] ch = str.toCharArray();
        int y = ch.length-1,z = 0;
        if(ch[z]=='-')return false;
        while( z < y ){
            if(ch[z]!=ch[y])return false;
            z++;y--;
        }
        return true;
    }
    public boolean isPalindrome1(int x) {
        if(x<0||(x!=0&&x%10==0))return false;
        int y = 0;
        do{
            y = y*10 + x%10;
            if(x==y)return true;
            x/=10;
            if(x==y)return true;
        }while(y<x);
        return false;
    }

//    public ListNode recursion(ListNode head,ListNode now,ListNode flag){//递归
//        ListNode onward;
//        if(now!=null)onward = recursion(head,now.next,flag);
//        else return head;
//        if(onward==flag){
//            return flag;
//        }
//        if(onward.val==now.val)
//            return onward.next;
//        else return flag;
//    }

    public ListNode recursion(ListNode head,ListNode now,ListNode flag){
        return null;
    }

    public ListNode findMidst(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }



    public boolean isPalindrome(ListNode head) {//判断
        ListNode flagNode = new ListNode();
        ListNode result = recursion(head, head,flagNode);
        return result==null;
    }

 /*   public static Map<Character,Character> aMap;

    static{
        aMap=new HashMap<>();
        aMap.put('{','}');
        aMap.put('[',']');
        aMap.put('(',')');
    }*/


  /*  public boolean isValid(String s) {

        char[] charArray = s.toCharArray();
        int i = 0,j = s.length()-1;
        while(i<j){
            Character result = aMap.get(charArray[i]);
            if(result==null||!result.equals(charArray[j]) ){
                return false;
            }
            i++;j--;
        }
        return true;

    }*/

    public Stack<Character> charStack = new Stack<>();

    public int charProcess(char s){

        switch(s){
            case '{','[','(':return 1;
            case '}': if(charStack.isEmpty()||charStack.pop()!='{' )return 0;break;
            case ']': if(charStack.isEmpty()||charStack.pop()!='[' )return 0;break;
            case ')': if(charStack.isEmpty()||charStack.pop()!='(' )return 0;break;
            default: return 0;
        }
        return 2;
    }

    public boolean isValid(String s) {
        if(s.length()%2==1)return false;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            int condition =charProcess(aChar) ;
            switch(condition){
                case 1:charStack.push(aChar); break;
                case 2:break;
                case 0:return false;
            }
        }
        return charStack.isEmpty();
    }


    void test(Solution solution){

        System.out.println(solution.isValid("))"));
    }


    public int removeDuplicates(int[] nums) {

        int k=0,i=0,j=1;
        for(;j<nums.length;){

            if(nums[i]!=nums[j]){
                nums[k++] = nums[i];
                i = j++;
            }
            else if(nums[i]==nums[j])j++;

        }
        nums[k] = nums[i];
        return k+1;
    }
    void test01(){
        int[] ints = {1, 1, 2};
        int k = removeDuplicates(ints);
        System.out.println(k);
        for (int anInt : ints) {
            System.out.println(anInt);
        }


    }


    public static void main(String[] args) {//测试


        Solution solution = new Solution();
        solution.test01();


    }
}