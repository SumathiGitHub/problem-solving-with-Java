package com.practice.miniProjects;

import java.util.Scanner;

public class ATM {
	public static int balanceAmount = 30000;

	public static void main(String args[]) {
		System.out.println("Welcome to JSM Bank\n\n");
		System.out.println("Please Insert Your Card to continue.");
		Pin pin = new Pin();
		pin.enterPin();
		Menu menu = new Menu();
		menu.displayMenu();
	}

}

//class PIN
class Pin {

	public void enterPin() {
		int i;
		Scanner pinInput = new Scanner(System.in);
		for (i = 1; i < 4; i++) {
			System.out.println("Enter your 4 digit pin to contine **** ");
			int pinNo = pinInput.nextInt();
			if (pinNo == 1234) {
				System.out.println("Wait..your card details are being loaded...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			} else {
				System.out.println("Access denied!");
				if (i == 1) {
					System.out.println("You have 2 more chances left!");
				} else if (i == 2) {
					System.out.println("You have 1 more chance left!");
				}
			}
		}
		if (i == 4) {
			System.out.println("Sorry! You have exhausted your choices of entering PIN.");
			System.exit(0);
		}
	}
}

//class Menu
class Menu {

	public void displayMenu() {

		Scanner displayInput = new Scanner(System.in);
		while (true) {

			System.out.println("Please choose an option to continue ");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Exit");

			int choice = displayInput.nextInt();

			switch (choice) {
			case 1:
				BalanceCheck bl = new BalanceCheck();
				bl.checkBalance();
				break;

			case 2:
				Deposit d1 = new Deposit();
				d1.depositMoney();
				break;

			case 3:
				WithDraw w = new WithDraw();
				w.withdrawalMoney();
				break;

			case 4:
				System.out.println("Thank you for choosing JSM ATM. Goodbye!");
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}
}

//class BalanceCheck
class BalanceCheck {

	public int checkBalance() {
		System.out.println("Your Available Balance :: " + ATM.balanceAmount);
		return ATM.balanceAmount;
	}
}

//class Deposit
class Deposit {

	public void depositMoney() {
		System.out.println("Please enter the amount to deposit ::: ");
		Scanner sc = new Scanner(System.in);
		int depositAmount = sc.nextInt();
		System.out.println("Depositing....₹" + depositAmount);
		if (depositAmount < 100 || depositAmount % 100 != 0) {
			System.out.println("Deposit amount must be at least ₹100 and in multiples of ₹100!");
			return;
		}
		if (depositAmount <= 50000) {
			ATM.balanceAmount = ATM.balanceAmount + depositAmount;
		} else {
			System.out.println("Can't deposit more than ₹50000 in one transaction!");
			System.out.println("Kindly try with lower amount!");
		}
		System.out.println("Your updated balance is ::: " + ATM.balanceAmount);
	}
}

//class Withdrawal 
class WithDraw {

	public void withdrawalMoney() {

		System.out.println("Please enter the amount to withdraw ::: ");
		Scanner sc = new Scanner(System.in);
		int withdrawalAmount = sc.nextInt();
		System.out.println("Withdrawing... ₹" + withdrawalAmount);
		if (withdrawalAmount > 20000) {
			System.out.println("Limit is ₹20000 per day!");
			return;
		}
		if (withdrawalAmount < 500) {
			System.out.println("Minimum withdrawal amount is ₹500 ::: Sorry for your inconvenience!");
			return;
		}
		if (withdrawalAmount % 100 != 0) {
			System.out.println("Please enter amount in multiples of 100's!");
			return;
		}
		// else if (ATM.balanceAmount >= withdrawalAmount) {
		if (ATM.balanceAmount >= withdrawalAmount) {
			System.out.println("Transaction Successful!");
			ATM.balanceAmount = ATM.balanceAmount - withdrawalAmount;
			System.out.println("Your updated balance is ::: " + ATM.balanceAmount);
		}

		else {
			System.out.println("Insufficient Balance!");
			System.out.println("Your current balance is only ::: " + ATM.balanceAmount);
		}
	}
}