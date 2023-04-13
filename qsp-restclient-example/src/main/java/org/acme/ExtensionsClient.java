package org.acme;

import java.util.Set;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestQuery;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/extensions")
@RegisterRestClient(configKey = "extensions-api")
public interface ExtensionsClient {

    @GET
    Uni<Set<Extension>> getById(@RestQuery String id);
}
