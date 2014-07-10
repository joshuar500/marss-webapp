package com.joshrincon.controller;

import com.joshrincon.beans.SingletonEntriesFeed;
import com.rometools.rome.feed.synd.SyndEntry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by on 7/10/2014.
 */
public class EntryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int entryPosition = Integer.parseInt(request.getParameter("action"));

        SyndEntry entry = SingletonEntriesFeed.getInstance().getOneEntry(entryPosition);

        HttpSession session = request.getSession();
        session.setAttribute("entry", entry);

        request.getRequestDispatcher("/WEB-INF/jsps/entry.jsp").forward(request, response);


    }
}
