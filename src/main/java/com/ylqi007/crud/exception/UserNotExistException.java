package com.ylqi007.crud.exception;

/**
 * 自定义的 Exception。
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("User does not exits. This is a self-defined Exception, com.ylqi007.crud.exception.UserNotExistException.");
    }
}
