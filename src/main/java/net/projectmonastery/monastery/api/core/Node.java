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

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

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
    Optional<IdType> getId();

    /**
     * Asynchronously retrieves the implementation's capability that matches the specified capability
     * (interface or class)
     * @param capabilityClass the specification of the desired capability
     * @param <T> the capability class itself
     * @return the implementation instance, wrapped in a CompletionStage. If the capability is not available
     * then the future will complete exceptionally.
     */
    <T extends Capability> CompletionStage<T> getCapability(Class<T> capabilityClass);

    /**
     * Gets all the capabilities of the node
     * @return a copy of the internal capability list
     */
    List<Capability> getCapabilities();

    /**
     * A node that you can connect to is not very useful.
     * The semantics of the connection string is implementation specific.
     * @return the connection string. It may not be null, but may be a zero-length string.
     */
    String getConnectionString();
}
