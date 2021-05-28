package com.SEGroup80.Pojo.UserPojo;

import com.SEGroup80.Pojo.BasicPojo.Body;
import com.SEGroup80.Pojo.BasicPojo.MemberShip;

import java.util.ArrayList;

public class Trainer extends User {

    private ArrayList<String> subscribeCoachList;
    private ArrayList<String> likeList;
    private ArrayList<String> collectList;
    private ArrayList<String> friendList;
    private ArrayList<Body> bodyRecord;
    private double balance;
    private MemberShip memberShip;

    public Trainer() {
    }

    public Trainer(String identity, String password, String name, String mail, String phoneNumber, int age, boolean sex, double balance) {
        super(identity, password, name, mail, phoneNumber, age, sex);
        this.balance = balance;
    }

    public Trainer(String identity, String password, String name, String mail, String phoneNumber, int age, boolean sex, double balance, ArrayList<String> subscribeCoachList, ArrayList<String> friendList, ArrayList<Body> bodyRecord, MemberShip memberShip, ArrayList<String> likeList, ArrayList<String> collectList) {
        super(identity, password, name, mail, phoneNumber, age, sex);
        this.subscribeCoachList = subscribeCoachList;
        this.friendList = friendList;
        this.bodyRecord = bodyRecord;
        this.balance = balance;
        this.memberShip = memberShip;
        this.likeList = likeList;
        this.collectList = collectList;
    }

    public ArrayList<String> getSubscribeCoachList() {
        return subscribeCoachList;
    }

    public void setSubscribeCoachList(ArrayList<String> subscribeCoachList) {
        this.subscribeCoachList = subscribeCoachList;
    }

    public ArrayList<String> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<String> friendList) {
        this.friendList = friendList;
    }

    public ArrayList<Body> getBodyRecord() {
        return bodyRecord;
    }

    public void setBodyRecord(ArrayList<Body> bodyRecord) {
        this.bodyRecord = bodyRecord;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public MemberShip getMemberShip() {
        return memberShip;
    }

    public void setMemberShip(MemberShip memberShip) {
        this.memberShip = memberShip;
    }

    public ArrayList<String> getLikeList() {
        return likeList;
    }

    public void setLikeList(ArrayList<String> likeList) {
        this.likeList = likeList;
    }

    public ArrayList<String> getCollectList() {
        return collectList;
    }

    public void setCollectList(ArrayList<String> collectList) {
        this.collectList = collectList;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "subscribeCoachList=" + subscribeCoachList +
                ", friendList=" + friendList +
                ", bodyRecord=" + bodyRecord +
                ", balance=" + balance +
                '}';
    }
}
