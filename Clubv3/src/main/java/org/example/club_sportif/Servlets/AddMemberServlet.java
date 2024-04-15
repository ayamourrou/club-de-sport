package org.example.club_sportif.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.club_sportif.Entities.Membre;
import org.example.club_sportif.Repository.CotisationRepository;
import org.example.club_sportif.Repository.MembreRepository;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AddMember")
public class AddMemberServlet extends HttpServlet {
    MembreRepository repository;
    Membre membre = new Membre();
    Membre membres = new Membre();
    CotisationRepository cotisationRepository = new CotisationRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Rien à faire ici pour l'instant
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // creation dyal session for stock premier fois
        boolean trueorfalse = session.getAttribute("false") != null;
        String firstName=null,lastName=null,address=null,phoneNumber=null,birthDate=null;

        if(!trueorfalse){
         firstName = req.getParameter("firstname");
         lastName = req.getParameter("lastname");
         address = req.getParameter("address");
         phoneNumber = req.getParameter("phone");
         birthDate = req.getParameter("birthdate");
        }

        if (birthDate != null && !birthDate.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = dateFormat.parse(birthDate);
                membre.setDateNaissance(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else {
            // Gérer le cas où la date de naissance est null ou vide
        }

        String selectedItem = req.getParameter("selectedItem");
        if (selectedItem != null && !selectedItem.isEmpty()) {
            int id_cotisation = Integer.parseInt(selectedItem);
            // Charger la cotisation correspondant à l'identifiant
            membres.setCotisation(cotisationRepository.findById(id_cotisation));
        }
        else {
            session.setAttribute("lastName",lastName);
            session.setAttribute("firstName",firstName);
            session.setAttribute("address",address);
            session.setAttribute("phoneNumber",phoneNumber);
            session.setAttribute("birthDate",membre.getDateNaissance());
        }

        if (trueorfalse){
        session.setAttribute("false",true);
        }

        if (membres.getCotisation() != null) {
            repository = new MembreRepository();
            Membre membre1=new Membre((String) session.getAttribute("address"), (String) session.getAttribute("lastName"), (String) session.getAttribute("firstName"), (String) session.getAttribute("phoneNumber"), (Date) session.getAttribute("birthDate"),null,membres.getCotisation(),null);
            repository.save(membre1);
            req.getRequestDispatcher("login_signup.jsp").forward(req, resp);
        } else {
            // Rediriger vers la page de sélection de cotisation si aucune cotisation n'est sélectionnée
            req.getRequestDispatcher("Cotisation.jsp").forward(req, resp);
        }
    }
}
