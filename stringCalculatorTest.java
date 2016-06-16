import static org.junit.Assert.*;

import javax.management.InstanceAlreadyExistsException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class stringCalculatorTest {
	String request;
	Calculator cal;
	@Before
	public void setUp() throws Exception {

cal=new Calculator();
	}

	@After
	public void tearDown() throws Exception {
	cal=null;
	}

	@Test
	public void emptyString() {

	cal.setString("");
	assertEquals(0, cal.getValue());
	}
	@Test
public void singleNumber()
{
cal.setString("5");

assertEquals(5, cal.getValue());

}
	@Test
public void sumTwoNumberswithseperatedcomma(){
	cal.setString("4,7");
assertEquals(11, cal.getValue());
	
}
	@Test
public void sumTwoNumbersperatedwithLine()
{
cal.setString("1\n"+"23");
assertEquals(24,cal.getValue());
}
	@Test
public void sumThreeNumbers()
{
	cal.setString("23,45,56");
	assertEquals(124, cal.getValue());
}

{

}
@Test
public void ignore()
{
	int ex=0;
cal.setString("2,4000,45");
assertEquals(47, cal.getValue());
}
@Test
public void NegativeNumber()
{
	boolean b=false;
cal.setString("-2");
try 
{
cal.ControlNegativeNumbers();
b=true;
}
catch(NegativeNumberException e)
{
	assertTrue(true);
}
finally {
if (b==true)assertTrue( false);
}
}
}
