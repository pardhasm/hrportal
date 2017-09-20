package com.hrportal.service;

import com.hrportal.model.RestAccessToken;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public interface IRestAccessTokenService {

    List<RestAccessToken> getAll();

    RestAccessToken get(Long id) throws NotFoundException;

    RestAccessToken save(RestAccessToken restAccessToken);

    RestAccessToken update(Long id, RestAccessToken restAccessToken) throws NotFoundException;

    RestAccessToken delete(Long id) throws NotFoundException;
}
