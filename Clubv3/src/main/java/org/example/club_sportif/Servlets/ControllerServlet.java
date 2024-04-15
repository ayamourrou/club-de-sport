package org.example.club_sportif.Servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.club_sportif.Entities.*;
import org.example.club_sportif.Repository.*;


import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/ctrl")
public class ControllerServlet extends HttpServlet {
    SportRepository sportRepository;
    MembreRepository membreRepository;
    CotisationRepository cotisationRepository;
    GroupeRepository groupeRepository;
    EntraineurRepository entraineurRepository;
    EndroitRepository endroitRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialisez vos repositories ici
        sportRepository = new SportRepository();
        membreRepository = new MembreRepository();
        cotisationRepository = new CotisationRepository();
        groupeRepository=new GroupeRepository();
        entraineurRepository=new EntraineurRepository();
        endroitRepository=new EndroitRepository();

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean categoriesAdded = session.getAttribute("sportsAdded") != null;
        String action = req.getParameter("action");
        Date date = new Date();
        if (!categoriesAdded) {
            Cotisation cotisation=new Cotisation(date,date,900,"Cache","done");
            Cotisation cotisation2=new Cotisation(date,date,900,"Cache","done");
            Cotisation cotisation3=new Cotisation(date,date,900,"Cache","done");


            cotisationRepository.save(cotisation2);
            cotisationRepository.save(cotisation);
            cotisationRepository.save(cotisation3);



            //Adding sports
            Sport sport1 = new Sport();
            sport1.setNomSprot("Bodybuilding");
            sport1.setCategory("solo");

            Sport sport2 = new Sport();
            sport2.setNomSprot("Boxing");
            sport2.setCategory("solo");

            Sport sport3 = new Sport();
            sport3.setNomSprot("BasketBall");
            sport3.setCategory("Team");

            Sport sport4 = new Sport();
            sport4.setNomSprot("FootBall");
            sport4.setCategory("Team");

            Sport sport5 = new Sport();
            sport4.setNomSprot("Mixed Martial Arts");
            sport4.setCategory("Solo");



            sportRepository.save(sport1);
            sportRepository.save(sport2);
            sportRepository.save(sport3);
            sportRepository.save(sport4);

            //Adding facilities
            Endroit e1=new Endroit("Basket Ball Court",false,"address1");
            Endroit e2=new Endroit("Football Court",true,"address2");
            Endroit e3=new Endroit("Gym",true,"address3");
            Endroit e4=new Endroit("Martial Arts Cage",false,"address4");
            Endroit e5=new Endroit("Boxing Ring",true,"address5");

            e1.setSport(sport3);
            e2.setSport(sport4);
            e3.setSport(sport1);
            e5.setSport(sport2);
            e4.setSport(sport5);

            endroitRepository.save(e1);
            endroitRepository.save(e2);
            endroitRepository.save(e3);
            endroitRepository.save(e4);
            endroitRepository.save(e5);

            //Adding Trainers

            Entraineur entraineur1=new Entraineur();
            Entraineur entraineur2=new Entraineur();
            Entraineur entraineur3=new Entraineur();
            Entraineur entraineur4=new Entraineur();
            Entraineur entraineur5=new Entraineur();

            entraineur1.setNom("Bouhlal");
            entraineur2.setNom("Afathi");
            entraineur3.setNom("Khadira");
            entraineur4.setNom("Tentaoui");
            entraineur5.setNom("Bouraissi");

            entraineur1.setAdresse("Address 1");
            entraineur2.setAdresse("Address 2");
            entraineur3.setAdresse("Address 3");
            entraineur4.setAdresse("Address 4");
            entraineur5.setAdresse("Address 5");

            entraineur1.setPrenom("Nazih");
            entraineur2.setPrenom("Yaser");
            entraineur3.setPrenom("Youssef");
            entraineur4.setPrenom("Simo");
            entraineur5.setPrenom("Ayoub");

            entraineur1.setNumerotelephone("111111");
            entraineur2.setNumerotelephone("222222");
            entraineur3.setNumerotelephone("3333333");
            entraineur4.setNumerotelephone("4444444");
            entraineur5.setNumerotelephone("5555555");

            //Adding Groups
            Groupe groupe1=new Groupe();
            Groupe groupe2=new Groupe();
            Groupe groupe3=new Groupe();
            Groupe groupe4=new Groupe();
            Groupe groupe5=new Groupe();

            groupe1.setCategorie("Fitness");
            groupe2.setCategorie("Martial arts");
            groupe3.setCategorie("Bodybuilding");
            groupe4.setCategorie("Basketball");
            groupe5.setCategorie("Football");

            groupe1.setEntraineur(entraineur1);
            groupe2.setEntraineur(entraineur2);
            groupe3.setEntraineur(entraineur3);
            groupe4.setEntraineur(entraineur4);
            groupe5.setEntraineur(entraineur5);

            entraineurRepository.save(entraineur1);
            entraineurRepository.save(entraineur2);
            entraineurRepository.save(entraineur3);
            entraineurRepository.save(entraineur4);
            entraineurRepository.save(entraineur5);

            groupeRepository.save(groupe1);
            groupeRepository.save(groupe2);
            groupeRepository.save(groupe3);
            groupeRepository.save(groupe4);
            groupeRepository.save(groupe5);

            Membre membre1=new Membre();
            membre1.setNom("Nazih");
            membre1.setGroupe(groupe1);
            membreRepository.save(membre1);

            session.setAttribute("sportsAdded", true);
        }
        if(action.equalsIgnoreCase("login")){
            List<Sport> sports=sportRepository.findAll();
            req.setAttribute("sports",sports);
            req.getRequestDispatcher("login_signup.jsp").forward(req,resp);
        }
        if (action.equalsIgnoreCase("logout")){
            req.getRequestDispatcher("login_signup.jsp").forward(req,resp);
        }
        if (action.equalsIgnoreCase("SportsList")){
            List<Sport> sports=sportRepository.findAll();
            HttpSession session1=req.getSession();
            session1.setAttribute("sports", sports);
            req.getRequestDispatcher("SportsLists.jsp").forward(req,resp);
        }
        if (action.equalsIgnoreCase("Group")){
            List<Groupe> groupes=groupeRepository.findAll();
            HttpSession session1=req.getSession();
            session1.setAttribute("groupes",groupes);
            req.getRequestDispatcher("Groups.jsp").forward(req,resp);
        }
        if (action.equalsIgnoreCase("MemberShip")){
            List<Cotisation> cotisations=cotisationRepository.findAll();
            HttpSession session1=req.getSession();
            session1.setAttribute("cotisations",cotisations);
            req.getRequestDispatcher("MemberShip.jsp").forward(req,resp);
        }
        if (action.equalsIgnoreCase("Member")){
            String password = (String)session.getAttribute("password");

            MembreRepository membreRepository = new MembreRepository();
            Membre membre = membreRepository.findById(Integer.valueOf(password));
            session.setAttribute("user",membre);
            // Set les attributs pour les valeurs de membre
            req.setAttribute("firstname", membre.getPrenom());
            req.setAttribute("lastname", membre.getNom());
            req.setAttribute("address", membre.getAdresse());
            req.setAttribute("phone", membre.getNumerotelephone());
            req.setAttribute("birthdate", membre.getDateNaissance());

            // Dispatch à la JSP pour afficher le formulaire de mise à jour de profil
            req.getRequestDispatcher("Membre.jsp").forward(req, resp);
        }

        if (action.equalsIgnoreCase("informations")){
            membreRepository=new MembreRepository();
            List<Membre> membres=membreRepository.findAll();
            List<Sport> sports=sportRepository.findAll();
            List<Endroit>facilities=endroitRepository.findAll();
            List<Entraineur> entraineurs=entraineurRepository.findAll();
            List<Groupe> groups=groupeRepository.findAll();
            HttpSession session1=req.getSession();
            session1.setAttribute("membres",membres);
            session1.setAttribute("sports",sports);
            session1.setAttribute("facilities",facilities);
            session1.setAttribute("groups",groups);
            session1.setAttribute("trainers",entraineurs);
            req.getRequestDispatcher("table.jsp").forward(req,resp);
        }
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}



