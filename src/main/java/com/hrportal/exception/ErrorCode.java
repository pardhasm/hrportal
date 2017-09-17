package com.hrportal.exception;

/**
 * Created by saitejatokala on 27/05/16.
 */
public interface ErrorCode {
    String REFRESH_CART = "411";
    String SLOT_NOT_AVAILABLE = "422";
    String PAYMENT_RECALCULATE = "419";
    String MIN_CART_VALUE_ERROR = "420";
    String CART_ERROR = "421";
    String PAYMENT_FAILED = "400";
    String REFERRAL_CODE_INVALID = "400";
    String REFERRAL_NOT_ELIGIBLE = "401";
}
