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
     * @throws Exception if an of the parameters are null or incompatible with the implementation
     */
    NodeBuilder<NodeIdeType> add(Capability... capabilities) throws Exception;

    default NodeBuilder<NodeIdeType> withCapabilities(Capability... capabilities) throws Exception {return add(capabilities);}
    default NodeBuilder<NodeIdeType> withCapability(Capability capability) throws Exception {return add(capability);}

    /**
     * Builds the node
     * @return the node, after letting all capabilities have the option to validate themselves and the presence of their
     * dependencies.
     * @throws Exception
     */
    Node<NodeIdeType> build() throws Exception;
}
