package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

import genericCheckpointing.util.FileDisplayInterface;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.Result;
import genericCheckpointing.util.SerStrategy;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.XMLSerialization;

public class StoreRestoreHandler implements InvocationHandler {
	FileDisplayInterface ResultObject = new Result();
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		//System.out.println(arg2[1]);
		//System.out.println(arg1.getName());
		
		if(arg1.getName().toString() == "writeObj")
		{
			ResultObject.FileInitializer((String) arg2[3]);
			if(arg2[2] == "XML")
			{
				serializeData((SerializableObject) arg2[0],new XMLSerialization(),ResultObject);
				
			}
		}
		if(arg1.getName().toString() =="readObj")
		{
			FileProcessor readFileobject = new FileProcessor((String)arg2[1]);
			if(arg2[0] == "XML")
			{
				//System.out.println(arg2[1]);
				return deserializeData(new XMLSerialization(),readFileobject);
				
			}
		}
		return null;
	}
	 // if the method is write
    // if the wireFormat is XML
        //  call serializeData(args[0], new XMLSerializationStrategy());

 // if statements to check if it is the read method so that
 // deserialization can be done ... }

public void serializeData(SerializableObject sObject, SerStrategy sStrategy, FileDisplayInterface resultObject2) {
           sStrategy.processInput(sObject, resultObject2);
 }

public ArrayList<SerializableObject> deserializeData(SerStrategy sStrategy, FileProcessor resultString) {
    return sStrategy.processInput(resultString);
}

}
