package com.joshrincon.beans;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;

import java.util.ArrayList;
import java.util.List;

public class SingletonEntriesFeed {

    private List<SyndEntry> entries = new ArrayList<SyndEntry>();
    private static final SingletonEntriesFeed INSTANCE = new SingletonEntriesFeed();

    public SingletonEntriesFeed() {

    }

    public static SingletonEntriesFeed getInstance() {
        return INSTANCE;
    }

    public void setTheEntries (SyndFeed feed) {
        for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()) {
            entries.add(entry);
        }
    }

    public SyndEntry getAnEntry(int position) {
        return entries.get(position);
    }



}
