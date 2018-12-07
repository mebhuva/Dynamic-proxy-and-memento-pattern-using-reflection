package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import genericCheckpointing.util.SerStrategy;
import genericCheckpointing.util.SerializableObject;

public class StoreRestoreHandler implements InvocationHandler {

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	 // if the method is write
    // if the wireFormat is XML
        //  call serializeData(args[0], new XMLSerializationStrategy());

 // if statements to check if it is the read method so that
 // deserialization can be done ... }

public void serializeData(SerializableObject sObject, SerStrategy sStrategy) {
           sStrategy.processInput(sObject);
 }

}
