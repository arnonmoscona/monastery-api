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

package net.projectmonastery.monastery.capability;

/**
 * Created by Arnon Moscona on 5/27/2015.
 * Adds a strong consistency guarantee to the membership list. As soon as the cluster membership reaches a steady
 * state, all nodes that query for the membership list will get the same set of nodes without having to wait for a
 * convergence.
 * The node discovery listener has no better reliability guarantee than the parent interfaces.
 */
public interface StronglyConsistentNodeDiscovery extends EventuallyConsistentNodeDiscovery {
}
