package com.mogilan.homework.task1;
/*Создать класс, описывающий банкомат.
Банкомат задается тремя свойствами:
- количеством купюр номиналом 20, 50 и 100.
Сделать методы для добавления денег в банкомат.
Сделать метод, снимающий деньги: он принимает сумму денег, а возвращает булево значение - успешность выполнения операции.
При снятии денег метод должен распечатывать каким количеством купюр какого номинала выдаётся сумма.
Создать конструктор с тремя параметрами - количеством купюр каждого номинала.*/

public class CashDispenser {
    private int TotalAmountOfHundreds, TotalAmountOfFifties,TotalAmountOfTwenties;
    private static final int HUNDREDS_NOMINAL = 100;
    private static final int FIFTIES_NOMINAL = 50;
    private static final int TWENTIES_NOMINAL = 20;

    public CashDispenser() {}

    public CashDispenser(int InitialAmountOfHundreds, int InitialAmountOfFifties, int InitialAmountOfTwenties) {
        this.TotalAmountOfHundreds = InitialAmountOfHundreds;
        this.TotalAmountOfFifties = InitialAmountOfFifties;
        this.TotalAmountOfTwenties = InitialAmountOfTwenties;
    }

    public void addBillsOfTwenties(int additionAmountOfBills) {
        TotalAmountOfTwenties += additionAmountOfBills;
    }
    public void addBillsOfFifties(int additionAmountOfBills) {
        TotalAmountOfFifties += additionAmountOfBills;
    }
    public void addBillsOfHundreds(int additionAmountOfBills) {
        TotalAmountOfHundreds += additionAmountOfBills;
    }
    public void addBills(int additionAmountOfHundreds, int additionAmountOfFifties,int additionAmountOfTwenties) {
        addBillsOfHundreds(additionAmountOfHundreds);
        addBillsOfFifties(additionAmountOfFifties);
        addBillsOfTwenties(additionAmountOfTwenties);
    }

    public boolean withdrawBillsOfHundreds(int amountOfBills) {
        if (TotalAmountOfHundreds >= amountOfBills) {
            TotalAmountOfHundreds -= amountOfBills;
            return true;
        } else return false;
    }
    public boolean withdrawBillsOfFifties(int amountOfBills) {
        if (TotalAmountOfFifties >= amountOfBills) {
            TotalAmountOfFifties -= amountOfBills;
            return true;
        } else return false;
    }
    public boolean withdrawBillsOfTwenties(int amountOfBills) {
        if (TotalAmountOfTwenties >= amountOfBills) {
            TotalAmountOfTwenties -= amountOfBills;
            return true;
        } else return false;
    }

    public boolean withdrawMoney (int amount) {
        int billsOfTwentiesForWithdraw = 0, billsOfFiftiesForWithdraw = 0, billsOfHundredsForWithdraw = 0;
        if (TotalAmountOfHundreds > 0) {
            billsOfHundredsForWithdraw = Math.min(amount / HUNDREDS_NOMINAL, TotalAmountOfHundreds);
            amount -= billsOfHundredsForWithdraw * HUNDREDS_NOMINAL; 
        }
        if (TotalAmountOfFifties > 0) {
            billsOfFiftiesForWithdraw = Math.min(amount / FIFTIES_NOMINAL, TotalAmountOfFifties);
            amount -= billsOfFiftiesForWithdraw * FIFTIES_NOMINAL;
            /* Checking if non withdrawing of one bill of 50 helps to withdraw all amount.
               For instance if wee have:
             - 3 bill of 20 and
             - 1 bill of 50 and
             - the required amount if 60,
              if we withdraw 1 bill of 50 the remaining amount will be 10 (we will not be able to withdraw it).
              But if will not withdraw 1 bill of 50 we will not be able to withdraw 3 bill of 20 (60) */
            if ((billsOfFiftiesForWithdraw > 0) &&
                    (amount > 0) &&
                            (amount % TWENTIES_NOMINAL != 0) &&
                                   (TotalAmountOfTwenties >= 3) &&
                                        ((amount + FIFTIES_NOMINAL) % TWENTIES_NOMINAL == 0)) {
                amount += FIFTIES_NOMINAL;
                billsOfFiftiesForWithdraw -= 1;
            }
        }
        if (TotalAmountOfTwenties > 0) {
            billsOfTwentiesForWithdraw = Math.min(amount / TWENTIES_NOMINAL, TotalAmountOfTwenties);
            amount -= billsOfTwentiesForWithdraw * TWENTIES_NOMINAL;
        }
        if (amount != 0) {
            System.out.println("There are no such banknotes. Only banknotes 20, 50 and 100 are available.");
            return false;
        } else {
            System.out.printf("The amount was withdrawn from the ATM in the following banknotes: billsOfHundreds = %d, billsOfFifties = %d, billsOfTwenties = %d\n",
                    billsOfHundredsForWithdraw, billsOfFiftiesForWithdraw, billsOfTwentiesForWithdraw);
            withdrawBillsOfHundreds(billsOfHundredsForWithdraw);
            withdrawBillsOfFifties(billsOfFiftiesForWithdraw);
            withdrawBillsOfTwenties(billsOfTwentiesForWithdraw);
            return true;
        }
    }
    
    public void printCurrentStatus() {
        System.out.printf("In the ATM following banknotes are available: billsOfHundreds = %d, billsOfFifties = %d, billsOfTwenties = %d\n",
                TotalAmountOfHundreds, TotalAmountOfFifties, TotalAmountOfTwenties);
    }
}
