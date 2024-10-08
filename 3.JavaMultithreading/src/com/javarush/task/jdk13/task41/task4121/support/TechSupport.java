package com.javarush.task.jdk13.task41.task4121.support;

public class TechSupport {
    public void solve(String problem) {
        if (problem.matches(".*(завис|зависло|глючит|глюк|тормозит|лагает|ничего не понимаю|спасити).*")) {
            System.out.println("\t+ Спокойный как удав оператор колл-центра помог решить проблему.");
        } else {
            System.out.println("\t- Операторы колл-центра не смогли решить вопрос.");
            if (problem.matches(".*(мышь|мышка|клавиатура|монитор|принтер|картридж|катридж|гудит|жужжит|скрипит).*")) {
                System.out.println("\t+ Юркие хелпдески в полевых условиях исправили все что сломалось.");
            } else {
                System.out.println("\t- Ребятам из хелпдеска не удалось побороть проблему.");
                if (problem.matches(".*(системная ошибка|доменная политика|база данных|резервная копия|сервер).*")) {
                    System.out.println("\t+ Бородатый админ выслушал проблему и от этого она решилась сама собой.");
                } else {
                    System.out.println("\t- Сисадмин походил с бубном вокруг проблемы и продолжил плевать в потолок.");
                    if (problem.matches(".*(договор поставки|аутсорс|аутстафф|корпоратив|премия).*")) {
                        System.out.println("\t+ Директор департамента ИТ все рассмотрел и согласовал.");
                    } else {
                        System.out.println("\t- Директор департамента ИТ решил отправить весь департамент на курсы повышения квалификации.");
                    }
                }
            }
        }
    }
}
