package banking;

import logger.Logger;
import logger.LoggerFactory;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Compte{

	private List<Loan> loan = new ArrayList<Loan>(); //List of loans;
	private String l_name;
	private int l_age;
	private float l_balance = 0;
	private Logger logger = LoggerFactory.getLogger();

	//Constructor
	public Compte(String l_name, int l_age){
		this.l_name = l_name;
		this.l_age = l_age;
	}

	//Setters
	public void setName(String p_name){
		l_name = p_name;
		logger.info("PROGRAM","setName() called : "+l_name);
	}

	public void setAge(int p_age){
		l_age = p_age;
		logger.info("PROGRAM","setAge() called : "+String.valueOf(l_age));
	}

	public void setBalance(float p_balance){
		l_balance = (float)Math.round(p_balance*100)/100;
		logger.info("PROGRAM","setBalance() called : "+String.valueOf(l_balance));
	}

	//Getters
	public String getName(){
		logger.info("PROGRAM","getName() called : "+l_name);
		return l_name;
	}

	public int getAge(){
		logger.info("PROGRAM","getAge() called : "+String.valueOf(l_age));
		return l_age;
	}

	public float getBalance(){
		logger.info("PROGRAM","getBalance() called : "+String.valueOf(l_balance));
		return l_balance;
	}

	//Methods
	public void recap() {	//Recap of your account
		logger.info("PROGRAM","recap() called.");
		logger.info("OUTPUT", "Your name is : " + l_name + ". You are "+ String.valueOf(l_age) + ". Your balance is "+ String.valueOf(l_balance) + " euros.");
		if(!loan.isEmpty()) {
			logger.info("OUTPUT","You have " + loan.size() + " loan(s)");
			for(Loan temp : loan)
				logger.info("OUTPUT", "Amount : "+String.valueOf(temp.getBalance())+" Rate : "+String.valueOf(temp.getRate())+" Duration : "+String.valueOf(temp.getDuration()));

			try {	//We let more delay on this recap
				Thread.sleep(2000);	//delay
			}
			catch(InterruptedException e) {
			}
		}
	}

	public void deposit() {	//Deposit some money to your account

		Scanner sc = new Scanner(System.in);
		Logger logger = LoggerFactory.getLogger();
		float money = 0;

		logger.info("PROGRAM","deposit() called : "+l_name);
		logger.info("OUTPUT", "Please enter the amount of money you want to deposit :");
		while (!sc.hasNextFloat() || (money=sc.nextFloat())<0) {	//Try until a float is entered
			logger.info("OUTPUT", "Operation failed, You have to re-enter a correct amount of money :");
			logger.error("INPUT", String.valueOf(money));
			sc.nextLine();
		}
		sc.nextLine();	//Clean the buffer
		setBalance(getBalance() + money);
		logger.info("OUTPUT", "Operation suceed, now you have "+String.valueOf(getBalance())+" euros on your account.");
	}

	public void withdraw() {	//Withdraw some money from your account

		Scanner sc = new Scanner(System.in);
		Logger logger = LoggerFactory.getLogger();
		float money = 0;

		logger.info("PROGRAM","withdraw() called : "+l_name);
		if(l_balance==0) {    //Test if you have some money on your account
			logger.info("OUTPUT", "You have got no money on this account, please deposit some money first.");
		}
		else {
			logger.info("OUTPUT", "Please enter the amount of money you want to withdraw :");
			while (!sc.hasNextFloat() || (money = sc.nextFloat()) < 0 || (money > getBalance())) {    //Try until a float is entered

				logger.info("OUTPUT", "Operation failed, You have to re-enter a correct amount of money :");
				logger.error("INPUT", String.valueOf(money));
				sc.nextLine();    //Clean the buffer
			}
			sc.nextLine();    //Clean the buffer
			setBalance(getBalance() - money);
			logger.info("OUTPUT", "Operation suceed, now you have " + String.valueOf(getBalance()) + " euros on your account.");
		}
	}

	public void askForLoan() {

		Scanner sc = new Scanner(System.in);
		Logger logger = LoggerFactory.getLogger();
		float rate=0;
		int duration=0;
		float balance=0;

		logger.info("PROGRAM","askForLoan() called : "+l_name);
		if(l_age<70) //You have to be less than 70 years old first
			if(loan.size()<2) {

				logger.info("OUTPUT", "How much do you want to borrow ? (In euros)");
				while(!sc.hasNextFloat() || (balance = sc.nextFloat())<0) {
					logger.info("OUTPUT", "Incorrect amount of money. Please try again.");
					logger.info("INPUT", String.valueOf(balance));
					sc.nextLine();	//Clean the buffer
				}
				sc.nextLine();	//Clean the buffer

				logger.info("OUTPUT", "What would be the duration of your loan ? (In years)");
				while(!sc.hasNextInt() || (l_age+(duration = sc.nextInt()))>=70 || duration<0) {	//First test, you have to be less than 70 years old at the end of the loan
					logger.info("OUTPUT", "Incorrect duration, note that you have to be less than 70 at the end of your loan.\nPlease try again : ");
					logger.info("INPUT", String.valueOf(duration));
					sc.nextLine();	//Clean the buffer
				}
				sc.nextLine();	//Clean the buffer

				logger.info("OUTPUT", "What would be the rate ? (In percent)");
				while(!sc.hasNextFloat() || (rate = sc.nextFloat())<1) {
					logger.info("OUTPUT", "Incorrect rate, note that it has to be greater than 1 percent.\nThank you for your comprehension.");
					logger.info("INPUT", String.valueOf(rate));
					sc.nextLine();	//Clean the buffer
				}
				sc.nextLine();	//Clean the buffer

				loan.add(new Loan(rate, duration, balance));
				logger.info("OUTPUT", "Your loan has been created.");
			}
			else
				logger.info("OUTPUT", "There are more than two loans on your account, you can't borrow more.\nThank you for your comprehension.");
		else
			logger.info("OUTPUT", "You are "+ l_age + " years old, you can't borrow.\nThank you for your comprehension.");
	}

	public void transfert(Compte accountTo) {	//Transfert money from one account to another

		Scanner sc = new Scanner(System.in);
		Logger logger = LoggerFactory.getLogger();
		float money=0;

		logger.info("PROGRAM","transfert() called : "+l_name);
		if(l_balance==0) {
			logger.info("OUTPUT","You've got no money on this account, please deposit some money first.");
		}
		else {
			logger.info("OUTPUT", "What is the amount of money you want to transfert to "+ accountTo.getName()+" ?");
			while (!sc.hasNextFloat() || (money = sc.nextFloat()) < 0 || money > l_balance) {
				logger.info("OUTPUT", "Incorrect amount, Please try again :");
				logger.info("INPUT", String.valueOf(money));
				sc.nextLine();    //Clean the buffer
			}
			sc.nextLine();    //Clean the buffer
			setBalance(l_balance - money); //Substract from
			accountTo.setBalance(accountTo.getBalance() + money);    //Add to
			logger.info("OUTPUT", "Transfert succesfull, you have now " + l_balance + " euros on your account");
		}
	}

}
