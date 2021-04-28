package com.marcelofortes.prova2704;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class Configuration extends Application {
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourcesClasses(resources);
        return resources;
      }
    
      private void addRestResourcesClasses(Set<Class<?>> resources) {
        resources.add(com.marcelofortes.prova2704.Resources.class);
      }

}
