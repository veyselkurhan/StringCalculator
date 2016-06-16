
public class NegativeNumberException extends Exception {
	


	public NegativeNumberException(String s)
	{
		super(s);
	}
	public NegativeNumberException (String number, String detail) { 
        super(String.format("The number \"%s\" is negative: %s", number, detail));
	}
}
