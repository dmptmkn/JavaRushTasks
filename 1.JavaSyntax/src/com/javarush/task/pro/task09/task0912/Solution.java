package com.javarush.task.pro.task09.task0912;

/* 
Проверка URL-адреса
*/

public class Solution {
    public static void main(String[] args) {
        String[] urls = {"https://javarush.ru", "https://google.com", "http://wikipedia.org", "facebook.com", "https://instagram", "codegym.cc"};
        for (String url : urls) {
            String protocol = checkProtocol(url);
            String domain = checkDomain(url);

            System.out.println("У URL-адреса - " + url + ", сетевой протокол - " + protocol + ", домен - " + domain);
        }
    }

    public static String checkProtocol(String url) {
        boolean isProtocolCorrect = url.startsWith("http") || url.startsWith("https");
        boolean isProtocolHttp = url.startsWith("http");
        boolean isProtocolHttps = url.startsWith("https");
        String protocol = null;

        if (isProtocolCorrect) {
            if (isProtocolHttp) {
                protocol = "http";
            }
            if (isProtocolHttps) {
                protocol = "https";
            }
        } else {
            protocol = "неизвестный";
        }
        return protocol;
    }

    public static String checkDomain(String url) {

        boolean isDomainCorrect = url.endsWith("com") || url.endsWith("com") || url.endsWith("net") || url.endsWith("org") || url.endsWith("ru");
        boolean isDomainCom = url.endsWith("com");
        boolean isDomainNet = url.endsWith("net");
        boolean isDomainOrg = url.endsWith("org");
        boolean isDomainRu = url.endsWith("ru");
        String domain = null;

        if (isDomainCorrect) {
            if (isDomainCom) {
                domain = "com";
            }
            if (isDomainOrg) {
                domain = "org";
            }
            if (isDomainNet) {
                domain = "net";
            }
            if (isDomainRu) {
                domain = "ru";
            }
        } else {
            domain = "неизвестный";
        }
        return domain;
    }
}
