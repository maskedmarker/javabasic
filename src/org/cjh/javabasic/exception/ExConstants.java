package org.cjh.javabasic.exception;

/**
 * TDF和mercury都采用这种异常code的设计模式。
 *
 */
public class ExConstants {

    // user related code: 1~99
    public static final String USER_NOT_FOUND = "1";
    public static final String USER_DELETED = "2";
    public static final String USER_NOT_LOCKED = "3";
    
    // account related code: 100~200
    public static final String ACCOUNT_NOT_FOUND = "100";
    public static final String ACCOUNT_DELETED = "200";
    public static final String ACCOUNT_NOT_LOCKED = "300";
    
    
}
