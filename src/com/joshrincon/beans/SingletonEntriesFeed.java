package com.joshrincon.beans;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingletonEntriesFeed {

    private ArrayList<SyndEntry> entries = new ArrayList<SyndEntry>();
    private static final SingletonEntriesFeed INSTANCE = new SingletonEntriesFeed();
    RssSortByDate rssSortByDate = new RssSortByDate();

    public SingletonEntriesFeed() {

    }

    public void createFeeds() throws IOException {
        SyndFeedInput syndFeedInput;
        SyndFeed syndFeed;
        XmlReader xmlReader;
        ArrayList<SyndEntry> syndEntries = null;

        List<String> urls = new ArrayList<String>();
        urls.add("http://feeds.feedburner.com/TheAtlantic");
        urls.add("https://news.google.com/?output=rss");

        for (String rssfeed : urls) {

            URL url = new URL(rssfeed);
            syndFeedInput = new SyndFeedInput();
            xmlReader = new XmlReader(url);

            try {
                syndFeed = syndFeedInput.build(xmlReader);
                System.out.println("Syndfeed was a success!");
                setTheEntries(syndFeed);
            } catch (FeedException e) {
                e.printStackTrace();
            }
        }
    }

    public static SingletonEntriesFeed getInstance() {
        return INSTANCE;
    }

    public void setTheEntries (SyndFeed feed) {
        for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()) {
            entries.add(entry);
        }
    }

    public SyndEntry getOneEntry(int position) {
        return entries.get(position);
    }

    public ArrayList<SyndEntry> getEntries() {
        sortedEntries();
        return entries;
    }

    public void sortedEntries() {
        Collections.sort(entries, rssSortByDate);
    }


}
