package com.joshrincon.test;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;


public class TestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        URL url = new URL("https://news.google.com/?output=rss");
        SyndFeedInput syndFeedInput = new SyndFeedInput();
        SyndFeed syndFeed = null;
        XmlReader xmlReader = new XmlReader(url);

        try {
            syndFeed = syndFeedInput.build(xmlReader);
            System.out.println("Syndfeed was a success!");
        } catch (FeedException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        session.setAttribute("syndFeed", syndFeed);

        request.getRequestDispatcher("/WEB-INF/jsps/feeds.jsp").forward(request, response);

    }
}
