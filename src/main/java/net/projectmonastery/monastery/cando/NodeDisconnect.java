package net.projectmonastery.monastery.cando;


import net.projectmonastery.monastery.api.core.Node;

import java.util.concurrent.CompletableFuture;

/**
 * Created by Arnon Moscona on 7/7/2015.
 * A capability to force node disconnect (orderly shutdown)
 */
public interface NodeDisconnect {
    /**
     * Instructs the node to disconnect and clean resources.
     * May clear the ID (implementation dependent).
     * May not take effect immediately.
     * Access to the node while the disconnect process is incomplete may be unsafe (implementation dependent).
     * @return a CompletableFuture that completes when the shutdown process is complete.
     */
    CompletableFuture<Node> disconnect();
}
