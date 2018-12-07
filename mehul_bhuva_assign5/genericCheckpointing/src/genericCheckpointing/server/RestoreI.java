package genericCheckpointing.server;

import genericCheckpointing.util.SerializableObject;

public interface RestoreI {

	SerializableObject readObj(String string);

}
