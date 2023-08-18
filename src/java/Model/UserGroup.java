package Model;

/**
 *
 * @author Tan Lin Yi
 */
public class UserGroup extends Super<UserGroup> {
    
    private int _userGroupId;
    private String _userGroupName;
    
     public int getUserGroupId(){
        return _userGroupId;
    }
    
    public UserGroup setUserGroupId(int userGroupId){
        _userGroupId = userGroupId;
        return this;
    }
    
    public String getUserGroupName(){
        return _userGroupName;
    }
    
    public UserGroup setUserGroupName(String userGroupName){
        _userGroupName = userGroupName;
        return this;
    }
    
    
}
