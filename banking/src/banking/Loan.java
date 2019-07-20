package banking;

import logger.Logger;
import logger.LoggerFactory;

public class Loan {

	private float rate;
	private int duration;
	private float balance;
	private Logger logger = LoggerFactory.getLogger();

	//Constructor
	Loan(float rate, int duration, float balance) {
		this.rate = (float)Math.round(rate/100)/100;
		this.duration = duration;
		this.balance = (float)Math.round(balance*100)/100;
	}

	//Getters
	public float getRate(){
		logger.info("PROGRAM","getRate() called : "+String.valueOf(rate));
		return rate;
	}

	public int getDuration(){
		logger.info("PROGRAM","getDuration() called : "+String.valueOf(duration));
		return duration;
	}

	public float getBalance(){
		logger.info("PROGRAM","getBalance() called : "+String.valueOf(balance));
		return balance;
	}

}