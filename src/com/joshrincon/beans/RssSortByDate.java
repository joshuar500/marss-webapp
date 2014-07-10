package com.joshrincon.beans;

import com.rometools.rome.feed.synd.SyndEntry;

import java.util.Comparator;

/**
 * Created by on 7/10/2014.
 */
public class RssSortByDate implements Comparator<SyndEntry> {
    @Override
    public int compare(SyndEntry syndEntry, SyndEntry syndEntry2) {
        return syndEntry2.getPublishedDate().compareTo(syndEntry.getPublishedDate());
    }
}
