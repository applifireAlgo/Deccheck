package project.app.server.repository;
import com.athena.server.repository.SearchInterfaceImpl;
import org.springframework.stereotype.Repository;
import project.app.shared.contacts.CoreContacts;
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
import project.app.shared.location.Address;
import project.app.shared.contacts.CommunicationData;

@Repository
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "", versionNumber = "1", comments = "Repository for CoreContacts Transaction table", complexity = Complexity.MEDIUM)
public class CoreContactsRepositoryImpl extends SearchInterfaceImpl implements CoreContactsRepository<CoreContacts> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<CoreContacts> findAll() throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            java.util.List<project.app.shared.contacts.CoreContacts> query = emanager.createQuery("select u from CoreContacts u where u.systemInfo.activeStatus=1").getResultList();
            return query;
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in retrieving entity", e);
        }
    }

    @Override
    @Transactional
    public CoreContacts save(CoreContacts entity) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            java.util.List<project.app.shared.location.Address> address = new java.util.ArrayList<project.app.shared.location.Address>();
            for (java.util.Iterator iterator = entity.getAddress().iterator(); iterator.hasNext(); ) {
                project.app.shared.location.Address childEntity = (project.app.shared.location.Address) iterator.next();
                if (childEntity.getPrimaryKey() != null) {
                    project.app.shared.location.Address ans = emanager.find(Address.class, childEntity.getPrimaryKey());
                    address.add(ans);
                } else {
                    address.add(childEntity);
                }
            }
            java.util.List<project.app.shared.contacts.CommunicationData> communicationdata = new java.util.ArrayList<project.app.shared.contacts.CommunicationData>();
            for (java.util.Iterator iterator = entity.getCommunicationData().iterator(); iterator.hasNext(); ) {
                project.app.shared.contacts.CommunicationData childEntity = (project.app.shared.contacts.CommunicationData) iterator.next();
                if (childEntity.getPrimaryKey() != null) {
                    project.app.shared.contacts.CommunicationData ans = emanager.find(CommunicationData.class, childEntity.getPrimaryKey());
                    communicationdata.add(ans);
                } else {
                    communicationdata.add(childEntity);
                }
            }
            entity.setAddress(address);
            entity.setCommunicationData(communicationdata);
            emanager.persist(entity);
            return entity;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        }
    }

    @Override
    @Transactional
    public List<CoreContacts> save(List<CoreContacts> entity) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                project.app.shared.contacts.CoreContacts obj = entity.get(i);
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
            project.app.shared.contacts.CoreContacts s = emanager.find(project.app.shared.contacts.CoreContacts.class, id);
            emanager.remove(s);
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in deleting entity", e);
        }
    }

    @Override
    @Transactional
    public void deleteAddress(List<Address> address) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (project.app.shared.location.Address _address : address) {
                project.app.shared.location.Address s = emanager.find(project.app.shared.location.Address.class, _address.getAddressId());
                emanager.remove(s);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in deleting entity", e);
        }
    }

    @Override
    @Transactional
    public void deleteCommunicationData(List<CommunicationData> communicationdata) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (project.app.shared.contacts.CommunicationData _communicationdata : communicationdata) {
                project.app.shared.contacts.CommunicationData s = emanager.find(project.app.shared.contacts.CommunicationData.class, _communicationdata.getCommDataId());
                emanager.remove(s);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in deleting entity", e);
        }
    }

    @Override
    @Transactional
    public void update(CoreContacts entity) throws SpartanPersistenceException {
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
    public void update(List<CoreContacts> entity) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                project.app.shared.contacts.CoreContacts obj = entity.get(i);
                emanager.merge(obj);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity updation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    @Transactional
    public List<CoreContacts> findByTitleId(String titleId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("CoreContacts.findByTitleId");
            query.setParameter("titleId", titleId);
            java.util.List<project.app.shared.contacts.CoreContacts> listOfCoreContacts = query.getResultList();
            return listOfCoreContacts;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }

    @Transactional
    public List<CoreContacts> findByNativeLanguageCode(String nativeLanguageCode) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("CoreContacts.findByNativeLanguageCode");
            query.setParameter("nativeLanguageCode", nativeLanguageCode);
            java.util.List<project.app.shared.contacts.CoreContacts> listOfCoreContacts = query.getResultList();
            return listOfCoreContacts;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }

    @Transactional
    public List<CoreContacts> findByGenderId(String genderId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("CoreContacts.findByGenderId");
            query.setParameter("genderId", genderId);
            java.util.List<project.app.shared.contacts.CoreContacts> listOfCoreContacts = query.getResultList();
            return listOfCoreContacts;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }

    @Transactional
    public List<CoreContacts> findByTimeZoneId(String timeZoneId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("CoreContacts.findByTimeZoneId");
            query.setParameter("timeZoneId", timeZoneId);
            java.util.List<project.app.shared.contacts.CoreContacts> listOfCoreContacts = query.getResultList();
            return listOfCoreContacts;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }

    @Transactional
    public CoreContacts findById(String contactId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("CoreContacts.findById");
            query.setParameter("contactId", contactId);
            project.app.shared.contacts.CoreContacts listOfCoreContacts = (project.app.shared.contacts.CoreContacts) query.getSingleResult();
            return listOfCoreContacts;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }
}
