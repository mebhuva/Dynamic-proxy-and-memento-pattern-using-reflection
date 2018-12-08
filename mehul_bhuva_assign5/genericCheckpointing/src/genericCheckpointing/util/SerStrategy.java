package genericCheckpointing.util;

public interface SerStrategy {
	void processInput(SerializableObject sObject, FileDisplayInterface fileObject);
}
