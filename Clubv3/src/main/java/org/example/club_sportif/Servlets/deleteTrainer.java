package org.example.club_sportif.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.club_sportif.Repository.EntraineurRepository;


import java.io.IOException;

@WebServlet("/deleteTrainer")
public class deleteTrainer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int trainerId=Integer.parseInt(req.getParameter("trainerId"));
        EntraineurRepository repository=new EntraineurRepository();
        repository.deleteById(trainerId);
        req.getRequestDispatcher("admin.jsp").forward(req,resp);
    }
}