
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class IssueParser {
    public static void main(String[] args) throws IOException {
        if(args.length == 2){
            String htmlInput = args[0];
            String csvOutput = args[1];
            File[] files = new File(htmlInput).listFiles();
            for(File html:files){
                parse(html);
            }
        }
        else {
            System.out.println("Please input 2 arguments: ");
            System.out.println("P1: input html files dir");
            System.out.println("P2: output csv file path");
        }
    }

    public static void parse(File html) throws IOException {
        Document doc = Jsoup.parse(html,"UTF-8");
        Elements table = doc.getElementsByTag("table");
        Elements tbody = table.get(1).getElementsByTag("tbody");
        //System.out.println(tbody.get(0));
        Elements issues = tbody.get(0).getElementsByAttributeValueContaining("data-issuekey","ZOOKEEPER-");
        for(Element issue:issues){
            String issueKey = issue.getElementsByClass("issuekey").get(0).attr("data-issuekey");
            String created = issue.getElementsByClass("created").get(0).text();
            String updated = issue.getElementsByClass("updated").get(0).text();
            String type = issue.getElementsByClass("issuetype").get(0).text();
            String summary = issue.getElementsByClass("summary").get(0).text();
            String description = issue.getElementsByClass("description").get(0).text();
            System.out.println("JIRA Issue: " + issueKey);
            System.out.println("Created: " + created);
            System.out.println("Updated: " + updated);
            System.out.println("Type: " + type);
            System.out.println("Summary: " + summary);
            System.out.println("Description: " + description);
        }
    }
}
