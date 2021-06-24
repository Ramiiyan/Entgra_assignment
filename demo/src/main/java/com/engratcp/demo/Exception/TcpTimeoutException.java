package com.engratcp.demo.Exception;

import java.net.SocketTimeoutException;


public class TcpTimeoutException extends SocketTimeoutException {

    public TcpTimeoutException(String msg) {
        super("Tcp Server Timeout (10s) :"+ msg);
    }
}
