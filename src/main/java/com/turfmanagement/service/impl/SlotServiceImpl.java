package com.turfmanagement.service.impl;

import com.turfmanagement.dao.SlotDAO;
import com.turfmanagement.dao.impl.SlotDAOImpl;
import com.turfmanagement.model.Slot;
import com.turfmanagement.service.SlotService;
import java.util.List;

public class SlotServiceImpl implements SlotService {
    private SlotDAO slotDAO = new SlotDAOImpl();

    @Override
    public List<Slot> getAvailableSlots(int turfId) {
        return slotDAO.getSlotsByTurfId(turfId);
    }

    @Override
    public Slot getSlotById(int id) {
        return slotDAO.getSlotById(id);
    }
}
