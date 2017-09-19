package com.hrportal.service.impl;

import com.hrportal.model.Client;
import com.hrportal.model.RecordStatus;
import com.hrportal.repository.ClientRepository;
import com.hrportal.service.IClientService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 19-09-2017.
 */
@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client get(Long id) throws NotFoundException {
        Client client = clientRepository.findOne(id);
        if (Objects.isNull(client)) {
            throw new NotFoundException("Client Not found with given id : " + id);
        }
        return client;
    }

    @Override
    public Client save(Client call) {
        return clientRepository.save(call);
    }

    @Override
    public Client update(Long id, Client client) throws NotFoundException {
        if (!clientRepository.exists(client.getId())) {
            throw new NotFoundException("Client Not found with given id : " + client.getId());
        }
        return clientRepository.save(client);
    }

    @Override
    public Client delete(Long id) throws NotFoundException {
        Client client = clientRepository.findOne(id);
        if (!Objects.isNull(client)) {
            throw new NotFoundException("Client Not found with given id : " + id);
        }
        client.setRecordStatus(RecordStatus.INACTIVE);
        return clientRepository.save(client);
    }
}
