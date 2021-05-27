package com.SEGroup80.Pojo.BasicPojo;

public class MemberShip {

    private Boolean MemberShip;
    private String EndDate;


    public MemberShip() {
    }

    public MemberShip(Boolean memberShip, String endDate) {
        MemberShip = memberShip;
        EndDate = endDate;
    }

    public Boolean getMemberShip() {
        return MemberShip;
    }

    public void setMemberShip(Boolean memberShip) {
        MemberShip = memberShip;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }
}
