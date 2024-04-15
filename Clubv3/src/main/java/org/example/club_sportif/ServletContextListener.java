package org.example.club_sportif;

import org.example.club_sportif.Entities.Endroit;
import org.example.club_sportif.Entities.Sport;
import org.example.club_sportif.Repository.EndroitRepository;
import org.example.club_sportif.Repository.SportRepository;


import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener {
    EndroitRepository endroitRepository;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        Endroit endroit=new Endroit();
//        endroit.setNomEndroit("Boxing Ring");
//        endroitRepository=new EndroitRepository();
//        endroitRepository.save(endroit);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        javax.servlet.ServletContextListener.super.contextDestroyed(sce);
    }
}
