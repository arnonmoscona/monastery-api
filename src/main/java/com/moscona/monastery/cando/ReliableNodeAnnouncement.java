package com.moscona.monastery.cando;

/**
 * Created by Arnon Moscona on 5/27/2015.
 * Adds a reliability guarantee to the UnreliableNodeAnnouncement.
 * Reliability in this context means that art least some of the active, announced cluster nodes would be notified of
 * the new node (if they have a NodeDiscovery capability). If the underlying cluster implementation as a strongly
 * consistent set "core" nodes (e.g. those that participate in some consensus algorithm of some other way to achieve
 * at least an eventually consistent state among them) then this "core set" is guaranteed to be notified of the new
 * node on joining.
 */
public interface ReliableNodeAnnouncement<IdType> extends UnreliableNodeAnnouncement {
}
