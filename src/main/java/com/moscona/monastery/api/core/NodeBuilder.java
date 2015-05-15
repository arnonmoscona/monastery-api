package com.moscona.monastery.api.core;

import sun.plugin.dom.exception.InvalidStateException;

/**
 * Created by Arnon Moscona on 5/13/2015.
 * Builds nodes by adding capabilities and man aging capability life cycle callbacks
 */
public interface NodeBuilder<NodeIdeType> {
    /**
     * Adds one or more capabilities to the node being built.
     * @param capabilities the capabilities to add.
     * @return the builder itself
     */
    NodeBuilder<NodeIdeType> add(Capability... capabilities);

    /**
     * Builds the node
     * @return the node, after letting all capabilities have the option to validate themselves and the presence of their
     * dependencies.
     * @throws InvalidStateException
     */
    Node<NodeIdeType> build() throws InvalidStateException;
}