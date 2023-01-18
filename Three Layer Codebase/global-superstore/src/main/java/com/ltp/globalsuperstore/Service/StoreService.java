package com.ltp.globalsuperstore.Service;

import java.util.List;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import com.ltp.globalsuperstore.Item;
import com.ltp.globalsuperstore.Repository.StoreRepository;

public class StoreService {

    StoreRepository storeRepository = new StoreRepository();

    public Item getItem(int index) {
        return storeRepository.getItem(index);
    }

    public void addItem(Item item){
        storeRepository.addItem(item);
    }

    public void updateItem(Item item, int index){
        storeRepository.updateItem(item, index);
    }

    public List<Item> getItems() {
        return storeRepository.getItems();
    }
    

}
