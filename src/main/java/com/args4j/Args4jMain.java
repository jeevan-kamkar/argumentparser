package com.args4j;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Args4jMain {
/*  Usage
    Pass below command line params
    --oms-ip 127.0.0.1 --oms-port 22345 -l region=r1,environment=dev
 */
 public static void main(String args[]){
     ArgumentParser argParser=new ArgumentParser();
     CmdLineParser parser = new CmdLineParser(argParser);
     try {
         parser.parseArgument(args);

     } catch (CmdLineException e) {
         // handling of wrong arguments
         System.err.println(e.getMessage());
         parser.printUsage(System.err);
     }
     System.out.println(argParser.getOmsIP());
     System.out.println(argParser.getLabels().keySet());
     System.out.println(argParser.getOmsPort());
 }
}
