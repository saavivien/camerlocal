/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.exception;

/**
 *
 * @author vivien saa
 */
public class CamerLocalException extends Exception {

    public CamerLocalException() {
        super();
    }

    public CamerLocalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CamerLocalException(String message, Throwable cause) {
        super(message, cause);
    }

    public CamerLocalException(String message) {
        super(message);
    }

    public CamerLocalException(Throwable cause) {
        super(cause);
    }

}
