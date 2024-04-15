package org.example.club_sportif.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.club_sportif.Entities.Sport;
import org.example.club_sportif.Repository.SportRepository;

import java.io.IOException;


@WebServlet("/addSport")
public class addSport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sportName=req.getParameter("name");
        String category=req.getParameter("category");
        Sport sport=new Sport();
        sport.setNomSprot(sportName);
        sport.setCategory(category);
        SportRepository repository  =new SportRepository();
        repository.save(sport);
        req.getRequestDispatcher("admin.jsp").forward(req,resp);
    }
}
