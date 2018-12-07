package genericCheckpointing.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



/**
 * FileProcessor class process input file
 * 
 * @author Mehul
 *
 */
public class FileProcessor {

	private File input;
	private BufferedReader Bfreader;

	
	
	/**
	 * Constructor used to initialize input file object
	 * 
	 * @param args
	 */
	public FileProcessor(String[] args) {

		try {
			this.input = new File(args[0]);
			Bfreader = new BufferedReader(new FileReader(this.input));
		} catch (IOException e) {
			System.exit(0);
		} finally {

		}
	}

	/**
	 * fileInputExists checks if file input exists or not
	 * 
	 * @return 0 or 1
	 */
	public int fileInputExists() {
		if (!this.input.exists()) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * method to read a line from input file
	 * 
	 * @return new line from input file.
	 */
	public synchronized String readLine() {
		try {
			String readLine = Bfreader.readLine();
			return readLine;
		} catch (IOException e) {
			System.exit(0);
		} finally {

		}
		return null;
	}

	/**
	 * FileClose called after file reading is completed
	 */

	public void fileClose() {
		try {
			Bfreader.close();
		} catch (IOException e) {
		} finally {

		}
	}
	@Override
	public String toString() {
		return "FileProcessor [input=" + input + ", Bfreader=" + Bfreader + ", fileInputExists()=" + fileInputExists()
				+ ", readLine()=" + readLine() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((input == null) ? 0 : input.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileProcessor other = (FileProcessor) obj;
		if (input == null) {
			if (other.input != null)
				return false;
		} else if (!input.equals(other.input))
			return false;
		return true;
	}

}