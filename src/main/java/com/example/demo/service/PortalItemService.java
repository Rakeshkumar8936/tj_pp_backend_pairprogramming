package com.example.demo.service;

import com.example.demo.entity.PortalItem;
import com.example.demo.repository.PortalItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortalItemService {
    private final PortalItemRepository portalItemRepository;

    public PortalItemService(PortalItemRepository portalitemRepository){
        this.portalItemRepository = portalitemRepository;
    }

    public List<PortalItem> getAllPortalItems(){
        return portalItemRepository.findAll();
    }

    public PortalItem createPortalItem(PortalItem portalItem) {
        return portalItemRepository.save(portalItem);
    }

    public PortalItem updatePortalItem(Long id, PortalItem updatedItem) {

        PortalItem existingItem = portalItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portal item not found"));

        existingItem.setTitle(updatedItem.getTitle());
        existingItem.setIcon(updatedItem.getIcon());
        existingItem.setCount(updatedItem.getCount());

        return portalItemRepository.save(existingItem);
    }

    public void deletePortalItem(Long id) {

        if (!portalItemRepository.existsById(id)) {
            throw new RuntimeException("Portal item not found");
        }

        portalItemRepository.deleteById(id);
    }

}
