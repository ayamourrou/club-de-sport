package org.example.club_sportif.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.club_sportif.Entities.Sport;
import org.example.club_sportif.Repository.SportRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/deleteSport")
public class deleteSport extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sportId=Integer.parseInt(req.getParameter("sportId"));
        SportRepository sportRepository =new SportRepository();
        sportRepository.deleteById(sportId);
        req.getRequestDispatcher("admin.jsp").forward(req,resp);
    }
}
