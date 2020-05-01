package stalterclouse.elspeth.persistence;

import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A generic DAO somewhat inspired by http://rodrigouchoa.wordpress.com
 */

@Log4j2
public class GenericDao<T> {
    private Class<T> type;

    /**
     * Instantiates a new Generic DAO
     *
     * @param type the entity type, for example: User
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Returns an open session from the SessionFactory
     *
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * Gets an entity by id
     * @param id entity id to search by
     * @return an entity
     */
    public <T>T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        //log.error("Could not get by id");
        session.close();
        return entity;
    }

    /**
     * insert entity
     * @param entity Entity to be inserted or updated
     * @return id of the inserted entity
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        //log.error("Could not insert");
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete an entity
     * @param entity Entity to be deleted
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        //log.error("Could not delete");
        transaction.commit();
        session.close();
    }

    /**
     * Gets all entities.
     *
     * @return all entities
     */
    public List<T> getAllEntities() {

        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> orders = session.createQuery(query).getResultList();
        //log.error("Could not getAllEntities");
        session.close();
        return orders;
    }

    /**
     * Get entity by property (exact match)
     * sample usage: getByPropertyEqual("description", "books")
     *
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of entities meeting the criteria search
     */
    public List<T> getByPropertyEqual(String propertyName, Object value) {
        Session session = getSession();

        log.debug("Searching for entity with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> orders = session.createQuery( query ).getResultList();

        //log.error("Could not getByPropertyEqual");

        session.close();
        return orders;
    }

    /**
     * Finds entities by multiple properties.
     * Inspired by https://stackoverflow.com/questions/11138118/really-dynamic-jpa-criteriabuilder
     * @param propertyMap property and value pairs
     * @return entities with properties equal to those passed in the map
     *
     *
     */
    public List<T> getByPropertiesEqual(Map<String, Object> propertyMap) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<Predicate> predicates = new ArrayList<Predicate>();
        for (Map.Entry entry: propertyMap.entrySet()) {
            predicates.add(builder.equal(root.get((String) entry.getKey()), entry.getValue()));
        }
        query.select(root).where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

        return session.createQuery(query).getResultList();
    }

    /**
     * Get entity by property (like)
     * sample usage: getByPropertyLike("description", "books")
     *
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of entities meeting the criteria search
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

        log.debug("Searching for order with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> orders = session.createQuery(query).getResultList();

        //log.error("Could not getByPropertyLike");

        session.close();
        return orders;
    }

    /**
     * update entity
     * @param entity Entity to be inserted or updated
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        //log.error("Could not saveOrUpdate");
        transaction.commit();
        session.close();
    }


}
