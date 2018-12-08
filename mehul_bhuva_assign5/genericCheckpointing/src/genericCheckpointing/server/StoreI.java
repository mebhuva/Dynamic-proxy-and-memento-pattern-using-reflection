package genericCheckpointing.server;

import genericCheckpointing.util.SerializableObject;

public interface StoreI extends StoreRestoreI {

	void writeObj(SerializableObject myAllTypes, int i, String string, String args);

}
