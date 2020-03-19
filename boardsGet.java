package api_automation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class boardsGet {
	//https://api.trello.com/1/boards/9clNtU6v/shortUrl
	


	public static void main(String[] args) {
		try {
			String response="{\"_value\":\"https://trello.com/b/9clNtU6v\"}";
			Scanner scanner = new Scanner( System.in );  
			URL url = new URL("https://api.trello.com/1/boards/9clNtU6v/shortUrl");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			System.out.println(conn.getResponseCode());

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			/*if (assert response==output){
				System.out.println("Response valid");
			}
			else {
				System.out.println("Response invalid");
			}*/
				
			
		
			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }

		}

	}

		
	

	


