package genericCheckpointing.util;

public class SerializeTypes {
	public String serializeInt(int value, String tagName)
	{
		String returnString =  "		<"+tagName+" xsi:type=\"xsd:int\">"+value+"</"+tagName+">";
		return returnString;
		
	}
	
	public String serializelong(long value, String tagName)
	{
		String returnString =  "		<"+tagName+" xsi:type=\"xsd:long\">"+value+"</"+tagName+">";
		return returnString;
		
	}
	public String serializeString(String value, String tagName)
	{
		String returnString =  "		<"+tagName+" xsi:type=\"xsd:String\">"+value+"</"+tagName+">";
		return returnString;
		
	}
	public String serializeboolean(boolean value, String tagName)
	{
		String returnString =  "		<"+tagName+" xsi:type=\"xsd:boolean\">"+value+"</"+tagName+">";
		return returnString;
		
	}
	public String serializedouble(double value, String tagName)
	{
		String returnString =  "		<"+tagName+" xsi:type=\"xsd:double\">"+value+"</"+tagName+">";
		return returnString;
		
	}
	public String serializefloat(float value, String tagName)
	{
		String returnString =  "		<"+tagName+" xsi:type=\"xsd:float\">"+value+"</"+tagName+">";
		return returnString;
		
	}
	public String serializeshort(short value, String tagName)
	{
		String returnString =  "		<"+tagName+" xsi:type=\"xsd:short\">"+value+"</"+tagName+">";
		return returnString;
		
	}
	public String serializechar(char value, String tagName)
	{
		String returnString =  "		<"+tagName+" xsi:type=\"xsd:char\">"+value+"</"+tagName+">";
		return returnString;
		
	}
}
