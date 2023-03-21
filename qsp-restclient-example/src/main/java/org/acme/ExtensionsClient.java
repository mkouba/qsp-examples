package org.acme;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestQuery;

import io.smallrye.mutiny.Uni;

@Path("/extensions")
@RegisterRestClient(configKey = "extensions-api")
public interface ExtensionsClient {

    @GET
    Uni<Set<Extension>> getById(@RestQuery String id);
}
