package com.padma.automation.weigthtwatchers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DictionaryListingTest {

	@Test
	public void printDictionary() {
		String path = "dictionary.txt";
		boolean fileExists = this.doesFileExist(path);
		System.out.println(fileExists);

		Assert.assertEquals(fileExists, true);
		if (fileExists) {
			this.printWords(path);
		}

	}

	public boolean doesFileExist(String path) {
		boolean fileExists = false;
		try {
			System.out.println(ClassLoader.getSystemResource(path));
			File file = new File(ClassLoader.getSystemResource(path).getFile());
			fileExists = file.isFile();
		} catch (NullPointerException e) {
			System.out.println(path + " not found -" + e.getMessage());
		}

		return fileExists;
	}

	public void printWords(String path) {

		try {
			File file = new File(ClassLoader.getSystemResource(path).getFile());

			BufferedReader br = new BufferedReader(new FileReader(file));

			String line;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split("[-,]");
				for (String token : tokens) {
					System.out.println(token);
				}
			}

			br.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}

	}
}
