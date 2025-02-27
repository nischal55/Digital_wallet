/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.mindrot.jbcrypt.BCrypt;


public class testConnection {
     public static void main(String[] args) {
        // Create the EntityManagerFactory for the persistence unit
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("digital_wallet");
        EntityManager em = emf.createEntityManager();

        try {
            // Run a simple query to check if the connection is successful
            em.getTransaction().begin();
            Query query = em.createNativeQuery("SELECT 1");
            query.getResultList();  // Execute the query
            em.getTransaction().commit();  // Commit transaction if necessary

            System.out.println("Database connection is successful.");
            
            String pas = BCrypt.hashpw("Nischal@123", BCrypt.gensalt(12));
            System.out.println(pas);
        } catch (Exception e) {
            System.err.println("Database connection failed: " + e.getMessage());
        } finally {
            // Clean up
            em.close();
            emf.close();
        }
    }
}
