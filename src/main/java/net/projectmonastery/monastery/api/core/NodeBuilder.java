package net.projectmonastery.monastery.api.core;


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

    default NodeBuilder<NodeIdeType> withCapabilities(Capability... capabilities) {return add(capabilities);}
    default NodeBuilder<NodeIdeType> withCapability(Capability capability) {return add(capability);}

    /**
     * Builds the node
     * @return the node, after letting all capabilities have the option to validate themselves and the presence of their
     * dependencies.
     * @throws Exception
     */
    Node<NodeIdeType> build() throws Exception;
}
