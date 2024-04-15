package org.example.club_sportif.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.club_sportif.Repository.MembreRepository;

import java.io.IOException;

@WebServlet("/deleteMember")
public class DeleteMemberServlet extends HttpServlet {
    MembreRepository membreRepository=new MembreRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int memberId=Integer.parseInt(req.getParameter("memberId"));
        membreRepository.deleteById(memberId);
        req.getRequestDispatcher("admin.jsp").forward(req,resp);
    }
}
