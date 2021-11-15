package backend;

import scraper.TmXLinkFetcher;
import org.apache.log4j.BasicConfigurator;

import java.net.URL;

public class Main {

    public static void main(String[] args){
        BasicConfigurator.configure();
        new Main();
    }

    public Main() {
        TmXLinkFetcher fetcher = new TmXLinkFetcher();
        URL[] urls = fetcher.fetchStockTrackLinks();
        for(URL url : urls) {
            System.out.println(url);
        }

        System.out.println("Hello World!");
    }
}
