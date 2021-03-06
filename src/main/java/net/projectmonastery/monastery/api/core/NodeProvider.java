/*
 * Copyright (c) 2016. Arnon Moscona
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


import java.util.concurrent.CompletableFuture;

/**
 * Created by Arnon Moscona on 8/3/2016.
 * The node provider is the means of connecting to the cluster and obtaining a functioning Node.
 */
public interface NodeProvider {

    /**
     * Connects to the cluster, and when connected provides a Node.
     * @return a CompletionStage that whn complete provides a connected Node
     */
    CompletableFuture<Node> connect();
}
