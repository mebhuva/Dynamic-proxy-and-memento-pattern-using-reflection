
package genericCheckpointing.driver;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.FileDisplayInterface;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.Result;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

// import the other types used in this file

public class Driver {

	public static void main(String[] args) throws InterruptedException {

		// FIXME: read the value of checkpointFile from the command line

		/*
		 * As the build.xml specifies the arguments as argX, in case the argument value
		 * is not given java takes the default value specified in build.xml. To avoid
		 * that, below condition is used
		 */
		if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {

			System.err.println("Invalid arguments specified");
			System.err.println(
					"Command : ant -buildfile build.xml run -Darg0=mode -Darg1=NUM_OF_OBJECTS -Darg2=checkpoint.txt");
			System.err
					.println("DEBUG_LEVEL : 0 - None, 1 - CONSTRUCTOR , 2 - EXCEPTION , 3 - STATECHANGE, 4 -  RESULT");
			System.exit(0);
		} else {
			if (!isInteger(args[1])) {
				System.err.println("NUM_OF_OBJECTS Value should be a number");
				System.err.println(
						"DEBUG_LEVEL : 0 - None, 1 - CONSTRUCTOR , 2 - EXCEPTION , 3 - STATECHANGE, 4 -  RESULT");
				System.exit(0);
			} else {
				FileDisplayInterface ResultsObject = new Result();
				Random rnd = new Random();

				SerializableObject myFirst;
				SerializableObject mySecond;
				ArrayList<SerializableObject> SerializableObjectList = new ArrayList<>();
				ProxyCreator pc = new ProxyCreator();

				// create an instance of StoreRestoreHandler (which implements
				// the InvocationHandler

				// create a proxy
				StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(new Class[] { StoreI.class, RestoreI.class },
						new StoreRestoreHandler());

				// FIXME: invoke a method on the handler instance to set the file name for
				// checkpointFile and open the file


				// Use an if/switch to proceed according to the command line argument
				// For deser, just deserliaze the input file into the data structure and then
				// print the objects
				// The code below is for "serdeser" mode
				// For "serdeser" mode, both the serialize and deserialize functionality should
				// be called.

				// create a data structure to store the objects being serialized
				// NUM_OF_OBJECTS refers to the count for each of MyAllTypesFirst and
				// MyAllTypesSecond
				// passed as "N" from the command line.
				int NUM_OF_OBJECTS = Integer.parseInt(args[1]);
				for (int i = 0; i < NUM_OF_OBJECTS; i++) {

					// FIXME: create these object instances correctly using an explicit value
					// constructor
					// use the index variable of this loop to change the values of the arguments to
					// these constructors
					//System.out.println(Math. random() * 100 + 11);
					myFirst = new MyAllTypesFirst((int )(Math.random() *100 + 11),(long )(Math.random() *100 + 11),"My MATF String Number is "+(Math.random() *100 + 11),(Math.random() > .5),(int )(Math.random() *100 + 11));
					mySecond = new MyAllTypesSecond((double )(Math.random() *100 + 11),(float)(Math.random() *100 + 11),(short)(Math.random() *100 + 11),(char) (rnd.nextInt(26) + 'a'));
					SerializableObjectList.add(myFirst);
					SerializableObjectList.add(mySecond);
					// FIXME: store myFirst and mySecond in the data structure
					// authID (13 and 17) is not being used in the assignment, but
					// is left for future use.
					((StoreI) cpointRef).writeObj(myFirst, rnd.nextInt(9998) + 1, "XML",args[2]);
					((StoreI) cpointRef).writeObj(mySecond, rnd.nextInt(9996) + 3, "XML",args[2]);

				}
				//SerializableObject myRecordRet;
				ArrayList<SerializableObject> myRecordRet = new ArrayList<>();
				
				
				
				// create a data structure to store the returned ojects
				//Thread.sleep(1000);
				String fileLine;
				
					myRecordRet = ((RestoreI) cpointRef).readObj("XML",args[2]);
				
					
					int noofdismatch = 0;
					
					for(int i=0;i<SerializableObjectList.size();i++)
					{
						for(int j =i;j<myRecordRet.size();j++)
						{
							if(!(SerializableObjectList.get(i).equals(myRecordRet.get(j))))
							{
								noofdismatch = noofdismatch +1;;
							}
						}
					}
					
					
					System.out.println("SerializableObjectList");
					for(int l =0;l<SerializableObjectList.size();l++)
					{
						System.out.println(SerializableObjectList.get(l).toString());
					}
					System.out.println("ReturnList");
					for(int k =0;k<myRecordRet.size();k++)
					{
						System.out.println(myRecordRet.get(k).toString());
					}
					
					// FIXME: store myRecordRet in the vector (or arrayList)
				

				// FIXME: invoke a method on the handler to close the file (if it hasn't already
				// been closed)

				// FIXME: compare and confirm that the serialized and deserialzed objects are
				// equal.
				// The comparison should use the equals and hashCode methods. Note that hashCode
				// is used for key-value based data structures

				// FIXME
				// Create an instance of the PrimeVisitorImpl and use it to determine the number
				// of unique integers in all the instances of MyAllTypesFirst and
				// MyAllTypesSecond

				// FIXME
				// Create an instance of the PalindromeVisitorImpl and use it to determine the
				// number of unique integers in all the instances of MyAllTypesFirst and
				// MyAllTypesSecond
			}

		}
	}

	
	
	/**
	 * isInteger check if string is integer or not
	 * 
	 * @param str
	 * @return
	 */
	private static boolean isInteger(String str) {
		try {
			int i = Integer.parseInt(str);
			return true;
		} catch (NumberFormatException er) {
			return false;
		} finally {

		}

	}

}