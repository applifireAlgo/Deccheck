package mineproj.app.server.repository;
import com.athena.server.repository.SearchInterfaceImpl;
import mineproj.app.shared.authorization.Roles;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.config.server.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import mineproj.app.shared.authorization.RoleMenuBridge;

@Repository
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@SourceCodeAuthorClass(createdBy = "puja.singh@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Repository for Roles Transaction table", complexity = Complexity.MEDIUM)
public class RolesRepositoryImpl extends SearchInterfaceImpl implements RolesRepository<Roles> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<Roles> findAll() throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            java.util.List<mineproj.app.shared.authorization.Roles> query = emanager.createQuery("select u from Roles u where u.systemInfo.activeStatus=1").getResultList();
            return query;
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in retrieving entity", e);
        }
    }

    @Override
    @Transactional
    public Roles save(Roles entity) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            emanager.persist(entity);
            return entity;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        }
    }

    @Override
    @Transactional
    public List<Roles> save(List<Roles> entity) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                mineproj.app.shared.authorization.Roles obj = entity.get(i);
                emanager.persist(obj);
            }
            return entity;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity Saving", e);
        }
    }

    @Transactional
    @Override
    public void delete(String id) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            mineproj.app.shared.authorization.Roles s = emanager.find(mineproj.app.shared.authorization.Roles.class, id);
            emanager.remove(s);
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in deleting entity", e);
        }
    }

    @Override
    @Transactional
    public void deleteRoleMenuBridge(List<RoleMenuBridge> rolemenubridge) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (mineproj.app.shared.authorization.RoleMenuBridge _rolemenubridge : rolemenubridge) {
                mineproj.app.shared.authorization.RoleMenuBridge s = emanager.find(mineproj.app.shared.authorization.RoleMenuBridge.class, _rolemenubridge.getRoleMenuMapId());
                emanager.remove(s);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in deleting entity", e);
        }
    }

    @Override
    @Transactional
    public void update(Roles entity) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            emanager.merge(entity);
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    @Override
    @Transactional
    public void update(List<Roles> entity) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                mineproj.app.shared.authorization.Roles obj = entity.get(i);
                emanager.merge(obj);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity updation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    @Transactional
    public Roles findById(String roleId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("Roles.findById");
            query.setParameter("roleId", roleId);
            mineproj.app.shared.authorization.Roles listOfRoles = (mineproj.app.shared.authorization.Roles) query.getSingleResult();
            return listOfRoles;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }
}
