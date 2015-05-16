package com.moscona.monastery.cando;

import com.moscona.monastery.api.core.Capability;
import com.moscona.monastery.api.core.Node;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Created by Arnon Moscona on 5/8/2015.
 * The node discovery capability allows nodes to know about the existence of other nodes in the cluster.
 * See documentation at the monastery-docs project: https://github.com/arnonmoscona/monastery-docs
 */
public interface NodeDiscovery<IdType> extends Capability {
    /**
     * Add an action to be invoked when new nodes are discovered by the cluster
     * @param action the action to be called when a new node is discovered. the action consumes a NodeInformation<IdType>
     * @return a reference to the node discovery capability
     */
    NodeDiscovery addNodeDiscoveryListener(Consumer<NodeInformation<IdType>> action);

    /**
     * @return a list of all the nodes discovered in the life of the cluster. Note that the list could be long.
     */
    CompletableFuture<List<NodeInformation<IdType>>> listKnowNodes();
}
