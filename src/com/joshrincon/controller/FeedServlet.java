package com.joshrincon.controller;

import com.joshrincon.beans.SingletonEntriesFeed;
import com.rometools.rome.feed.synd.SyndEntry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class FeedServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if(session.getAttribute("syndEntries") == null) {
            SingletonEntriesFeed.getInstance().createFeeds();
            ArrayList<SyndEntry> syndEntries = SingletonEntriesFeed.getInstance().getEntries();
            session.setAttribute("syndEntries", syndEntries);
            request.getRequestDispatcher("/WEB-INF/jsps/feeds.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/jsps/feeds.jsp").forward(request, response);
        }


    }
}
