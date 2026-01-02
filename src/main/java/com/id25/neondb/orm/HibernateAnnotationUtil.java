package com.id25.neondb.orm;

import com.id25.neondb.candidates.model.Candidate;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.Map;

public class HibernateAnnotationUtil {
    public static SessionFactory getSessionFactory() {

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(dbSettings())
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Candidate.class)
                // other domain classes
                .buildMetadata();

        return metadata.buildSessionFactory();
    }

    private static Map<String, Object> dbSettings() {
        // return Hibernate settings
        return Map.of();
    }
}
