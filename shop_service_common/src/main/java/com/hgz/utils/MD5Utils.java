package com.hgz.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.StringUtils;

public class MD5Utils {

    /**
     * 账户密码加密
     * @param username
     * @param pwd
     * @return
     */
    public static String MD5Pwd(String username,String pwd){
        String hashAlgorithmName = "MD5";//加密方式
        Object crdentials=pwd;
        ByteSource salt = ByteSource.Util.bytes(username);//以账号作为盐值
        int hashInterations=3;//加密1024次
        return new SimpleHash(hashAlgorithmName,crdentials,salt,hashInterations).toString();
    }


    public static void main(String[] args) {
        String name="hgz";
        System.out.println(MD5Pwd(name,"342"));


    }
}
