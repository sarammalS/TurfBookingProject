package com.turfmanagement.service;

import com.turfmanagement.model.Turf;
import java.util.List;

public interface TurfService {
    List<Turf> getAllTurfs();

    Turf getTurfById(int id);

    boolean addTurf(Turf turf);
}
