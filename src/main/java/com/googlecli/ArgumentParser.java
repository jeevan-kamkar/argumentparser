package com.googlecli;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;

import java.util.HashMap;
import java.util.Map;

public class ArgumentParser  extends OptionsBase {
@Option(
        name = "oms-ip",
        help = "oms server ip",
        defaultValue="127.0.0.1"

)
public String omsIP;
@Option(
        name = "oms-port",
        help="Oms server port",
        defaultValue="22345"
)
   public int omsPort;
// Map  is not supproted as default type
/*@Option(
        name="--labels",
        abbrev = 'l',
        help="label pair",
        defaultValue="region=r1"
)

   public Map<String,String> labels=new HashMap<>();
*/
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
 /*
    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }
    */
}
