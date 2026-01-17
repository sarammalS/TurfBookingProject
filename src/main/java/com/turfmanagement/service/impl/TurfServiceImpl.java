package com.turfmanagement.service.impl;

import com.turfmanagement.dao.TurfDAO;
import com.turfmanagement.dao.impl.TurfDAOImpl;
import com.turfmanagement.model.Turf;
import com.turfmanagement.service.TurfService;
import java.util.List;

public class TurfServiceImpl implements TurfService {
    private TurfDAO turfDAO = new TurfDAOImpl();

    @Override
    public List<Turf> getAllTurfs() {
        return turfDAO.getAllTurfs();
    }

    @Override
    public Turf getTurfById(int id) {
        return turfDAO.getTurfById(id);
    }

    @Override
    public boolean addTurf(Turf turf) {
        return turfDAO.addTurf(turf);
    }
}
