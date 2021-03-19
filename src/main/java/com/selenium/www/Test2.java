package com.selenium.www;


import java.net.MalformedURLException;

public class Test2 {
    public static void main(String[] args) {
        ListNode<String> myList = new ListNode<String>();
        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.add("d");
        myList.add("e");
        myList.add("f");
        System.out.println("第一个元素是:" + myList.get(0));
        myList.remove(2);
        System.out.println("删除之后，第三个元素是:"+myList.get(3));

        System.out.println("-----------替换之后--------");

        myList.replace(1, "b11");
        System.out.println("第二个元素是"+myList.get(1));


    }
}
