package fr.marcjus.plugin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainPlugin {
	
	public static void main(String[] args) {
		try{
			File file = new File("message.txt");
			
			if(!file.exists())file.createNewFile();
			
			FileWriter writer = new FileWriter(file);
			BufferedWriter buffer = new BufferedWriter(writer);
			writer.write("Bonne fete papa !\n");
			writer.close();
			
			ProcessBuilder pb = new ProcessBuilder("gedit", file.getAbsolutePath());
			pb.directory(new File(System.getProperty("user.home")));
			pb.redirectErrorStream(true);
			Process process = pb.start();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			System.out.println("Terminé");
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}
