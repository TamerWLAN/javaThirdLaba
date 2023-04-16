package com.art;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Timer {
    final private List<Integer> arrayList;
    final private List<Integer> linkedList;
    final private Integer amount;
    public Timer(final int amount) {
        this.amount = amount;
        this.arrayList = new ArrayList();
        this.linkedList = new LinkedList();
    }

    final public String testAll() {
        String res = "";
        res += testOperation("remove") + "\n";
        res += testOperation("get") + "\n";
        res += testOperation("set") + "\n";
        res += testOperation("add") + "\n";

        return res;
    }

    final public String testOperation(String operation) {
        switch (operation) {
            case "remove", "get", "set" -> fillArrays();
            case "add" -> clearArrays();
            default -> throw new RuntimeException("Invalid operation");
        }

        long timeArray;
        long timeLinked;

        timeArray = System.nanoTime();

        for(int i = 0; i < amount; i++) {
            switch (operation) {
                case "remove" -> arrayList.remove(arrayList.size() / 2);
                case "add" -> {
                    clearArrays();
                    arrayList.add(i);
                }
                case "get" -> {
                    int tmp = arrayList.get(arrayList.size() / 2);
                }
                case "set" -> arrayList.set(i, i - 356);
            }
        }
        timeArray = System.nanoTime() - timeArray;

        timeLinked = System.nanoTime();
        for(int i = 0; i < amount; i++) {
            switch (operation) {
                case "remove" -> linkedList.remove(linkedList.size() / 2);
                case "add" -> {
                    clearArrays();
                    linkedList.add(i);
                }
                case "get" -> {
                    int tmp = linkedList.get(linkedList.size() / 2);
                }
                case "set" -> linkedList.set(i, i - 356);
            }
        }
        timeLinked = System.nanoTime() - timeLinked;

        return "Testing method: " + operation + ". On iterations amount: " + amount
                + "\narrayList: " + timeArray + " nano sec. " + " linkedList: " + timeLinked + " nano sec.";
    }

    private void fillArrays() {
        Integer tmp;

        clearArrays();

        for(int i=0;i<amount;i++) {
            tmp = (int) (Math.random() * (1000+100)) + 1000;
            arrayList.add(tmp);
            linkedList.add(tmp);
        }
    }

    private void clearArrays() {
        if(!arrayList.isEmpty() || !linkedList.isEmpty()) {
            arrayList.clear();
            linkedList.clear();
        }
    }

    public int getListsSize() {
        return arrayList.size();
    }

}

