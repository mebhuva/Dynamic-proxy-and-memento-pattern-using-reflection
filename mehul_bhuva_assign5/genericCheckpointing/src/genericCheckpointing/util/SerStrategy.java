package genericCheckpointing.util;

import java.util.ArrayList;

public interface SerStrategy {
	void processInput(SerializableObject sObject, FileDisplayInterface fileObject);

	ArrayList<SerializableObject> processInput(FileProcessor resultobject);
}
