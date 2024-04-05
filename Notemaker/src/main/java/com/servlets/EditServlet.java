package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.Factory_provider;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int noteId = Integer.parseInt(request.getParameter("note_id").trim());
		Note note = getNoteById(noteId);

		// Pass to edit.jsp for editing

		request.setAttribute("note", note);
		request.getRequestDispatcher("/edit.jsp").forward(request, response);

	}

	private Note getNoteById(int noteId) {

		Note note = new Note();
		note.setId(noteId);

		return note;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int noteId = Integer.parseInt(request.getParameter("Id"));
		String updatedTitle = request.getParameter("Title");
		String updatedContent = request.getParameter("Content");

		updateNoteInDatabase(noteId, updatedTitle, updatedContent);

		response.sendRedirect("all_notes.jsp?note_id=" + noteId);
	}

	private void updateNoteInDatabase(int noteId, String updatedTitle, String updatedContent) {
		Session s = Factory_provider.getFactory().openSession();
		Transaction tx = s.beginTransaction();

		try {

			Note note = s.get(Note.class, noteId);

			note.setTitle(updatedTitle);
			note.setContent(updatedContent);

			s.update(note);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			s.close();
		}
	}

}
