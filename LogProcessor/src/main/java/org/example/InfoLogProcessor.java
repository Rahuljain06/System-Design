package org.example;

public class InfoLogProcessor extends LogProcessor{

    InfoLogProcessor(LogProcessor nextlogProcessor){
        super(nextlogProcessor);
    }

    public void log(int logLevel, String msg){
        if(logLevel ==INFO){
            System.out.println("Info - " + msg);
        }
        else{
            super.log(logLevel,msg);
        }
    }
}
