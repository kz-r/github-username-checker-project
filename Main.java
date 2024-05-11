import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String listPath = "{WORDLIST PATH}";
        String proxyAddress = "{PROXYADDRESS}";
        int proxyPort = 40000;

        try (BufferedReader br = new BufferedReader(new FileReader(listPath))) {
            String username;
            while ((username = br.readLine()) != null) {
                checkUser(username, proxyAddress, proxyPort);
                Thread.sleep(2500);
            }
        } catch (IOException | InterruptedException x) {
            x.printStackTrace();
        }
    }
    public static void checkUser(String usernameToCheck, String proxyAddress, int proxyPort) {
        try {
            URL url = new URL("https://github.com/" + usernameToCheck);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyAddress, proxyPort));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                System.out.println(usernameToCheck + " is taken... ❌");
            } else if (responseCode == 404) {
                System.out.println(usernameToCheck + " may be available. ✅");
            } else {
                System.out.println("Unexpected response code: " + responseCode);
            }

            conn.disconnect();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
