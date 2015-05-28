package com.moscona.monastery.cando;

/**
 * Created by Arnon Moscona on 5/27/2015.
 * Adds a strong consistency guarantee to the membership list. As soon as the cluster membership reaches a steady
 * state, all nodes that query for the membership list will get the same set of nodes without having to wait for a
 * convergence.
 * The node discovery listener has no better reliability guarantee than the parent interfaces.
 */
public interface StronglyConsistentNodeDiscovery<IdType> extends EventuallyConsistentNodeDiscovery<IdType> {
}
