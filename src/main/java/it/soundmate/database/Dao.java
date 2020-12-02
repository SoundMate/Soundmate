/*
 * Copyright (c) 2020.
 * This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
 * Last Modified: 30/11/20, 16:35
 */

package it.soundmate.database;

public interface Dao<T> {
    T getByID(long id);
}
