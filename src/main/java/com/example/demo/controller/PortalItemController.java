package com.example.demo.controller;

import com.example.demo.entity.PortalItem;
import com.example.demo.service.PortalItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portal")
public class PortalItemController {
    private final PortalItemService portalItemService;

    public PortalItemController(PortalItemService portalItemService){
        this.portalItemService=portalItemService;
    }

    @GetMapping("/items")
    public List<PortalItem> getAllPortalItems(){
        return portalItemService.getAllPortalItems();
    }

    @PostMapping("/items")
    public PortalItem createPortalItem(@RequestBody PortalItem portalItem) {
        return portalItemService.createPortalItem(portalItem);
    }

    @PutMapping("/items/{id}")
    public PortalItem updatePortalItem(
            @PathVariable Long id,
            @RequestBody PortalItem portalItem) {

        return portalItemService.updatePortalItem(id, portalItem);
    }

    @DeleteMapping("/items/{id}")
    public String deletePortalItem(@PathVariable Long id) {

        portalItemService.deletePortalItem(id);

        return "Portal item deleted successfully";
    }
}
