package org.example.club_sportif.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.club_sportif.Entities.Membre;
import org.example.club_sportif.Repository.MembreRepository;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/UpdateProfile")
public class UpdatePorfileServlet extends HttpServlet {
    MembreRepository repository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String password = (String) session.getAttribute("password");

        String firstName=req.getParameter("firstname");
        String lastName=req.getParameter("lastname");
        String address=req.getParameter("address");
        String phoneNumber=req.getParameter("phone");
        String birthDate=req.getParameter("birthdate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = dateFormat.parse(birthDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Membre membre=new Membre();
        membre.setId_membre(Integer.parseInt(password));
        membre.setNom(lastName);
        membre.setPrenom(firstName);
        membre.setAdresse(address);
        membre.setNumerotelephone(phoneNumber);
        membre.setDateNaissance(date);

        req.setAttribute("firstname",firstName);
        req.setAttribute("lastname", lastName);
        req.setAttribute("address", address);
        req.setAttribute("phone", phoneNumber);
        req.setAttribute("birthdate", birthDate);
        repository=new MembreRepository();
        repository.update(membre);
        req.getRequestDispatcher("Membre.jsp").forward(req, resp);
    }
}
