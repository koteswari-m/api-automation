package api_automation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class cardChecklists {
	//https://api.trello.com/1/boards/9clNtU6v/shortUrl
	


	public static void main(String[] args) {
		try {
			URL url = new URL("https://api.trello.com/1/cards/vacationcard/checklist/airasia/checkItem/food?key=96d1224ddbe5a2bbac5fff3d8053a29e&token=980f440f65e05985f88d35ebfe711c395a16c18bf55ab9eb0a7fe547d65fdc42");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("PUT");
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

		
	

	


