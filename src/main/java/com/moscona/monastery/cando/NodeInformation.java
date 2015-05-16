package com.moscona.monastery.cando;

/**
 * Created by Arnon Moscona on 5/15/2015.
 * Basic information about nodes.
 */
public interface NodeInformation<IdType> {
    IdType getId();
    String getConnectionString();
}
