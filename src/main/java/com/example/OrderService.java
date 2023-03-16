package com.example;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style= SOAPBinding.Style.RPC)
public interface OrderService {

    @WebMethod(operationName = "checkOrderStatus")
    public String checkOrderStatus(
            @WebParam(name = "OrderNumber") String orderNumber,
            @WebParam(name = "CompanyID") String companyID
    );

}