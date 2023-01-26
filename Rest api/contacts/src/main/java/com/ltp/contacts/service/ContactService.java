package com.ltp.contacts.service;

import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.repository.ContactRepository;

public interface ContactService {
    Contact getContactById(String id);

    void saveContact(Contact contact);

    void updateContact(String id, Contact contact);

    void deleteContact(String id);
}
