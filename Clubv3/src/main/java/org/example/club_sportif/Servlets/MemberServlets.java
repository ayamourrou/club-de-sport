package org.example.club_sportif.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.club_sportif.Entities.Admin;
import org.example.club_sportif.Entities.Membre;
import org.example.club_sportif.Repository.MembreRepository;

import java.io.IOException;

@WebServlet("/membreLogin")
public class MemberServlets extends HttpServlet {
    MembreRepository membreRepository=new MembreRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MembreRepository membre = new MembreRepository();
        Membre membres=new Membre("sefrou","khadira","youssef","0773302245",null,null,null,null);
        membre.save(membres);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession(); // Obtenez la session existante ou créez une nouvelle session si elle n'existe pas déjà
        session.setAttribute("password", password); // Stockez le mot de passe dans la session

        Membre membreses = membre.findById(Integer.valueOf(password));

        try {
            // Vérification de l'authentification du membre
            if (membreses != null && membreses.authentifier(username, password)) {
                // Authentification réussie, redirection vers user.jsp
                int pasword = Integer.parseInt(req.getParameter("password"));

                MembreRepository membreRepository = new MembreRepository();
                Membre member = membreRepository.findById(Integer.valueOf(pasword));
                session.setAttribute("user",member);
                req.setAttribute("firstname", member.getPrenom());
                req.setAttribute("lastname", member.getNom());
                req.setAttribute("address", member.getAdresse());
                req.setAttribute("phone", member.getNumerotelephone());
                req.setAttribute("birthdate", member.getDateNaissance());

                req.getRequestDispatcher("Membre.jsp").forward(req, resp);

            } else {
                // Authentification échouée, vous pouvez rediriger vers une page de connexion avec un message d'erreur
                // Par exemple :
                req.setAttribute("errorMessage", "Invalid username or password");
                req.getRequestDispatcher("login_signup.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
