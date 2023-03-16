package com.example;

import javax.xml.ws.Endpoint;

public class OrderServicePublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/orderstatuscheck", new OrderServiceImpl());
        System.out.println("Start service "+"http://localhost:8081/orderstatuscheck?wsdl");
    }

}