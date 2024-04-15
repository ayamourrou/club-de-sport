package org.example.club_sportif.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.club_sportif.Entities.*;

import java.lang.reflect.Member;

public class AdminRepository extends Repository<Admin,Integer>{
    public AdminRepository() {
        super(Admin.class);
    }

}
