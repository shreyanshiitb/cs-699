import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class q3 {
	static String GET_URL = "https://www.cse.iitb.ac.in/~diptesh/get_hash.php?";

	static String POST_URL = "https://www.cse.iitb.ac.in/~diptesh/post_hash.php";

	static String POST_PARAMS;

	public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        POST_PARAMS = sc.nextLine();
        POST_PARAMS = "input="+POST_PARAMS;
        GET_URL = GET_URL+POST_PARAMS;
        // System.out.println(POST_PARAMS+","+GET_URL);
        sc.close();

		sendGET();
		// System.out.println("GET DONE");
		sendPOST();
        // System.out.println("POST DONE");
	}

	private static void sendGET() throws Exception {
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		// con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		// System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()
                ));
            
                String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
            }
            
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}

	}

	private static void sendPOST() throws IOException {
		URL obj = new URL(POST_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		// con.setRequestProperty("User-Agent", USER_AGENT);

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		// System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST request not worked");
		}
	}

}
