package com.turfmanagement.service;

import com.turfmanagement.model.Slot;
import java.util.List;

public interface SlotService {
    List<Slot> getAvailableSlots(int turfId);

    Slot getSlotById(int id);
}
