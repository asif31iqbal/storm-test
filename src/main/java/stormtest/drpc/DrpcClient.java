package stormtest.drpc;

import java.util.Map;

import org.apache.storm.utils.DRPCClient;
import org.apache.storm.utils.Utils;

public class DrpcClient {
    public static void main(String[] args) throws Exception {
        Map conf = Utils.readStormConfig();

        DRPCClient client = new DRPCClient(conf, "localhost", 3772);
        String result = client.execute("exclamation", args[0]);
        
        System.out.println("\n!!! Drpc result:" + result);
    }
}
