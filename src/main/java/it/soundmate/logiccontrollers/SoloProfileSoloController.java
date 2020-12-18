/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 12/12/20, 19:39
 */

package it.soundmate.logiccontrollers;

import it.soundmate.database.SoloDao;
import it.soundmate.model.Solo;
import it.soundmate.model.User;

public class SoloProfileSoloController {

    private SoloDao soloDao = SoloDao.getInstance();

    public Solo getSoloByUser(User user) {
        return soloDao.getSoloByUser(user);
    }

    public boolean addGenre(String genre, Solo solo) {
        return soloDao.addGenreToSolo(genre, solo);
    }
}

