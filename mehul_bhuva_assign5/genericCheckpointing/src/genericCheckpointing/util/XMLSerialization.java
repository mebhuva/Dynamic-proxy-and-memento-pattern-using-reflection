package genericCheckpointing.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;

public class XMLSerialization implements SerStrategy {
	@Override
	public void processInput(SerializableObject sObject,FileDisplayInterface FileName) {
		// TODO Auto-generated method stub
		Class<?> cls = sObject.getClass();
		XMLSerialization XMLSerializationobject = new XMLSerialization();
		SerializeTypes SerializeTypesObject = new SerializeTypes();
		 //System.out.println(cls.getName());
		 FileName.writeFile("<DPSerialization>");
		// System.out.println());
		// System.out.println(cls.getFields()[0]);
		 FileName.writeFile("    <complexType xsi:type=\""+cls.getName()+"\">");
		 
		for (int i = 0; i < cls.getFields().length; i++) {
			Object invokeRetValue = null;
			if (cls.getFields()[i].getType() == int.class) {
				try {
					invokeRetValue = XMLSerializationobject.callGetter(sObject, cls.getFields()[i].getName());
					FileName.writeFile(SerializeTypesObject.serializeInt((int)invokeRetValue, cls.getFields()[i].getName()));
					// System.out.println(invokeRetValue);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cls.getFields()[i].getType() == long.class) {
				try {
					invokeRetValue = XMLSerializationobject.callGetter(sObject, cls.getFields()[i].getName());
					FileName.writeFile(SerializeTypesObject.serializelong((long)invokeRetValue, cls.getFields()[i].getName()));
					//System.out.println(invokeRetValue);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cls.getFields()[i].getType() == String.class) {
				try {
					invokeRetValue = XMLSerializationobject.callGetter(sObject, cls.getFields()[i].getName());
					FileName.writeFile(SerializeTypesObject.serializeString((String)invokeRetValue, cls.getFields()[i].getName()));
					// System.out.println(invokeRetValue);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cls.getFields()[i].getType() == boolean.class) {
				try {
					invokeRetValue = XMLSerializationobject.callGetter(sObject, cls.getFields()[i].getName());
					FileName.writeFile(SerializeTypesObject.serializeboolean((boolean)invokeRetValue, cls.getFields()[i].getName()));
					// System.out.println(invokeRetValue);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cls.getFields()[i].getType() == double.class) {
				try {
					invokeRetValue = XMLSerializationobject.callGetter(sObject, cls.getFields()[i].getName());
					FileName.writeFile(SerializeTypesObject.serializedouble((double)invokeRetValue, cls.getFields()[i].getName()));
					// System.out.println(invokeRetValue);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cls.getFields()[i].getType() == float.class) {
				try {
					invokeRetValue = XMLSerializationobject.callGetter(sObject, cls.getFields()[i].getName());
					FileName.writeFile(SerializeTypesObject.serializefloat((float)invokeRetValue, cls.getFields()[i].getName()));
					// System.out.println(invokeRetValue);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cls.getFields()[i].getType() == short.class) {
				try {
					invokeRetValue = XMLSerializationobject.callGetter(sObject, cls.getFields()[i].getName());
					FileName.writeFile(SerializeTypesObject.serializefloat((short)invokeRetValue, cls.getFields()[i].getName()));
					// System.out.println(invokeRetValue);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cls.getFields()[i].getType() == char.class) {
				try {
					invokeRetValue = XMLSerializationobject.callGetter(sObject, cls.getFields()[i].getName());
					FileName.writeFile(SerializeTypesObject.serializechar((char)invokeRetValue, cls.getFields()[i].getName()));
					
					// System.out.println(invokeRetValue);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		FileName.writeFile("    </complexType>");
		FileName.writeFile("</DPSerialization>");
	}

	private void callSetter(Object obj, String fieldName, Object value) {
		PropertyDescriptor pd;
		try {
			pd = new PropertyDescriptor(fieldName, obj.getClass());
			pd.getWriteMethod().invoke(obj, value);
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Object callGetter(Object obj, String fieldName)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		PropertyDescriptor pd = null;
		try {
			pd = new PropertyDescriptor(fieldName, obj.getClass());
			// System.out.println("" + pd.getReadMethod().invoke(obj));
		} catch (IntrospectionException | IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd.getReadMethod().invoke(obj);
	}

}
