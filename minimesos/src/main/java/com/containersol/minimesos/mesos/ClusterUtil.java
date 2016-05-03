package com.containersol.minimesos.mesos;

import com.containersol.minimesos.cluster.MesosAgent;
import com.containersol.minimesos.cluster.ZooKeeper;

import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * Helper methods for ClusterArchitecture
 */
public class ClusterUtil {

    public static ClusterArchitecture.Builder withAgent(Integer numberOfAgents) {
        ClusterArchitecture.Builder builder = new ClusterArchitecture.Builder().withZooKeeper();
        IntStream.range(0, numberOfAgents).forEach(x -> builder.withAgent());
        return builder;
    }

    public static <T extends MesosAgent> ClusterArchitecture.Builder withAgent(Integer numberOfAgents, Function<ZooKeeper, T> agent) {
        ClusterArchitecture.Builder builder = new ClusterArchitecture.Builder().withZooKeeper();
        IntStream.range(0, numberOfAgents).forEach(x -> builder.withAgent(agent::apply));
        return builder;
    }
}