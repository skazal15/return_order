package com.management.controller;

import java.util.List;

import com.management.model.Returns;
import com.management.model.dto.PendingReturnDTO;
import com.management.model.dto.ResponseReturn;
import com.management.model.dto.ReturnDTO;
import com.management.model.dto.StatusRequest;
import com.management.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commerce")
public class RetrunController {
    @Autowired
    private ReturnService returnService;

    @PostMapping("/returns")
    public ResponseEntity<Returns> addReturnRequest(@RequestBody ReturnDTO returnDTO) {
        return new ResponseEntity<Returns>(returnService.addReturnRequest(returnDTO),HttpStatus.CREATED);
    }

    @GetMapping("/returns/{id}")
    public ResponseEntity<ResponseReturn> getReturn(@PathVariable int id){
        System.out.print(id);
        return new ResponseEntity<ResponseReturn>(returnService.getReturnRequest(id),HttpStatus.OK);
    }

    @PostMapping("/pending/returns")
    public ResponseEntity<List<Returns>> requestReturnPending(@RequestBody PendingReturnDTO pendingReturnDTO){
        return new ResponseEntity<List<Returns>>(returnService.pendingReturnRequest(pendingReturnDTO),HttpStatus.OK);
    }

    @PutMapping("/returns/{id}/item/{itemid}/qc/status")
    public ResponseEntity<String> updateQCStatus(@PathVariable int id, @PathVariable int itemid,@RequestBody StatusRequest statusRequest){
        System.out.print(id);
        System.out.print(itemid);
        return new ResponseEntity<String>(returnService.editQcStatus(id,itemid,statusRequest),HttpStatus.OK);
    }
}