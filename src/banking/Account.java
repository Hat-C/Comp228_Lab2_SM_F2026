package banking;
/**
 * @author Shannon Munroe
 * @date October 3rd 2026
 */

public class Account {
	String account_number;
	double account_balance;
	String account_holder_name;
	Account(String ac_num, String ac_name, double ac_bal) {
		if(ac_name.length()==0) {
			throw new StringIndexOutOfBoundsException("account holder's name cannot be left blank");
		} else if(ac_num.length()!=9) {
			throw new StringIndexOutOfBoundsException("account number must be 9 digits");
		} else {
			this.account_holder_name = ac_name;
			try {
				Integer.parseInt(ac_num);
				this.account_number = ac_num;
				this.account_balance = ac_bal+1/(ac_bal<0?0:1)-1; //forces a divide by 0 error if inputted balance less that 0, the exception doesn't work on doubles or floats
			} catch(NumberFormatException e) {
				throw new NumberFormatException("account number cannot contain non-numeric characters");
			} catch(ArithmeticException e) {
				throw new ArithmeticException("account balance cannot be negative");
			} catch(NullPointerException e) {
				throw new ArithmeticException("missing variable");
			}
		}
	}
	void balanceChange(double change_amount) {
		account_balance += change_amount;
	}
	void deposit(double add_balance) {
		if(add_balance>0.00) {
			this.account_balance += add_balance;
		} else {
			throw new RuntimeException("deposit must be a natural amount");
		}
	}
	void withdraw(double take_balance) throws InsufficientFundsException {
		if(take_balance>0.00) {
			if(take_balance<this.account_balance) {
				this.account_balance -= take_balance;
			} else {
				throw new InsufficientFundsException("cannot withdraw more than account balance");
			}
		} else {
			throw new RuntimeException("withdraw must be a natural amount");
		}
	}
	
	@Override
	public String toString() {
		return String.format("account number: %s\nname of holder: %s\nbalance: %.2f", this.account_number, this.account_holder_name, this.account_balance);
	}
}
