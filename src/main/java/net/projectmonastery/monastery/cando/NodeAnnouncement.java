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
import net.projectmonastery.monastery.api.core.Node;

import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.function.Consumer;

/**
 * Created by Arnon Moscona on 5/13/2015.
 * The NodeAnnouncement capability allows nodes to announce themselves to the cluster and implementations
 * are expected to also set the node state.
 */
public interface NodeAnnouncement  extends Capability {
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
     * @return a CompletionStage allowing a continuation after the node has joined the cluster,
     * or a definite failure occurs.
     */
    CompletionStage<NodeAnnouncement> announce();

    /**
     * @return the unique ID assigned by the cluster to the node after announcement.
     * A nNode implementation may use an associated NodeAnnouncement capability as the source for its ID, and normally
     * this is the implementation pattern.
     * May be null before the node is in the joined state.
     */
    Optional getId();

    /**
     * @return the node that the capability is bound to.
     */
    Optional<Node> getBoundNode();

    /**
     * Add an action to be executed after the node enters a JOINED state. When called the capability will pass a
     * reference to the Node as an argument.
     * @param action the action to be performed
     * @return a reference to the capability.
     */
    NodeAnnouncement addJoinListener(Consumer<Node> action);
}
