package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import genericCheckpointing.util.FileDisplayInterface;
import genericCheckpointing.util.Result;
import genericCheckpointing.util.SerStrategy;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.XMLSerialization;

public class StoreRestoreHandler implements InvocationHandler {
	FileDisplayInterface ResultObject = new Result();
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		ResultObject.FileInitializer((String) arg2[3]);
		//System.out.println(arg2[1]);
		//System.out.println(arg1.getName());
		
		if(arg1.getName().toString() == "writeObj")
		{
			if(arg2[2] == "XML")
			{
				serializeData((SerializableObject) arg2[0],new XMLSerialization(),ResultObject);
				
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

}
