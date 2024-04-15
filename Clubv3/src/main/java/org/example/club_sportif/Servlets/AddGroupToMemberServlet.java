package org.example.club_sportif.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.club_sportif.Entities.Groupe;
import org.example.club_sportif.Entities.Membre;
import org.example.club_sportif.Entities.Sport;
import org.example.club_sportif.Repository.GroupeRepository;
import org.example.club_sportif.Repository.MembreRepository;
import org.example.club_sportif.Repository.SportRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddGroupToMember")
public class AddGroupToMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selectedGroups = req.getParameter("selectedGroups");
        GroupeRepository groupeRepository = new GroupeRepository();
        Groupe groupe=new Groupe();
        if (selectedGroups != null) {
                groupe = groupeRepository.findById(Integer.valueOf(selectedGroups));
            }
            HttpSession session = req.getSession();
            String password = (String)session.getAttribute("password");
            MembreRepository membreRepository = new MembreRepository();
            Membre membre = membreRepository.findById(Integer.valueOf(password));
            if (groupe!=null) {
                membre.setGroupe(groupe);
                membreRepository.update(membre);
            }
            req.getRequestDispatcher("Membre.jsp").forward(req, resp);
        }
    }

