package com.SEGroup80.Pojo.UserPojo;

public class User {
    private String UserID;
    private String identity;
    private String password;
    private String name;
    private String mail;
    private String phoneNumber;
    private int age;
    private boolean sex;
    private long createDate;
    private String photoURL;

    public User() {
    }

    public User(String identity, String password, String name, String mail, String phoneNumber, int age, boolean sex) {
        this.identity = identity;
        this.password = password;
        this.name = name;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.sex = sex;
        this.createDate = System.currentTimeMillis();
        if ("Manager".equals(identity)) {
            this.UserID = "M" + phoneNumber;
        } else if ("Trainer".equals(identity)) {
            this.UserID = "T" + phoneNumber;
        } else if ("Coach".equals(identity)) {
            this.UserID = "C" + phoneNumber;
        } else {
            System.out.println("====== The identity is not valid! ======");
        }
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserID='" + UserID + '\'' +
                ", identity='" + identity + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", createDate=" + createDate +
                ", photoURL='" + photoURL + '\'' +
                '}';
    }
}
