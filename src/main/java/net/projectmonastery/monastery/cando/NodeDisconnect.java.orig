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


import net.projectmonastery.monastery.api.core.Node;

import java.util.concurrent.CompletableFuture;


/**
 * Created by Arnon Moscona on 7/7/2015.
 * A capability to force node disconnect (orderly shutdown)
 */
public interface NodeDisconnect {
    /**
     * Instructs the node to disconnect and clean resources.
     * May clear the ID (implementation dependent).
     * May not take effect immediately.
     * Access to the node while the disconnect process is incomplete may be unsafe (implementation dependent).
     * @return a CompletionStage that completes when the shutdown process is complete.
     */
    CompletableFuture<Node> disconnect();
}
