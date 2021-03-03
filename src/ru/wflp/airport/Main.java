package ru.wflp.airport;

import java.util.*;

/**
 *
 * Задание 5.0.4 Аэропорт
 *
 * У вас есть список описаний багажа, в виде набора данных - наименование перевозчика,
 * наименование класса перелета, предельно допустимый вес багажа.
 * 1. Ваша задача - описать класс багажа, создать на его основе список из > 5 объектов.
 * Упорядочить список от самого легкого к самому тяжелому багажу, вывести список на экран.
 * 2. Далее - переупорядочить список, теперь сортировка должна произойти в зависимости от длины строки,
 * получаемой путем сложения названия перевозчика и названия класса перелета.
 * Сортировка должна быть выполнена от самого длинного названия к самому короткому.
 * В одном из случаев использовать анонимный класс, в одном - лямбду, на ваше усмотрение.
 *
 */

public class Main {

    public static void main(String[] args) {

        String[] airlines = {"AEROFLOT", "S7", "POBEDA", "URAL_AIRLINES", "UTAIR", "AZIMUTH", "ROSSIYA"};
        String[] flightClass = {"FIRST", "BUSINESS", "ECONOMY"};

        ArrayList<Luggage> listOfLuggage = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            listOfLuggage.add(new Luggage(airlines[(int) (Math.random() * 7)], flightClass[(int) (Math.random() * 3)], (int) (Math.random() * 15 + 10)));
        }

        System.out.println("Вывод п.1 (сортировка по макс.весу):");
        listOfLuggage.stream()
                .sorted(Luggage::compareTo)
                .forEach(System.out::println);


        System.out.println("Вывод п.2 (сортировка по длине названия авиакомпании + класса:");
        listOfLuggage.stream()
                .sorted(new Comparator<Luggage>() {
                    @Override
                    public int compare(Luggage l1, Luggage l2) {
                        if ((l1.airlineName + l1.flightClass).length() > (l2.airlineName + l2.flightClass).length())
                        return -1;
                        else if ((l1.airlineName + l1.flightClass).length() < (l2.airlineName + l2.flightClass).length())
                            return 1;
                        else return 0;
                    }
                })
                .forEach(System.out::println);
    }
}

