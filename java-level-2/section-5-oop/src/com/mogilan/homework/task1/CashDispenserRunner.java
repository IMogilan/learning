package com.mogilan.homework.task1;

public class CashDispenserRunner {
    public static void main(String[] args) {
        CashDispenser cashDispenser = new CashDispenser(1,1, 4);
        cashDispenser.printCurrentStatus();
        cashDispenser.addBills(3, 6, 0);
        cashDispenser.printCurrentStatus();
        cashDispenser.withdrawMoney(520);
        cashDispenser.printCurrentStatus();
    }
}
