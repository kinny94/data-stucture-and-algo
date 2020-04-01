import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class BFSWebCrawler {
    private Queue<String> queue;
    private List<String> discoveredWebsitesList;

    BFSWebCrawler() {
        this.queue = new LinkedList<String>();
        this.discoveredWebsitesList = new ArrayList<String>();
    }

    public void discoverWeb(String root) {
        this.queue.add(root);
        this.discoveredWebsitesList.add(root);

        while(!queue.isEmpty()) {
            String v = this.queue.remove();
            String rawHTML = readURL(v);
            String regex = "https://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(rawHTML);

            while(matcher.find()) {
                String actualUrl =  matcher.group();

                if (!discoveredWebsitesList.contains(actualUrl)) {
                    discoveredWebsitesList.add(actualUrl);
                    System.out.println("Website has been found with URL : " + actualUrl);
                    queue.add(actualUrl);
                }
            }
        }
    }

    public String readURL(String v) {
        String rawHTML = "";

        try {
            URL url = new URL(v);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine = "";
            while ((inputLine = in.readLine()) != null) {
                rawHTML += inputLine;
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rawHTML;
    }

    public static void main(String[] args) {
        BFSWebCrawler crawler = new BFSWebCrawler();
        String rootUrl = "https://www.bbc.com";
        crawler.discoverWeb(rootUrl);
    }
}