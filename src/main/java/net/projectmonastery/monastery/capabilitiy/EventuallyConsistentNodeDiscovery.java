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

package net.projectmonastery.monastery.capabilitiy;

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
public interface EventuallyConsistentNodeDiscovery extends UnreliableNodeDiscovery {
}
