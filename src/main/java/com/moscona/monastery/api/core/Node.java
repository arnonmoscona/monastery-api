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
    public Optional<IdType> getId();

    /**
     * Asynchronously retrieves the implementation's capability that matches the specified capability
     * (interface or class)
     * @param capabilityClass the specification of the desired capability
     * @return the implementation instance, wrapped in an Optional and a CompletableFuture. If the capability is not available
     * then the Optional will be empty.
     */
    public <T extends Capability>CompletableFuture<Optional<? extends T>> getCapability(Class<T> capabilityClass);
}
