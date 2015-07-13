package net.projectmonastery.monastery.cando;

import net.projectmonastery.monastery.api.core.Capability;
import net.projectmonastery.monastery.api.core.Node;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Created by Arnon Moscona on 5/13/2015.
 * The NodeAnnouncement capability allows nodes to announce themselves to the cluster and implementations
 * are expected to also set the node state.
 */
public interface NodeAnnouncement<IdType>  extends Capability {
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
     * @return a CompletableFuture allowing a continuation after the node has joined the cluster,
     * or a definite failure occurs.
     */
    CompletableFuture<NodeAnnouncement<IdType>> announce();

    /**
     * @return the unique ID assigned by the cluster to the node after announcement.
     * A nNode implementation may use an associated NodeAnnouncement capability as the source for its ID, and normally
     * this is the implementation pattern.
     * May be null before the node is in the joined state.
     */
    Optional<IdType> getId();

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
    NodeAnnouncement<IdType> addJoinListener(Consumer<Node<IdType>> action);
}
