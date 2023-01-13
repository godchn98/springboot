package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GlobalSuperstoreContorller {
    
    List<Item> items = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        int index = getIndexFromID(id);
        model.addAttribute("item", index == Constants.NOT_FOUND ? new Item() : items.get(index));
        model.addAttribute("categories", Constants.CATEGORIES);
        return "form";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(Item item, RedirectAttributes redirectAttributes) {
        int index = getIndexFromID(item.getId());
        if (index == Constants.NOT_FOUND) {
            items.add(item);
        } else {
            items.set(index, item);
        }
        redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", items);
        return "inventory";
    }

    public int getIndexFromID(String id){
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

}
