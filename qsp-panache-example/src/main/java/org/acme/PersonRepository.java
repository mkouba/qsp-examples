package org.acme;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

@Named
@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    public List<Person> listAllSortedByName() {
        return listAll(Sort.ascending("surname", "name"));
    }

}
