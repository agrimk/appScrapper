import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by khannaagrim on 4/5/16.
 * this code get the information for any app on google playstore if a package name is given to it
 */
public class appScrapper {

    public static void main(String args[]) {

        // JSoup Example 2 - Reading HTML page from URL
        Document doc;
        String h1 = "";
        String baseUrl = "https://play.google.com/store/apps/details?id=";
        String packageName = "com.okcupid.okcupid";
        try {
            doc = Jsoup.connect(baseUrl + packageName).userAgent("Mozilla/4.0").get();

            String title = doc.title(); // title of the app
            String rating = doc.select("div.score").text(); // rating of the app
            String ratingCount = doc.select("div.reviews-stats").text(); //number of people who have rated
            String numberOf5Stars = doc.select("div.rating-bar-container.five").text();
            String numberOf4Stars = doc.select("div.rating-bar-container.four").text();
            String numberOf3Stars = doc.select("div.rating-bar-container.three").text();
            String numberOf2Stars = doc.select("div.rating-bar-container.two").text();
            String numberOf1Stars = doc.select("div.rating-bar-container.one").text();
            String fileSize = doc.select("div[itemprop=fileSize]").text();
            String description = doc.select("div[jsname=C4s9Ed]").text();
            String version = doc.select("div[itemprop=softwareVersion]").text();
            String category = doc.select("span[itemprop=genre]").text();
            Elements screenshot=  doc.select("img[data-expand-to=full-screenshot-0]");
            String logo = doc.select("img[class=cover-image]").get(0).absUrl("src");
            String screenshotUrl = screenshot.get(0).absUrl("src"); // 1st screenshot
            String datePublished = doc.select("div[itemprop=datePublished]").text();
            String numDownloaded = doc.select("div[itemprop=numDownloads]").text();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
