package com.args4j;
import org.kohsuke.args4j.Option;

import java.util.HashMap;
import java.util.Map;


public  class ArgumentParser{

    @Option(name="--oms-ip",usage = "Oms server ip")
     private String omsIP;

    @Option(name="--oms-port",usage= "Oms server port")
    private int omsPort;

     @Option(name="-l",aliases = {"--labels"},usage = "Label Option",handler = LabelsOptionHandler.class)
     private Map<String,String> labels=new HashMap<String, String>();

    public String getOmsIP() {
        return omsIP;
    }

    public void setOmsIP(String omsIP) {
        this.omsIP = omsIP;
    }

    public int getOmsPort() {
        return omsPort;
    }

    public void setOmsPort(int omsPort) {
        this.omsPort = omsPort;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }
}
