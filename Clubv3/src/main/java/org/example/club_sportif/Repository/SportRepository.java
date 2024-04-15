package org.example.club_sportif.Repository;

import org.example.club_sportif.Entities.Sport;

public class SportRepository extends Repository<Sport,Integer>{
    public SportRepository() {
        super(Sport.class);
    }
}