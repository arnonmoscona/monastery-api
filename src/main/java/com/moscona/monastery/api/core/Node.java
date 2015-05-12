package com.moscona.monastery.api.core;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Created by Arnon Moscona on 5/8/2015.
 * The Node interface is the root interface between local code and the cluster.
 * See documentation at the monastery-docs project: https://github.com/arnonmoscona/monastery-docs
 */
public interface Node<IdType> {
    /**
     * @return the unique ID assigned by the cluster to the node after announcement.
     * May be null before the node is in the joined state.
     */
    Optional<IdType> getId();

    /**
     * @return the cluster state of the node
     */
    NodeState getState();

    /**
     * Call announce when the node is ready to join the cluster.
     * Some implementation may call this method implicitly.
     * Calling this method multiple times is harmless (implementation contract), but would not cause re-announcement
     * unless a previous announcement failed. The logic is up to the implementation.
     * Having said this, it is not a good idea to call multiple time if the future completion has non-idempotent
     * side effects.
     * @return a CompletableFuture allowing a continuation after the node has joined the cluster,
     * or a definite failure occurs.
     */
    CompletableFuture<Node> announce();

    /**
     * Asynchronously retrieves the implementation's capability that matches the specified capability
     * (interface or class)
     * @param capabilityClass the specification of the desired capability
     * @return the implementation instance, wrapped in an Optional and a CompletableFuture. If the capability is not available
     * then the Optional will be empty.
     */
    <T extends Capability>CompletableFuture<Optional<? extends T>> getCapability(Class<T> capabilityClass);
}
