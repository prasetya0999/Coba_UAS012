/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PWS_cba_A.cba_uas;

import PWS_cba_A.cba_uas.exceptions.NonexistentEntityException;
import PWS_cba_A.cba_uas.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Administrator
 */
public class TbBarangJpaController implements Serializable {

    public TbBarangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PWS_cba_A_cba_uas_jar_0.0.1-SNAPSHOTPU");
    public TbBarangJpaController(){
        
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbBarang tbBarang) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tbBarang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTbBarang(tbBarang.getIdBarang()) != null) {
                throw new PreexistingEntityException("TbBarang " + tbBarang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbBarang tbBarang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tbBarang = em.merge(tbBarang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tbBarang.getIdBarang();
                if (findTbBarang(id) == null) {
                    throw new NonexistentEntityException("The tbBarang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbBarang tbBarang;
            try {
                tbBarang = em.getReference(TbBarang.class, id);
                tbBarang.getIdBarang();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbBarang with id " + id + " no longer exists.", enfe);
            }
            em.remove(tbBarang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TbBarang> findTbBarangEntities() {
        return findTbBarangEntities(true, -1, -1);
    }

    public List<TbBarang> findTbBarangEntities(int maxResults, int firstResult) {
        return findTbBarangEntities(false, maxResults, firstResult);
    }

    private List<TbBarang> findTbBarangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbBarang.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TbBarang findTbBarang(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbBarang.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbBarangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbBarang> rt = cq.from(TbBarang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
