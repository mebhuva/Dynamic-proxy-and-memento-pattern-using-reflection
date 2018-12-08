package genericCheckpointing.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 * @author Mehul
 *
 */
public class Result implements FileDisplayInterface {

	private File file;
	@Override
	public void FileInitializer(String FileName)
	{
		file = new File(FileName);
	}

	@Override
	public void writeFile(String OutputString) {
		// TODO Auto-generated method stub
		BufferedWriter writer = null;

		try {
			
			writer = new BufferedWriter(new FileWriter(file, true));// using buffered writer to write into the file
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		try {
			
				try {
					writer.write(OutputString);
					writer.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {

				}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {

		}
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}




}

