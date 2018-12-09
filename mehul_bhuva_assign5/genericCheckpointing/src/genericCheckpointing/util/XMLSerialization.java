package genericCheckpointing.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLSerialization implements SerStrategy {
	@Override
	public void processInput(SerializableObject sObject,FileDisplayInterface FileName) {
		// TODO Auto-generated method stub
		Class<?> cls = sObject.getClass();
		XMLSerialization XMLSerializationobject = new XMLSerialization();
		SerializeTypes SerializeTypesObject = new SerializeTypes();
		 FileName.writeFile("<DPSerialization>");
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
					FileName.writeFile(SerializeTypesObject.serializeshort((short)invokeRetValue, cls.getFields()[i].getName()));
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

	public ArrayList<SerializableObject> processInput(FileProcessor fileobject)
	{
		//System.out.println("inside readobj");
		String fileLine = null;
		ArrayList<SerializableObject> sObject = new ArrayList<SerializableObject>();
		XMLSerialization XMLSerializationobjectDeser = new XMLSerialization();
		SerializableObject objectDeser = new SerializableObject();
		while((fileLine = fileobject.readLine() ) != null)
		{
			
			//System.out.println("inside readobj");
			if(fileLine.contains("complexType"))
				{
				String[] split = fileLine.split(" ");
				if(split.length == 5)
				{
					sObject.add(objectDeser);
					objectDeser = null;
					
					continue;
				}
				else
				{
					Pattern p = Pattern.compile("\"([^\"]*)\"");
					Matcher m = p.matcher(split[5]);
					while (m.find()) {
					  //System.out.println(m.group(1));
						String[] bits = m.group(1).split("\\.");
						String lastOne = bits[bits.length-1];
						try {
							objectDeser = (SerializableObject) Class.forName(m.group(1)).newInstance();
						} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				}
				else if(fileLine.contains("xsd"))
				{
					//<myInt xsi:type="xsd:int">76</myInt>
					
					String[] split1 = fileLine.split(" ");
					if(split1[1].contains("int"))
					{
						
						//  String numberOnly= split1[1].replaceAll("[^\\d.]", "");
						try {
							XMLSerializationobjectDeser.callSetter(objectDeser, split1[0].trim().replace("<", ""),(Object)((Number)NumberFormat.getInstance().parse(split1[1].replaceAll("[^\\d.]", ""))).intValue());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(split1[1].contains("long"))
					{
						
						//  String numberOnly= split1[1].replaceAll("[^\\d.]", "");
						try {
							XMLSerializationobjectDeser.callSetter(objectDeser, split1[0].trim().replace("<", ""),(Object)((Number)NumberFormat.getInstance().parse(split1[1].replaceAll("[^\\d.]", ""))).longValue());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(split1[1].contains("double"))
					{
						
						//  String numberOnly= split1[1].replaceAll("[^\\d.]", "");
						try {
							XMLSerializationobjectDeser.callSetter(objectDeser, split1[0].trim().replace("<", ""),(Object)((Number)NumberFormat.getInstance().parse(split1[1].replaceAll("[^\\d.]", ""))).doubleValue());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					if(split1[1].contains("float"))
					{
						
						//  String numberOnly= split1[1].replaceAll("[^\\d.]", "");
						try {
							XMLSerializationobjectDeser.callSetter(objectDeser, split1[0].trim().replace("<", ""),(Object)((Number)NumberFormat.getInstance().parse(split1[1].replaceAll("[^\\d.]", ""))).floatValue());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					if(split1[1].contains("short"))
					{
						
						//  String numberOnly= split1[1].replaceAll("[^\\d.]", "");
						try {
							XMLSerializationobjectDeser.callSetter(objectDeser, split1[0].trim().replace("<", ""),(Object)((Number)NumberFormat.getInstance().parse(split1[1].replaceAll("[^\\d.]", ""))).shortValue());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(split1[1].contains("String"))
					{
						String stringpattern = split1[0].trim()+" xsi:type=\"xsd:String\">(.+?)"+"</"+split1[0].trim().replace("<", "")+">";
						Pattern p1 = Pattern.compile(stringpattern, Pattern.DOTALL);
						Matcher m1 = p1.matcher(fileLine);
						m1.find();
						m1.group(1);
						
						XMLSerializationobjectDeser.callSetter(objectDeser, split1[0].trim().replace("<", ""),(Object)m1.group(1));
					}
					if(split1[1].contains("Char"))
					{
						String charpattern = split1[0].trim()+" xsi:type=\"xsd:char\">(.+?)"+"</"+split1[0].trim().replace("<", "")+">";
						Pattern p1 = Pattern.compile(charpattern, Pattern.DOTALL);
						Matcher m1 = p1.matcher(fileLine);
						m1.find();
						m1.group(1);
						char character[] = m1.group(1).toCharArray();
						XMLSerializationobjectDeser.callSetter(objectDeser, split1[0].trim().replace("<", ""),(Object)character[0]);
					}
					if(split1[1].contains("boolean"))
					{
						String booleanpattern = split1[0].trim()+" xsi:type=\"xsd:boolean\">(.+?)"+"</"+split1[0].trim().replace("<", "")+">";
						Pattern p1 = Pattern.compile(booleanpattern, Pattern.DOTALL);
						Matcher m1 = p1.matcher(fileLine);
						m1.find();
						m1.group(1);
						if(m1.group(1) == "false")
						{
							XMLSerializationobjectDeser.callSetter(objectDeser, split1[0].trim().replace("<", ""),(Object)false);
						}
						if(m1.group(1) == "true")
						{
							XMLSerializationobjectDeser.callSetter(objectDeser, split1[0].trim().replace("<", ""),(Object)true);
						}
						
					}
					
				}
		}
		
		return sObject;
	}
	private void callSetter(Object obj, String fieldName, Object value) {
		PropertyDescriptor pd;
		try {
			pd = new PropertyDescriptor(fieldName, obj.getClass());
			//System.out.println(pd);
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
