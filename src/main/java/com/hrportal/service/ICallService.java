package com.hrportal.service;

import com.hrportal.model.Call;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
public interface ICallService {

    List<Call> getAllCalls();

    Call getCall(long id) throws NotFoundException;

    Call save(Call call);

    Call updateCall(long id, Call call) throws NotFoundException;
}
