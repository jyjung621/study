package p06.user_exception;

public class BalanceInsufficientException extends Exception {
	public BalanceInsufficientException() {}
	public BalanceInsufficientException(String message)
	{
		super(message);
	}
}
