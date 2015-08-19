/*
 * Copyright (c) 2015. Arnon Moscona
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

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
     * @throws Exception if there are any problems building the node
     */
    Node<NodeIdeType> build() throws Exception;
}
