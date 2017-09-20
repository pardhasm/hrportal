package com.hrportal.service.impl;

import com.hrportal.model.RecordStatus;
import com.hrportal.model.RestAccessToken;
import com.hrportal.repository.RestAccessTokenRepository;
import com.hrportal.service.IRestAccessTokenService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@Service
public class RestAccessTokenServiceImpl implements IRestAccessTokenService {

    @Autowired
    private RestAccessTokenRepository restAccessTokenRepository;


    @Override
    public List<RestAccessToken> getAll() {
        return restAccessTokenRepository.findAll();
    }

    @Override
    public RestAccessToken get(Long id) throws NotFoundException {
        RestAccessToken restAccessToken = restAccessTokenRepository.findOne(id);
        if (Objects.isNull(restAccessToken)) {
            throw new NotFoundException("RestAccessToken Not found with given id : " + id);
        }
        return restAccessToken;
    }

    @Override
    public RestAccessToken save(RestAccessToken restAccessToken) {
        return restAccessTokenRepository.save(restAccessToken);
    }

    @Override
    public RestAccessToken update(Long id, RestAccessToken restAccessToken) throws NotFoundException {
        if (!restAccessTokenRepository.exists(restAccessToken.getId())) {
            throw new NotFoundException("RestAccessToken Not found with given id : " + restAccessToken.getId());
        }
        return restAccessTokenRepository.save(restAccessToken);
    }

    @Override
    public RestAccessToken delete(Long id) throws NotFoundException {
        RestAccessToken restAccessToken = restAccessTokenRepository.findOne(id);
        if (!Objects.isNull(restAccessToken)) {
            throw new NotFoundException("RestAccessToken Not found with given id : " + id);
        }
        restAccessToken.setRecordStatus(RecordStatus.INACTIVE);
        return restAccessTokenRepository.save(restAccessToken);
    }
}
