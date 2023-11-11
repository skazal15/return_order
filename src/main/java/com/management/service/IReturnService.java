package com.management.service;

import java.util.List;

import com.management.model.Returns;
import com.management.model.dto.PendingReturnDTO;
import com.management.model.dto.ResponseReturn;
import com.management.model.dto.StatusRequest;
import com.management.model.dto.ReturnDTO;

public interface IReturnService {
    public Returns addReturnRequest(ReturnDTO returnDto);
    public List<Returns> pendingReturnRequest(PendingReturnDTO pendingReturnDTO);
    public ResponseReturn getReturnRequest(int id);
    public String editQcStatus(int id,int itemid,StatusRequest status);
}