package stormtest.drpc;

import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.drpc.LinearDRPCTopologyBuilder;

@SuppressWarnings("deprecation")
public class TopologySubmitter {
    public static void main(String[] args)  throws Exception{
        Config config = new Config();
        config.setDebug(true);
        
        LinearDRPCTopologyBuilder builder = new LinearDRPCTopologyBuilder("exclamation");
        builder.addBolt(new ExclaimBolt(), 3);
        
        StormSubmitter.submitTopology("exclamation-drpc", config, builder.createRemoteTopology());
    }
}
