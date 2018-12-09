package genericCheckpointing.server;

import java.util.ArrayList;

import genericCheckpointing.util.SerializableObject;

public interface RestoreI extends StoreRestoreI {

	ArrayList<SerializableObject> readObj(String string,String filename);

}
