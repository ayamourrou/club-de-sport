package org.example.club_sportif.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.club_sportif.Entities.Entraineur;
import org.example.club_sportif.Repository.EntraineurRepository;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/addTrainer")
public class AddTrainer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firsname=req.getParameter("firstname");
        String lastname=req.getParameter("lastname");
        String address=req.getParameter("address");
        String phone=req.getParameter("phone");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Adjust format as needed
        Date birthdate = null;
        try {
            birthdate = sdf.parse(req.getParameter("birthdate"));
        } catch (ParseException e) {
            // Handle parsing error (e.g., log, display error message)
        }
        Entraineur entraineur=new Entraineur();
        entraineur.setPrenom(firsname);
        entraineur.setNom(lastname);
        entraineur.setAdresse(address);
        entraineur.setDateNaissance(birthdate);
        entraineur.setNumerotelephone(phone);

        EntraineurRepository entraineurRepository=new EntraineurRepository();
        entraineurRepository.save(entraineur);
        req.getRequestDispatcher("admin.jsp").forward(req,resp);
    }

}
