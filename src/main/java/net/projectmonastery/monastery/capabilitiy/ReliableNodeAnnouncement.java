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
 * Adds a reliability guarantee to the UnreliableNodeAnnouncement.
 * Reliability in this context means that art least some of the active, announced cluster nodes would be notified of
 * the new node (if they have a NodeDiscovery capability). If the underlying cluster implementation as a strongly
 * consistent set "core" nodes (e.g. those that participate in some consensus algorithm of some other way to achieve
 * at least an eventually consistent state among them) then this "core set" is guaranteed to be notified of the new
 * node on joining.
 */
public interface ReliableNodeAnnouncement extends UnreliableNodeAnnouncement {
}
