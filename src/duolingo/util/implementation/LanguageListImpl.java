package duolingo.util.implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import duolingo.util.interfaces.ILanguageList;

public class LanguageListImpl implements ILanguageList {
	
	public Vector<String> getLanguagesFromFile(String url) {
		Vector<String> languages = new Vector<>();
		
		File f = new File(url);
		
		if (f.exists()) {
				try (BufferedReader r = new BufferedReader(new FileReader(f))) {
					while (r.ready()) {
						languages.add(r.readLine());
					}
				} catch (IOException e) {
					System.out.println("Exception ocurred while reading file " + f.getName());
				}
		} else {
			System.out.println("The file " + f.getName() + " does not exist.");
		}
		
		return languages;
	}

}
