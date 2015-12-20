package mineproj.app.server.repository;
import com.athena.server.repository.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import mineproj.app.shared.authorization.RoleMenuBridge;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;

@SourceCodeAuthorClass(createdBy = "puja.singh@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Repository for Roles Transaction table", complexity = Complexity.MEDIUM)
public interface RolesRepository<T> extends SearchInterface {

    public List<T> findAll() throws SpartanPersistenceException;

    public T save(T entity) throws SpartanPersistenceException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException;

    public void delete(String id) throws SpartanPersistenceException;

    public void deleteRoleMenuBridge(List<RoleMenuBridge> rolemenubridge) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanConstraintViolationException, SpartanPersistenceException;

    public void update(List<T> entity) throws SpartanPersistenceException;

    public T findById(String roleId) throws Exception, SpartanPersistenceException;
}
