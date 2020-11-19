package com.sparta.engineering72.sakilaproject.services;

import com.sparta.engineering72.sakilaproject.entities.Inventory;
import com.sparta.engineering72.sakilaproject.respositories.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> getAllInventory(){
        return inventoryRepository.findAll();
    }

    public boolean isAvailable(Integer id){
        List<Inventory> inventoryList = getAllInventory();
        for(Inventory inventory : inventoryList){
            if(inventory.getInventoryId() == id) return true;
        }
        return false;
    }
}
