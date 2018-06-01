package com.cgi.poei.mweb.client;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class MediathequeClient {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:8080/mweb/api/usager/DeA0000");

		URLConnection connection = url.openConnection();
		
		try(Scanner scanner = new Scanner(connection.getInputStream())) {
			System.out.println(scanner.nextLine());
		}
	}

}
