package genericCheckpointing.server;

import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;

public interface StoreI {

	void writeObj(MyAllTypesFirst myFirst, int i, String string);

	void writeObj(MyAllTypesSecond mySecond, int i, String string);

}
