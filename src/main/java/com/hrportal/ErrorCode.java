package com.hrportal;

public interface ErrorCode {
    String INPUT_VALIDATION_ERROR = "INPUT_VALIDATION_ERROR";
    String APPLICATION_ERROR = "APPLICATION_ERROR";
    String LOGIN_FAILED = "LOGIN_FAILED";
    String AUTHORIZATION_FAILED = "AUTHORIZATION_FAILED";
    String ENTITY_NOT_FOUND = "ENTITY_NOT_FOUND";
    String UNSUPPORTED_DEVICE = "UNSUPPORTED_DEVICE";
    String DUPLICATE_ENTITY_EXCEPTION = "DUPLICATE ENTITY";
    String ACCESS_DENIED_EXCEPTION = "ACCESS DENIED";

    /***
     *     _____      _                        _   _____                      _____           _
     *    |_   _|    | |                      | | |  ___|                    /  __ \         | |
     *      | | _ __ | |_ ___ _ __ _ __   __ _| | | |__ _ __ _ __ ___  _ __  | /  \/ ___   __| | ___ ___
     *      | || '_ \| __/ _ | '__| '_ \ / _` | | |  __| '__| '__/ _ \| '__| | |    / _ \ / _` |/ _ / __|
     *     _| || | | | ||  __| |  | | | | (_| | | | |__| |  | | | (_) | |    | \__/| (_) | (_| |  __\__ \
     *     \___|_| |_|\__\___|_|  |_| |_|\__,_|_| \____|_|  |_|  \___/|_|     \____/\___/ \__,_|\___|___/
     *
     *
     */
    Integer DB_UNAVAILABLE = 1000;
}

