package com.jcommander;

import com.beust.jcommander.DynamicParameter;
import com.beust.jcommander.Parameter;

import java.util.HashMap;
import java.util.Map;


public class ArgumentParaser {
    @Parameter(names="--oms-ip")
     String omsIP;

    @Parameter(names="--oms-port")
     int omsPort;

    @DynamicParameter(names={"-l","--labels"})
    Map<String,String> labels=new HashMap<String, String>();

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
