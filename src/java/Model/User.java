package Model;

/**
 *
 * @author Tan Lin Yi
 */
public class User extends Super<User> {
    private int _userId;
    private int _userGroupId;
    private String _username;
    private String _name;
    private String _password;
    private String _status;
    private String _phone;
    private String _mail;
    private String _image;
    private UserGroup _userGroup;
   
    public int getUserId(){
        return _userId;
    }
    
    public User setUserId(int userId){
        _userId = userId;
        return this;
    }
        public int getUserGroupId() {
        return _userGroupId;
    }

    public User setUserGroupId(int userGroupId) {
        _userGroupId = userGroupId;
        return this;
    }
    
    public String getUsername(){
        return _username;
    }
    
    public User setUsername(String username){
        _username = username;
        return this;
    }
    
       public UserGroup getUserGroup(){
        return _userGroup;
    }
    
    public User setUserGroup(UserGroup userGroup){
        _userGroup = userGroup;
        return this;
    }
    
    public String getName(){
        return _name;
    }
    
    public User setName(String name){
        _name = name;
        return this;
    }
    
    public String getPassword(){
        return _password;
    }
    
    public User setPassword(String password){
        _password = password;
        return this;
    }
    
    public String getStatus(){
        return _status;
    }
    
    public User setStatus(String status){
        _status = status;
        return this;
    }
    
    public String getPhone(){
        return _phone;
    }
    
    public User setPhone(String phone){
        _phone = phone;
        return this;
    }
    
    public String getMail(){
        return _mail;
    }
    
    public User setMail(String mail){
        _mail = mail;
        return this;
    }
    
    public String getIamge(){
        return _image;
    }
    
    public User setImage(String image){
        _image = image;
        return this;
    }



}
