package com.hrportal.constants;

public interface APIErrorMessages {
    String APP_ACCESS_TOKEN_NULL = "AppAccessToken could not be generated for user id ";
    String USER_DOES_NOT_EXIT = "User does not exist.";
    String USER_ID_NULL_FOR_UPDATE = "User id null for user update request.";
    String LOCATION_NOT_SERVICEABLE_REASON_DESCRIPTION = "Sorry! We are currently not servicing this location. But we will be launching here soon.";
    String INVALID_USER_REQUEST = "Invalid user request.";
    String INVALID_USER_ID = "Invalid user id as null.";
    String INVALID_USER_LOGIN = "Email or password is incorrect. Please retry.";
    String EMAIL_NOT_REGISTERED = "Email is not registered with us.";
    String INVALID_USER_ADDRESS_ID = "Invalid user address id.";
    String INVALID_PRODUCT_ID = "Invalid product id ";
    String USER_EMAIL_EXISTS = "The email id is already registered.";
    String USER_MOBILE_EXISTS = "The mobile number is already registered.";
    String INVALID_ACCESS_TOKEN = "Invalid Access Token.";
    String ACCESS_TOKENS_NOT_FOUND = "Access Tokens Not Found.";
    String MOBILE_VERIFICATION_FAILED = "User Mobile Verification Failed.";
    String CANNOT_RESET_PASSWORD = "Cannot Reset Password.";
    String LOGIN_FAILED_INCORRECT_PASSWORD = "User Login Failed (Incorrect Password) ";
    String LOGIN_FAILED_INVALIED_EMAIL_OR_MOBILE = "User Login Failed (Invalid Email Or Mobile) ";
    String INVALID_ORDER_STATUS = "Invalid Order Status : ";
    String INVALID_ORDER_ID = "Invalid OrderId : ";
    String INVALID_SHOPIFY_LOGIN = "Shopify Login Failed! Please try again.";
    String INVALID_CREATE_ORDER_REQUEST = "Create order request is invalid";
    String MANDATORY_PRODUCT_CREATE_PARAM_NULL = "Mandatory params for product creation missing";
    String INVALID_OLD_PASSWORD = "Old Password is Not correct";
    String NEW_OLD_PASSWORD_SAME = "Old Password and New Password is Same";
    String INVALID_PASSWORD = "Password is invalid";

    String CART_PRICE_MISMATCH = "Our product prices have changed!";
    String CART_PRODUCT_STOCK_OUT = "Few items added in your cart is out of stock.";
    String CART_PRODUCT_STOCK_OUT_LOCALITY = "Out of stock in your area";
    String CART_PRODUCT_STOCK_OUT_PAPER_BAG = " Paper bag is out of stock";
    String INVALID_CART = "Invalid Cart";
    String INVALID_SLOT_CART = "Selected Slot is not Available";
    String NO_COMMON_SLOT_AVAILABLE = "No common delivery slot available for the items in the cart";
    String NO_DELIVERY_SLOT_AVAILABLE = "No delivery slot available for the items in the cart";
    String PAYMENT_FAILED = "Payment Failed";

    String REFERRAL_CODE_INVALID = "Referral Code is Invalid";
    String REFERRAL_NOT_ELIGIBLE = "User is not eligible for referral";

    String REFERRAL_ALL_OFFERS = "All referral offers for the user";
    String REFERRAL_NO_OFFERS = "No offers found for the user";
    String TRUE_CALLER_HASH_WRONG = "Not able to Verify Using truecaller";
    String CART_INVALID_QUANTITY = "Invalid item quantity";
}