
package DAO;
import Entity.NhanVien;
import java.util.List;
/**
 *
 * @author Nguyen Truc
 */
abstract public class EduSysDAO<EntytiType, KeyTepy> {
    abstract public void insert(EntytiType entity);
    abstract public void update(EntytiType entity);
    abstract public void delete(KeyTepy id);
    abstract public EntytiType selectbyId(KeyTepy id);
    abstract public List<EntytiType> selectAll();
    abstract protected List<EntytiType> selectbySql(String sql,Object... args);
}
