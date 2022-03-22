package com.mogilan.homework;

/*Домашнее задание
Представить в виде классов и их композиции следующую модель.
- Каждый дом содержит свой номер (int), и множество этажей (массив).
- Каждый этаж содержит номер этажа (int), и множество квартир (массив).
- Каждая квартира содержит свой номер (int), и множество комнат (массив).
- Каждая комната содержит поле проходная она или нет (boolean).

В каждом классе реализовать метод print, который на консоль выводит информацию об объекте
(должны присутствовать все поля объекта!).
Например, метод print класса этаж должен выводить на консоль:
“Этаж 2, количество квартир 18”
Создание всех объектов вынести в отдельный класс с методом main.
Там же реализовать метод printAllInformation, который на вход принимает объект типа дом, и выводит
информацию о нем, его этажах, квартирах и комнатах, вызывая методы print.*/

public class HomeBuilder {

    public static void main(String[] args) {
        House newHouse = buildHouse(19);
        System.out.println();
        printAllInformation (newHouse);
    }

    public static House buildHouse () {
        return new House();
    }
    public static House buildHouse (int houseNumber) {
        return new House(houseNumber);
    }

    public static void printAllInformation (House house) {
        house.print();
        Floor [] floors = house.getFloors();
        for (int i = 0; i < floors.length; i++) {
            floors[i].print();
            Flat [] flats = floors[i].getFlats();
            for (int j = 0; j < flats.length; j++) {
                flats[j].print();
                Room [] rooms = flats[j].getRooms();
                for (int k = 0; k < rooms.length; k++) {
                    rooms[k].print();
                }
                System.out.println();
            }

        }
    }

}
