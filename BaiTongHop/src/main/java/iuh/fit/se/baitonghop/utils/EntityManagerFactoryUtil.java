package iuh.fit.se.baitonghop.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
    private static EntityManagerFactory entityManagerFactory;
    static {
        try{
            entityManagerFactory= Persistence.createEntityManagerFactory("phones-management");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
    public static void close(){
        if(entityManagerFactory.isOpen()){
            entityManagerFactory.close();
        }
    }
}
