package com.java24hours.ws;

import javax.xml.ws.*;

public class SquareRootServerPublisher {
    public static void main(String[] args) {
        SquareRootServerImpl srsi = new SquareRootServerImpl();
        Endpoint.publish("http://127.0.0.1:5335/service", srsi);
    }
}
