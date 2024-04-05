package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Note;
import com.helper.Factory_provider;
import com.mysql.cj.Query;
import com.mysql.cj.Session;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String query = request.getParameter("query");
		List<Note> searchResults = searchNotesByAlphabet(query);

		request.setAttribute("searchResults", searchResults);
		request.getRequestDispatcher("/search_results.jsp").forward(request, response);

	}
	
	private List<Note> searchNotesByAlphabet(String query) {
	    org.hibernate.Session session = null;
	    try {
	        session = Factory_provider.getFactory().openSession();
	        String hql = "FROM Note WHERE title LIKE :query";
	       org.hibernate.query.Query<Note> queryObject = session.createQuery(hql, Note.class);
	        queryObject.setParameter("query", query + "%"); 
	        return queryObject.getResultList();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}

}
