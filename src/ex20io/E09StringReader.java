package ex20io;

import java.io.BufferedReader;
import java.io.FileReader;

public class E09StringReader {

	public static void main(String[] args) {

		try {
			BufferedReader in = new BufferedReader(new FileReader("src/ex20io/string.txt"));

			String str;
			while (true) {
				str = in.readLine();

				if (str == null) {
					break;
				}
				System.out.println(str);
			}

			in.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
