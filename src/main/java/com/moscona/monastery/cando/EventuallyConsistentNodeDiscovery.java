package com.moscona.monastery.cando;

/**
 * Created by Arnon Moscona on 5/27/2015.
 * Adds a level of reliability to node discovery.
 * There are two aspects to this guarantee.
 * The NodeDiscoveryListener actually does not have any guarantees. It may or may not be called when new nodes join,
 * although under normal conditions it is likely to be called.
 * However, the listing of discovered nodes is eventually consistent. This means that if membership reaches a steady
 * state (no new nodes join for a sufficiently long time), then eventually all nodes that query for the membership list
 * would get the same set of nodes.
 */
public interface EventuallyConsistentNodeDiscovery<IdType> extends UnreliableNodeDiscovery<IdType> {
}
