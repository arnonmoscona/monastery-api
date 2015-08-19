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
 * Created by Arnon Moscona on 5/8/2015.
 * The represents a capability that is exposed by a Node.
 * See documentation at the monastery-docs project: https://github.com/arnonmoscona/monastery-docs
 */
public interface Capability {
    /**
     * The optional bind method is called during node build after the capability has been added to the node and before the
     * node is finally returned to the application. It allows capabilities to maintain a reference to the owning node
     * as a runtime context.<br/>
     * This allows the capability to access dependencies, should the capability depend on other capabilities.<br/>
     * <em>Note that at the time of binding, there is no assurance that the other capabilities have been added to the node,
     * so it is not advisable to do much more than initialize a private reference at this stage.</em>
     * @param context a reference to the owning node.
     */
    default void bind(Node<?> context) {}

    /**
     * This optional method is called during node build after all the capabilities have been bound to the node.<br/>
     * At this stage it is possible for the capability to check whether all the dependencies it has are bound to the
     * node and it has the opportunity to configure itself appropriately, or throw an exception if it concludes that
     * it cannot function.<br/>
     * <em>Note that aqt this stage the node is probably not joined to the cluster yet, so it would be premature to start
     * any activity that requires any access to the cluster.</em>
     */
    default void onAllCapabilitiesBound() throws IllegalStateException {}

    /**
     * This method may be called after <pre>onAllCapabilitiesBound()</pre> as a double check to verify that the
     * capability believes that it is operational at this point. This is a last opportunity for the capability to
     * fail fast before the node itself is used.
     * @return true if there are no known problems and false otherwise. If false the node may become inoperative.
     */
    default boolean isReady() { return true;}
}
