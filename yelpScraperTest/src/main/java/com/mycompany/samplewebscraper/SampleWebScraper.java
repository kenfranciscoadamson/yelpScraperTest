package com.mycompany.samplewebscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Kenn
 */
public class SampleWebScraper {

    public static void main(String[] args) {
        
        final String url = "https://web.archive.org/web/20190104110157/http://shares.telegraph.co.uk/indices/?index=MCX";
        
        try {
            final Document document = Jsoup.connect(url).get();
            
            //System.out.println(document.outerHtml());
            
            for (Element row : document.select(
                "table.tablesorter.full tr")) {
                if (row.select("td:nth-of-type(1)").text().equals("")) {
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
