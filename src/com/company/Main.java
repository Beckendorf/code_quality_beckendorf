package com.company;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addFront("1");
        list.addFront("2");
        list.addFront("3");
        list.addLast("0");
        list.addAtPos("insert at pos 2", 2);
        list.addAtPos("insert at pos 0", 0);
        list.stdoutDisplay();
        System.out.println("==========");
        list.removeElementFromValue("insert at pos 2");
        list.removeElementFromValue("3");
        list.stdoutDisplay();
    }
}
