package com.qlkara.utilities;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckData {

    public static boolean checkName(String name) {
        if (name == null || name.length() == 0) {
            return false;
        } else {
            String pattern = "[a-zA-Z]";
            return name.matches(pattern);
        }
    }

    public static boolean checkPassword(String pass) {

        if (pass == null || pass.length() == 0) {
            return false;
        } else {
            String pattern = "^[a-zA-Z_-{6,18}]";
            return pass.matches(pattern);
        }
    }

    public static boolean checkPhone(String phone) {
        if (phone == null || phone.length() == 0) {
            return false;
        } else {
            String pattern = "^0+[0-9]{9}";
            return phone.matches(pattern);
        }
    }

    public static boolean checkDate(Date date) {
        if (date == null) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkAddress(String address) {
        if (address == null || address.length() == 0) {
            return false;
        } else {
            String pattern = "[a-zA-Z0-9]{3-80}";
            return address.matches(pattern);
        }
    }
}
