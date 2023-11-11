package com.management.service;

import com.management.model.Orders;
import com.management.model.Item;
import com.management.helper.helper;
import com.management.model.Returns;
import com.management.model.dto.ReturnDTO;
import com.management.model.dto.StatusRequest;
import com.management.model.dto.PendingReturnDTO;
import com.management.model.dto.ResponseReturn;
import com.management.repository.OrderRepo;
import com.management.repository.ItemRepo;
import com.management.repository.ReturnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;

@Service
public class ReturnService implements IReturnService{

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ReturnRepo returnRepo;

    @Autowired
    private ItemRepo itemRepo;

    public Returns addtoDBreturns(ReturnDTO returnDto,Orders orders) {
        Item item = itemRepo.findById(orders.getItem_id());
        if (item != null) {
            String token = helper.generateRandomString(returnDto.getOrderId());
            double estimatedReturn = item.getPrice() * returnDto.getQuantity();
            int quantity = item.getQuantity() - returnDto.getQuantity();
            String status = "AWAITING_APPROVAL";
            Returns createReturns = new Returns(
                    orders.getId(),
                    estimatedReturn,
                    token,
                    status,
                    returnDto.getItemId(),
                    returnDto.getQuantity()
            );
            returnRepo.save(createReturns);
            item.setQuantity(quantity);
            itemRepo.save(item);
            Returns returns = returnRepo.findReturnsObjectByToken(token);   
            return returns;
    }
    return null;
    }

    @Override
    public Returns addReturnRequest(ReturnDTO returnDto){
        System.out.println(returnDto.getEmail());
        Orders orders = orderRepo.findOrderByOrderIdAndEmail(returnDto.getOrderId(), returnDto.getEmail());
        System.out.println(orders);
        if (orders != null) {
            Returns returnObj = returnRepo.findReturnsObjectByOrderId(orders.getId());
            Item itemObj = itemRepo.findById(returnDto.getItemId());
            if(returnDto.getQuantity() <= itemObj.getQuantity()){
                if (returnObj == null){
                    return addtoDBreturns(returnDto, orders);
                    }
                if (returnObj != null){
                    if(returnObj.getItem_id() != returnDto.getItemId()){
                        return addtoDBreturns(returnDto, orders);
                    }
                    if(returnObj.getItem_id() == returnDto.getItemId() && returnObj.getStatus() != "AWAITING_APPROVAL"){
                        return addtoDBreturns(returnDto, orders);
                    }
                    }
            }
            }
        return null;
    }

    @Override
    public List<Returns> pendingReturnRequest(PendingReturnDTO pendingReturnDTO) {
        Orders orderObj = orderRepo.findOrderByOrderIdAndEmail(pendingReturnDTO.getOrderId(), pendingReturnDTO.getEmail());
        List<Returns> returnObj = returnRepo.findAllReturnsObjectByOrderId(orderObj.getId());
        return returnObj;
    }

    @Override
    public ResponseReturn getReturnRequest(int id){
        Returns returnObj = returnRepo.findReturnsObjectById(id);
        if(returnObj != null && returnObj.getStatus() != "REJECTED"){
            Orders orderObj = orderRepo.findOrderById(returnObj.getOrderid());
            Item itemObj = itemRepo.findById(returnObj.getItem_id());
            ResponseReturn response = new ResponseReturn(
                orderObj.getOrderid(), 
                returnObj.getEstimated_return(), 
                returnObj.getToken(), 
                returnObj.getStatus(), 
                itemObj.getItem_name(), 
                returnObj.getQuantity(), 
                itemObj.getQc(), 
                itemObj.getPrice());
            return response;
        }
        return null;
    }


    public String editStatusQuality(int itemid,Returns returnObj,StatusRequest status){
        if(returnObj !=null){
            Item itemObj = itemRepo.findById(itemid);
            if("AWAITING_APPROVAL".equalsIgnoreCase(returnObj.getStatus())){
            if ("ACCEPTED".equalsIgnoreCase(status.getStatusqc()) || "REJECTED".equalsIgnoreCase(status.getStatusqc())) {
                returnObj.setStatus("COMPLETE");
                returnRepo.save(returnObj);
                itemObj.setQc(status.getStatusqc());
                itemRepo.save(itemObj);
            }
        }
        return null;
    }
    return null;
    }

    @Override
    public String editQcStatus(int id,int itemid,StatusRequest status){
        Returns returnObj = returnRepo.findReturnsObjectByIdAndItemId(id,itemid);
        return editStatusQuality(itemid, returnObj, status);
    }

}
    