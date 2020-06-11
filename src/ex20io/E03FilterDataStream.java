package ex20io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class E03FilterDataStream {

	public static void main(String[] args) {
		
		String src = "src/ex20io/FilterdataStream.bin";
		
		try {
			OutputStream out = new FileOutputStream(src);
			DataOutputStream filterOut = new DataOutputStream(out);
			
			filterOut.writeInt(123);
			filterOut.writeDouble(12.34);
			filterOut.writeInt(456);
			filterOut.writeDouble(56.78);
			
			DataInputStream filterIn = new DataInputStream(new FileInputStream(src));
			
			int num1 = filterIn.readInt();
			double dnum1 = filterIn.readDouble();
			int num2 = filterIn.readInt();
			double dnum2 = filterIn.readDouble();
			
			System.out.println("num1="+num1);
			System.out.println("dnum1="+dnum1);
			System.out.println("num2="+num2);
			System.out.println("dnum2="+dnum2);
			
			if(filterOut!=null) filterOut.close();
			if(filterIn!=null) filterIn.close();
			
		}
		catch(FileNotFoundException e) {
			System.out.println("해당 파일 없음.");
		}
		catch(IOException e) {
			System.out.println("IO오류발생");
		}

	}

}
