package vn.hcmus.fit.sv18120045.generics_collections;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class DocFile {
	public void ReadFile(String File, List<Slangword_Definition> SWD_List) {
		FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
		try {
			fileInputStream = new FileInputStream(File);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String slang_WM = bufferedReader.readLine();
			while (slang_WM != null) {
				String word = "";
				List<String> meaning = new ArrayList<>();
				String x = "";
				boolean dd = false;
				for (int i=0; i<slang_WM.length(); i++) {
					char ch = slang_WM.charAt(i);
					if (ch == '`')
						dd = true;
					else if (dd == false) {
						word = word + ch;
					}
					else {
						if (i == slang_WM.length()-1) {
							x = x + ch;
							meaning.add(x);
						}
						else if (ch == '|') {
							meaning.add(x);
							x = "";
						}						
						else {
							x = x + ch;
						}
					}
				}
				Slangword_Definition SWD = new Slangword_Definition(word, meaning);
				SWD_List.add(SWD);
				slang_WM = bufferedReader.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
                fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
