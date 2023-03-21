package org.acme;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.mutiny.Uni;

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
