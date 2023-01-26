package com.ltp.contacts.service;

import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.repository.ContactRepository;

public interface ContactService {
    Contact getContactById(String id);
}
