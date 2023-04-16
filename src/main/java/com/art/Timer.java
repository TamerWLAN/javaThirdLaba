package com.art;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * класс таймер, позволяющий сравнивать временнУю эффеткивность arrayList и linkedList
 * для таких операций как remove, get, set, add
 * сравнине происходит на amount итерациях
 * @author Artem Kozlitin
 * @version 1.1
 * @since 1.0
 */
class Timer {
    /** Реализация списка через arrayList, для последующего сравнения эффективности*/
    private List<Integer> arrayList;
    /** Реализация списка через linkedList, для последующего сравнения эффективности*/
    private List<Integer> linkedList;
    /** Количество итераций для засекания времени*/
    final private Integer amount;

    /**
     * Конструктор класса, в нем происходит инициализация двух реализация списка
     * и количества итераций
     * @param amount количество итераций, заданное пользователем
     */
    public Timer(final int amount) {
        this.amount = amount;
        this.arrayList = new ArrayList();
        this.linkedList = new LinkedList();
    }

    /**
     * Метод поочередно запускающий тесты для каждой операции
     * сохраняющий результаты тестирования в общую строковую переменную
     * @return результаты четырёх проведенных временнЫх тестов
     */
    final public String testAll() {
        String res = "";

        res += testOperation("add") + "\n";
        res += testOperation("remove") + "\n";
        res += testOperation("get") + "\n";
        res += testOperation("set") + "\n";

        return res;
    }

    /**
     * Универсальный метод, позволяющий засечь время для arrayList и linkedList
     * в любой из выбранных операций (remove, get, set, add)
     * если заданной операции нет в списке достуных, вызываем ошибку времени выполнения
     * для remove get set списки очищаются и инициализируются рандомныи значениями
     * для add списки реинициализируются
     *
     * при операции remove удалиние происходит из середины списка
     * @param operation операция для которой засекаем время выполнения
     * @return строка содержащая информацию о результатах замеров времени
     */
    final public String testOperation(String operation) {
        switch (operation) {
            case "remove", "get", "set" -> fillArrays();
            case "add" -> reinitArrays();
            default -> throw new RuntimeException("Invalid operation");
        }

        long timeArray;
        long timeLinked;

        timeArray = System.nanoTime();
        for(int i = 0; i < amount; i++) {
            switch (operation) {
                case "remove" -> arrayList.remove(arrayList.size() / 2);
                case "add" -> arrayList.add(i);
                case "get" -> {
                    int tmp = arrayList.get(i);
                }
                case "set" -> arrayList.set(i, i - 356);
            }
        }
        timeArray = System.nanoTime() - timeArray;

        timeLinked = System.nanoTime();
        for(int i = 0; i < amount; i++) {
            switch (operation) {
                case "remove" -> linkedList.remove(linkedList.size() / 2);
                case "add" -> linkedList.add(i);
                case "get" -> {
                    int tmp = linkedList.get(i);
                }
                case "set" -> linkedList.set(i, i - 356);
            }
        }
        timeLinked = System.nanoTime() - timeLinked;

        return "Testing method: " + operation + ". On iterations amount: " + amount
                + "\narrayList: " + timeArray + " nano sec. " + " linkedList: " + timeLinked + " nano sec.";
    }

    /**
     * Функция заполняющая списки amount рандомных чисел
     */
    private void fillArrays() {
        Integer tmp;

        reinitArrays();

        for(int i = 0; i < amount; i++) {
            tmp = (int) (Math.random() * (1000 + 100)) + 1000;
            arrayList.add(tmp);
            linkedList.add(tmp);
        }
    }

    /**
     * Функция реинициализирующая списки
     */
    private void reinitArrays() {
        arrayList = new ArrayList();
        linkedList = new LinkedList();
    }

    public int getListsSize() {
        return arrayList.size();
    }

}

