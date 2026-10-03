package banking;
import java.util.Scanner;
/**
 * @author Shannon Munroe
 * @date October 3rd 2026
 */

public class MainDriver {
	public static void main(String[] args) {
		Account[] accounts = new Account[3];
		Scanner inp = new Scanner(System.in);
		String acc_num;
		String acc_name;
		double acc_bal;
		for(int i=0; i<accounts.length; i++) {
			acc_num = ""; acc_name=""; acc_bal=-1;
			System.out.println("\naccount holder's name: ");
			acc_name = inp.next();
			System.out.println("account number (9 digits): ");
			acc_num = inp.next();
			System.out.println("account balance: ");
			try {
				acc_bal = inp.nextDouble();
			} catch(Exception e) {}
			try {
				Integer.parseInt(acc_num);
				accounts[i] = new Account(acc_num, acc_name, acc_bal);
				++i;
				System.out.println("account successfully created");
			} catch(NumberFormatException e) {
				System.out.println("account number cannot contain non-numeric characters");
			} catch(ArithmeticException e) {
				System.out.println("account balance cannot be negative");
			} catch(StringIndexOutOfBoundsException e) {
				if(acc_name.length()==0) {
				System.out.println("account holder's name cannot be left blank");
				} else { System.out.println("account number must be 9 digits"); }
			} catch(NullPointerException e) {
				System.out.println("invalid input");
			} catch(Exception e) {
				System.out.println("account creation failed");
			}
			--i;
		}
		inp.close();
		for(int i=0; i<accounts.length; i++) {
			System.out.println(i+")\n"+accounts[i]);
		}
		System.out.println("");
		System.out.println("deposit -2.00");
		try {
			accounts[0].deposit(-2.00);
		} catch(RuntimeException e) {
			System.out.println("amount must be a natural number");
		} finally {
			System.out.println("transaction finished");
		}
		System.out.println("withdraw 999999.99");
		try {
			accounts[0].withdraw(999999.99);
		} catch(InsufficientFundsException e) {
			System.out.println("insufficent funds");
		} catch(RuntimeException e) {
			System.out.println("amount must be a natural number");
		} finally {
			System.out.println("transaction finished");
		}
		System.out.println("deposit 2.00");
		try {
			accounts[1].deposit(2.00);
		} catch(RuntimeException e) {
			System.out.println("amount must be a natural number");
		} finally {
			System.out.println("transaction finished");
		}
		System.out.println("withdraw 2.00");
		try {
			accounts[1].withdraw(2.00);
		} catch(InsufficientFundsException e) {
			System.out.println("insufficent funds");
		} catch(RuntimeException e) {
			System.out.println("amount must be a natural number");
		} finally {
			System.out.println("transaction finished");
		}
		System.out.println("deposit 0.00");
		try {
			accounts[2].deposit(0.00);
		} catch(RuntimeException e) {
			System.out.println("amount must be a natural number");
		} finally {
			System.out.println("transaction finished");
		}
		System.out.println("withdraw -2.00");
		try {
			accounts[2].withdraw(-2.00);
		} catch(InsufficientFundsException e) {
			System.out.println("insufficent funds");
		} catch(RuntimeException e) {
			System.out.println("amount must be a natural number");
		} finally {
			System.out.println("transaction finished");
		}
	}
}
