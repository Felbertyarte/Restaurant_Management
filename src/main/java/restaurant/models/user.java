package restaurant.models;

public class user {
    private int storeID;
    private int usertypeID;
    private int personID;
    private String storename;
    private String usertype;

    public user(int storeID, int usertypeID, int personID, String storename, String usertype) {
        this.storename = storename;
        this.usertype = usertype;
        this.storeID = storeID;
        this.usertypeID = usertypeID;
        this.personID = personID;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public int getUsertypeID() {
        return usertypeID;
    }

    public void setUsertypeID(int usertypeID) {
        this.usertypeID = usertypeID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

}
