package org.acme;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Named
@Singleton
public class Extensions {

    @RestClient
    ExtensionsClient client;

    public Uni<List<Extension>> getById(String id) {
        return client.getById(id).map(set -> {
            List<Extension> list = new ArrayList<>(set);
            list.sort(Comparator.comparing(e -> e.name.toLowerCase()));
            return list;
        });
    }

}
