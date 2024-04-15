package org.example.club_sportif.Servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.club_sportif.Repository.GroupeRepository;

import java.io.IOException;

@WebServlet("/deleteGroup")
public class deleteGroupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int groupeId=Integer.parseInt(req.getParameter("groupeId"));
        GroupeRepository repository=new GroupeRepository();
        repository.deleteById(groupeId);
        req.getRequestDispatcher("admin.jsp").forward(req,resp);
    }
}