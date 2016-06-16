import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;


public class Calculator {
String value;
int counter1=0;
ArrayList<String>lines =new ArrayList<String>();
int numberValue=0;
public void setString(String value)
{
this.value=value;	
}
public int getValue(){
	
counter1=0;
lines.clear();

try
{
	ControlNegativeNumbers();
}
catch(NegativeNumberException e)
{
	}
	// if the numbers are in seperated lines suchas
	//4
	//6
	if(counter1>1)
	{
		int ilkValue=Integer.parseInt(lines.get(0));
		int secondValue=Integer.parseInt(lines.get(1));
		numberValue=ilkValue+secondValue;
		
	}
	else
	{
	int counter=occurenceComma();
	if(counter==0 && !value.equals(""))
numberValue=Integer.parseInt(value);
	
if(counter==1 && !value.equals("") && counter1==1){
	value=value.replace(" ", "");
	int index=value.indexOf(',');
	int ilkValue=Integer.parseInt(value.substring(0, index))>1000?0:Integer.parseInt(value.substring(0, index));
	int ikinciValue=Integer.parseInt(value.substring(index+1,value.length()))>1000?0:Integer.parseInt(value.substring(index+1,value.length()));	
	numberValue=ilkValue+ikinciValue;

}
else if(counter==2 && !value.equals("")&&counter1==1)
{
int index=value.indexOf(',');
int ilkValue=Integer.parseInt(value.substring(0, index));
if(ilkValue>1000)ilkValue=0;

int index1=value.indexOf(',',index+1);
int ikinciValue=Integer.parseInt(value.substring(index+1, index1));
if(ikinciValue>1000)ikinciValue=0;

int ucuncuValue=Integer.parseInt(value.substring(index1+1,value.length()));
if(ucuncuValue>1000)ucuncuValue=0;
numberValue=ilkValue+ikinciValue+ucuncuValue;
}
	}
	
return	numberValue;
}

public int occurenceComma()
{
	int counter=0;
for (int a=0;a<value.length();a++)
{
if (value.charAt(a)==',')counter++;

}
return counter;
}

public void ControlNegativeNumbers() throws NegativeNumberException
{
BufferedReader bf=new BufferedReader(new StringReader(value));

try
{
	String line=bf.readLine();

while(line!=null)
{
	lines.add(line);
	counter1++;
int counter=occurenceComma();
if(counter==1)
{
int index=value.indexOf(',');
int num=Integer.parseInt(value.substring(0,index));
if(num<0)throw new NegativeNumberException(value,"this is negative");
num=Integer.parseInt(value.substring(index+1,value.length()));
if(num<0)throw new NegativeNumberException(value,"this is negative");
}
else if(counter==2)
{int index=value.indexOf(',');
int num=Integer.parseInt(value.substring(0,index));
if(num<0)throw new NegativeNumberException(value,"this is negative");
int index1=value.indexOf(',',index+1);
num=Integer.parseInt(value.substring(index+1,index1));
if(num<0)throw new NegativeNumberException(value,"this is negative");

num=Integer.parseInt(value.substring(index1+1, value.length()));
if(num<0)throw new NegativeNumberException(value,"this is negative");	
}
else if(counter==0)
{
int number=Integer.parseInt(line);
if(number<0)throw new NegativeNumberException(value,"this is negative");
}
line=bf.readLine();	
}

}
catch(IOException e)
{
	}


}
}
