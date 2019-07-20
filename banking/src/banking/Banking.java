package banking;

import logger.Logger;
import logger.LoggerFactory;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Banking {

	//Main
	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		String cmd = new String("");
		Logger logger = LoggerFactory.getLogger();
		List<Compte> account = new ArrayList<Compte>(); //List of accounts

		logger.info("OUTPUT","\033[H\033[2J"); //Clear the console
		drawMenu();
		try {
			if(!cmd.equals("m"))	//We dont need delay if we leave the menu
				Thread.sleep(3000);	//delay
			}
			catch(InterruptedException e) {
			}

		do{
			logger.info("OUTPUT","\033[H\033[2J"); //Clear the console
			logger.info("OUTPUT", "Press \"n\" to create a new account\nPress \"l\" to list the accounts\nPress \"c\" to login\nPress \"q\" to exit\nWaiting for request :");
			cmd = sc.nextLine();
			logger.info("INPUT", cmd);

			switch(cmd) {

				case "n": //Create a new account
					newAccount(account);

				break;

				case "l": //List all the accounts
					listAccount(account);
				break;

				case "q": //Quit the banking program
					logger.info("OUTPUT", "Thank you for your visit !");
				break;

				case "c": //Trying to connect
					connect(account);
				break;

				default :
					logger.info("OUTPUT", "Invalid command, please try again.");
				break;
			}

			try {
				Thread.sleep(2000);	//delay
			}
			catch(InterruptedException e) {
			}

		}while (!cmd.equals("q"));
	}

	//Methods
	public static void listAccount(List<Compte> account) {

		Logger logger = LoggerFactory.getLogger();

		logger.info("PROGRAM","listAccount() called.");
		if (!account.isEmpty()) { //Si il y a au moins compte
			for(Compte temp : account)
				logger.info("OUTPUT",temp.getName());
		}
		else
			logger.info("OUTPUT","There is no account yet, please press \"n\" to create one.");
	}

	public static void newAccount(List<Compte> account) { //Create a new account

		Scanner sc = new Scanner(System.in);
		Logger logger = LoggerFactory.getLogger();
		String fullname="";
		int age = 0;
		boolean done = false;

		logger.info("PROGRAM","newAccount() called.");
		logger.info("OUTPUT","Please enter your full name [Jean Moule] :");
		fullname = sc.nextLine();
		for(Compte temp : account) {
			if(fullname.equals(temp.getName())) //If this account already exist
				done = true;
		}
		if(!done) {
			logger.info("INPUT", fullname);
			logger.info("OUTPUT", "Please enter your age :");

			while (!sc.hasNextInt() || (age = sc.nextInt()) < 18 || age > 99) {    //Try until an int is entered, between 18 and 99 years old
				logger.info("OUTPUT", "Note that you have to be between 18 and 99 years old to create an account\nPlease re-enter a correct age :");
				logger.error("INPUT", String.valueOf(age));
				sc.nextLine();
			}
			logger.info("INPUT", String.valueOf(age));
			account.add(new Compte(fullname, age));
			sc.nextLine(); // Empty buffer
			logger.info("OUTPUT", "Account created.");
		}
		else
			logger.info("OUTPUT", "The account \""+fullname+"\" already exist.\nPress\"c\" to connect.");
	}

	public static void connect(List<Compte> account) { //Ask for a valid account and connect

		Scanner sc = new Scanner(System.in);
		Logger logger = LoggerFactory.getLogger();
		String cmd = new String("");
		boolean firstDone = false;

		logger.info("PROGRAM","connect() called.");
		if (!account.isEmpty())	{	//At least one account needed

			logger.info("OUTPUT","What is your fullname identity ?");
			cmd = sc.nextLine();
			logger.info("INPUT", cmd);
			for(Compte temp : account) {
				if(temp.getName().equals(cmd)) { //If you are connected
					logger.info("OUTPUT", "Connected as "+ temp.getName() +" !");
					firstDone = true; //Connected
					do {
						logger.info("OUTPUT","\033[H\033[2J"); //Clear the console
						logger.info("OUTPUT", "Press \"i\" to get some information on your account\nPress \"t\" to transfer any amount\nPress \"d\" to deposit some money\nPress \"w\" to withdraw some money\nPress \"c\" to ask for a credit\nPress \"m\" to go back to the menu\nWaiting for request :");
						cmd = sc.nextLine();
						logger.info("INPUT", cmd);

						switch(cmd) {

							case "i":	//information on your account
								temp.recap();
							break;

							case "t":
								boolean secondDone = false;
								if(account.size()>=2) {
									logger.info("OUTPUT", "Please enter the name of the account you want to transfert money to : ");
									cmd = sc.nextLine();
									for(Compte temp2 : account) {
										if (temp2.getName().equals(cmd) && !temp.getName().equals(temp2.getName())) {
											temp.transfert(temp2);
											secondDone = true;
										}
									}
									if(!secondDone)	//If this account doesnt exist
										logger.info("OUTPUT", "There is no account called \""+cmd+"\".\nTransfert failed.");
								}
								else
									logger.info("OUTPUT", "There is only one account created.\nPlease create another account first.\nTransfert failed.");

							break;

							case "d":
								temp.deposit();
							break;

							case "w":
								temp.withdraw();
							break;

							case "c":
								temp.askForLoan();
							break;

							case "m":
								logger.info("OUTPUT", "Back to the Menu : ");
							break;

							default :
								logger.info("OUTPUT", "Invalid command, please try again.");
							break;
						}

						try {
							if(!cmd.equals("m"))	//We dont need delay if we leave the menu
								Thread.sleep(2000);	//delay
						}
						catch(InterruptedException e) {
						}

					}while (!cmd.equals("m"));
				}
			}
			if(!firstDone)
				logger.info("OUTPUT", "Account \""+cmd+"\" doesn't exist.");
		}
		else
			logger.info("OUTPUT", "There is no account yet, please press \"n\" to create a new one.");
	}
	//Graphics
	public static void drawMenu() {

		Logger logger = LoggerFactory.getLogger();
		logger.info("PROGRAM","drawMenu() called.");
		logger.info("OUTPUT",
				" /$$      /$$ /$$$$$$$$ /$$        /$$$$$$   /$$$$$$  /$$      /$$ /$$$$$$$$\n" +
				"| $$  /$ | $$| $$_____/| $$       /$$__  $$ /$$__  $$| $$$    /$$$| $$_____/\n" +
				"| $$ /$$$| $$| $$      | $$      | $$  \\__/| $$  \\ $$| $$$$  /$$$$| $$\n" +
				"| $$/$$ $$ $$| $$$$$   | $$      | $$      | $$  | $$| $$ $$/$$ $$| $$$$$\n" +
				"| $$$$_  $$$$| $$__/   | $$      | $$      | $$  | $$| $$  $$$| $$| $$__/\n" +
				"| $$$/ \\  $$$| $$      | $$      | $$    $$| $$  | $$| $$\\  $ | $$| $$\n" +
				"| $$/   \\  $$| $$$$$$$$| $$$$$$$$|  $$$$$$/|  $$$$$$/| $$ \\/  | $$| $$$$$$$$\n" +
				"|__/     \\__/|________/|________/ \\______/  \\______/ |__/     |__/|________/");

	}

}
