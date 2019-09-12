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
public class CamerLocalServiceException extends CamerLocalException {

    public CamerLocalServiceException() {
        super();
    }

    public CamerLocalServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CamerLocalServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CamerLocalServiceException(String message) {
        super(message);
    }

    public CamerLocalServiceException(Throwable cause) {
        super(cause);
    }
}
