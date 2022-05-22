
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/**
 *
 * @author(s) Kenn and Alex
 */
public class yelpScraper {
    
    public static void main(String[] args) {
        final String url = "https://www.yelp.com/biz/wildflour-caf%C3%A9-bakery-makati";
        
        try {
            final Document document = Jsoup.connect(url).get();
            
            //System.out.println(document.outerHtml());
            
            for (Element row : document.select("ul. undefined.list__09f24__ynIEd tr")) {
                if (row.select("div:nth-of-type(1)").text().equals("")) {
                    continue;
                } else {
                    final String ticker = row.select("td:nth-of-type(1)").text();
                    final String name = row.select("td:nth-of-type(2)").text();
                    final String tempPrice = row.select("td.right:nth-of-type(3)").text();
                    final String tempPrice1 = tempPrice.replace(",", "");
                    
                    System.out.println(ticker + " " + name + " " + tempPrice1);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}