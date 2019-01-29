package com.googlecli;

import com.google.devtools.common.options.OptionsParser;

/*  Usage
    Pass below command line params
    --oms-ip 127.0.0.1 --oms-port 22345
 */

public class GoogleCliMain {
public static  void  main(String []args){
    OptionsParser parser = OptionsParser.newOptionsParser(ArgumentParser.class);
    parser.parseAndExitUponError(args);
    ArgumentParser argParser = parser.getOptions(ArgumentParser.class);
    System.out.println(argParser.getOmsIP());
   // System.out.println(argParser.getLabels().keySet());
    System.out.println(argParser.getOmsPort());

}
}

