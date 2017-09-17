package com.hrportal.service.impl;

import com.hrportal.model.Call;
import com.hrportal.repository.CallRepository;
import com.hrportal.service.ICallService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public class CallServiceImpl implements ICallService {

    @Autowired
    private CallRepository callRepository;


    @Override
    public List<Call> getAllCalls() {
        return callRepository.findAll();
    }

    @Override
    public Call getCall(long id) throws NotFoundException {
        Call call = callRepository.findOne(id);
        if (Objects.isNull(call)) {
            throw new NotFoundException("Call Not found with given id : " + id);
        }
        return call;
    }

    @Override
    public Call save(Call call) {
        return callRepository.save(call);
    }

    @Override
    public Call updateCall(long id, Call call) throws NotFoundException {
        if (!callRepository.exists(call.getId())) {
            throw new NotFoundException("Call Not found with given id : " + call.getId());
        }
        return callRepository.save(call);
    }
}
