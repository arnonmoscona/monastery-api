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

package net.projectmonastery.monastery.cando;

import net.projectmonastery.monastery.api.core.Capability;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Consumer;

/**
 * Created by Arnon Moscona on 5/8/2015.
 * The node discovery capability allows nodes to know about the existence of other nodes in the cluster.
 * See documentation at the monastery-docs project: https://github.com/arnonmoscona/monastery-docs
 */
public interface NodeDiscovery<IdType> extends Capability {
    /**
     * Add an action to be invoked when new nodes are discovered by the cluster
     * @param action the action to be called when a new node is discovered. The action consumes a NodeInformation&lt;IdType&gt;
     * @return a reference to the node discovery capability
     */
    NodeDiscovery addNodeDiscoveryListener(Consumer<NodeInformation<IdType>> action);

    /**
     * @return a list of all the nodes discovered in the life of the cluster. Note that the list could be long.
     */
    CompletionStage<List<NodeInformation<IdType>>> listKnowNodes();
}
