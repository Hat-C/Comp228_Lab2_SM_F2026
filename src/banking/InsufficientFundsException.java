package banking;
/**
 * @author Shannon Munroe
 * @date October 3rd 2026
 */

public class InsufficientFundsException extends Exception {
	public InsufficientFundsException(String err) { super(err); }
}
