package com.jcommander;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

/*  Usage
    Pass below command line params
    --oms-ip 127.0.0.1 --oms-port 22345 -l region=r1 -l environment=dev
 */
public class JCommanderMain {

    public static void main(String []args){
        ArgumentParaser argParser=new ArgumentParaser();
         JCommander.newBuilder()
                 .addObject(argParser)
                 .args(args)
                 .build();
        System.out.println(argParser.getOmsIP());
        System.out.println(argParser.getLabels().keySet());
        System.out.println(argParser.getOmsPort());

    }
}
