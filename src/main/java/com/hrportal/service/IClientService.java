package com.hrportal.service;

import com.hrportal.model.Client;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
public interface IClientService {

    List<Client> getAll();

    Client get(Long id) throws NotFoundException;

    Client save(Client client);

    Client update(Long id, Client client) throws NotFoundException;

    Client delete(Long id) throws NotFoundException;
}

