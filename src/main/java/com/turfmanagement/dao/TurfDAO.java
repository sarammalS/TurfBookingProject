package com.turfmanagement.dao;

import com.turfmanagement.model.Turf;
import java.util.List;

public interface TurfDAO {
    List<Turf> getAllTurfs();

    Turf getTurfById(int id);

    boolean addTurf(Turf turf);
}
