package fr.soukazes.webhookhider.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class Template {
	public static void main(String[] args) throws Exception  {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your api code: ");
		String code = scan.nextLine();
		System.out.println("Enter your message: ");
		String message = scan.nextLine();
		String postData = "code=" + URLEncoder.encode(code, "UTF-8") +"&message=" + URLEncoder.encode(message, "UTF-8");
		HttpURLConnection co = (HttpURLConnection)new URL("http://sktools.sytes.net/webhookhider/API").openConnection();
		co.setRequestMethod("POST");
		co.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		co.setDoOutput(true);
		 try (OutputStream outputStream = co.getOutputStream()) {
	            byte[] input = postData.getBytes("UTF-8");
	            outputStream.write(input, 0, input.length);
	        }
	        BufferedReader br = null;
	        br = new BufferedReader(new InputStreamReader(co.getInputStream()));
		    String reponse;
		        while ((reponse = br.readLine()) != null) {
		        	System.out.println("Reponse: " + reponse);
		        }
	}

}
