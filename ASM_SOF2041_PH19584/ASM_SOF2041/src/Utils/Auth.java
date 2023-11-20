
package Utils;
import Entity.NhanVien;
/**
 *
 * @author Nguyen Truc
 */
public class Auth {
    public static NhanVien user = null;
    
    public static void clear(){
        Auth.user = null;
    }
    
    public static boolean isLogin() {
        return Auth.user !=null;
    }
    
    public static boolean isManager() {
        return Auth.isLogin()&&user.getVaitro();
    }
    
}
