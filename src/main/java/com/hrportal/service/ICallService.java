package com.hrportal.service;

import com.hrportal.model.Call;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface ICallService {

    List<Call> getAll();

    Call get(Long id) throws NotFoundException;

    Call save(Call call);

    Call update(Long id, Call call) throws NotFoundException;

    Call delete(Long id) throws NotFoundException;
}
