package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject{
public double myDouble = 0.0;
public float myFloat = 0.0f;
public short myShort = 0;
public char myChar = '\0';
public MyAllTypesSecond(double myDouble, float myFloat, short myShort, char mychar) {
	super();
	this.myDouble = myDouble;
	this.myFloat = myFloat;
	this.myShort = myShort;
	this.myChar = mychar;
}
public double getMyDouble() {
	return myDouble;
}
public void setMyDouble(double myDouble) {
	this.myDouble = myDouble;
}
public float getMyFloat() {
	return myFloat;
}
public void setMyFloat(float myFloat) {
	this.myFloat = myFloat;
}
public short getMyShort() {
	return myShort;
}
public void setMyShort(short myShort) {
	this.myShort = myShort;
}
public char getMyChar() {
	return myChar;
}
public void setMyChar(char mychar) {
	this.myChar = mychar;
}


}