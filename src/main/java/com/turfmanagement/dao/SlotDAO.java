package com.turfmanagement.dao;

import com.turfmanagement.model.Slot;
import java.util.List;

public interface SlotDAO {
    List<Slot> getSlotsByTurfId(int turfId);

    boolean updateSlotAvailability(int slotId, boolean isAvailable);

    Slot getSlotById(int id);
}
