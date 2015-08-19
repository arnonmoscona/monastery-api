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

/**
 * Created by Arnon Moscona on 5/9/2015.
 * Possible states of a Node.
 */
public enum NodeState {
    DISCONNECTED("Initial state, unannounced. Not ready for use"),
    ANNOUNCED("Announced. Waiting to be joined. Not ready for use"),
    JOINED("Joined cluster. ID is valid. May be connected");

    private String description;

    NodeState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
