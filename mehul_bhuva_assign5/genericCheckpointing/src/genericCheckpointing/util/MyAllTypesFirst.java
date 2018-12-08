package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject{
public int myInt = 0;
public long myLong = 0;
public String myString = null;
public boolean myBool = false;
public int myOtherInt = 0;

public MyAllTypesFirst(int myInt, long myLong, String myString, boolean myBool, int myOtherInt) {
	super();
	this.myInt = myInt;
	this.myLong = myLong;
	this.myString = myString;
	this.myBool = myBool;
	this.myOtherInt = myOtherInt;
}

public int getMyInt() {
	return myInt;
}

public void setMyInt(int myInt) {
	this.myInt = myInt;
}

public long getMyLong() {
	return myLong;
}

public void setMyLong(long myLong) {
	this.myLong = myLong;
}

public String getMyString() {
	return myString;
}

public void setMyString(String myString) {
	this.myString = myString;
}

public boolean isMyBool() {
	return myBool;
}

public void setMyBool(boolean myBool) {
	this.myBool = myBool;
}

public int getMyOtherInt() {
	return myOtherInt;
}

public void setMyOtherInt(int myOtherInt) {
	this.myOtherInt = myOtherInt;
}



}
