package ex20io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class E02ByteBufferFileCopy {

	public static void main(String[] args) {
		
		try {
			InputStream in = new FileInputStream("src/ex20io/A38Http2.zip");
			OutputStream out = new FileOutputStream("src/ex20io/A38Http2_copy2.zip");
			
			int copyByte = 0;
			int readLen;
			
			byte buffer[] = new byte[1024];
			
			while(true) {
				readLen = in.read(buffer);
				if(readLen==-1) {
					break;
				}
				/*
				 읽어온 내용을 파일에 입력.버퍼에 저장된 데이터를
				 인덱스 0의 위치에서 readLen만큼 전송
				 */
				out.write(buffer,0,readLen);
				copyByte += readLen;
			}
			
			if(in!=null) in.close();
			if(out!=null) out.close();
			
			System.out.println("복사된 파일 크기 : " + copyByte + "byte");
			System.out.println("복사된 파일 크기 : " + (copyByte/1024) + "Kbyte");
			System.out.println("복사된 파일 크기 : " + (copyByte/(1024*1024)) + "Mbyte");
			
		}
		
		catch(FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		}
		catch(IOException e) {
			System.out.println("IO작업 중 예외가 발생");
		}
		catch(Exception e) {
			System.out.println("알 수 없는 예외 발생");
		}

	}

}
