package org.example.club_sportif.Repository;

import org.example.club_sportif.Entities.Entraineur;

public class EntraineurRepository extends Repository<Entraineur,Integer>{
    public EntraineurRepository() {
        super(Entraineur.class);
    }
}