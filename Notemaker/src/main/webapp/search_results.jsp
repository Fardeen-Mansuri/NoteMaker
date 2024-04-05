<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="com.entities.*" %>

<%@page import="java.util.*" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
</head>
<body>
    <h1>Search Results</h1>
    
    <%
        List<Note> searchResults = (List<Note>) request.getAttribute("searchResults");
        
        if (searchResults != null && !searchResults.isEmpty()) {
            for (Note note : searchResults) {
    %>
                <div>
                    <h2><%= note.getTitle() %></h2>
                    <p><%= note.getContent() %></p>
                </div>
    <%
            }
        } else {
    %>
            <p>No notes found matching the search criteria.</p>
    <%
        }
    %>
</body>
</html>
