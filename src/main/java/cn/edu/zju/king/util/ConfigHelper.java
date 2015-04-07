package cn.edu.zju.king.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * Created by king on 2015/4/7.
 */
public class ConfigHelper {

    public static List<Account> getAccounts(String fp) {
        if (fp == null) {
            fp = "/account.json";
        }

        ObjectMapper mp = new ObjectMapper();

        return mp.readValue(this.getClass().getResourceAsStream(fp));
    }
}
