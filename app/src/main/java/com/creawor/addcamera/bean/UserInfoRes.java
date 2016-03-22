package com.creawor.addcamera.bean;

/**
 * Created by Jin_ on 2016/3/21
 * 邮箱：dejin_lu@creawor.com
 */
public class UserInfoRes extends BaseRes {

    /**
     * accountNo : ga1
     * admin : false
     * companyAddress : qqqqqqqq
     * companyCode : zhga
     * companyContactMan : fggb
     * companyContactTell : 12345678
     * companyId : 5add7a92529be59701529be9584a0002
     * companyName : 珠海市公安局
     * companyType : 1
     * createTime : 1452736899000
     * creator : admin
     * email :
     * managerCompanyId : comp1
     * orgId : 9be95858da5dfa12004e9064c7e6f7dd
     * orgLevel : 3
     * orgName : 珠海市公安局
     * orgType : 1
     * phone : 13567892345
     * pwd : 4QrcOUm6Wau+VuBX8g+IPg==
     * roleId : 40288ad64db26adc014db2f38a360005
     * roleName : 公安部门
     * seqno : 0
     * sex : 1
     * status : 1
     * stopTime :
     * userId : 40288a2b523dc04601523ddde87d0002
     * userName : ga1
     */

    private UserInfo info;

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }

    public static class UserInfo {
        private String accountNo;
        private boolean admin;
        private String companyAddress;
        private String companyCode;
        private String companyContactMan;
        private String companyContactTell;
        private String companyId;
        private String companyName;
        private String companyType;
        private long createTime;
        private String creator;
        private String email;
        private String managerCompanyId;
        private String orgId;
        private int orgLevel;
        private String orgName;
        private String orgType;
        private String phone;
        private String pwd;
        private String roleId;
        private String roleName;
        private int seqno;
        private int sex;
        private int status;
        private String stopTime;
        private String userId;
        private String userName;

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public boolean isAdmin() {
            return admin;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public String getCompanyAddress() {
            return companyAddress;
        }

        public void setCompanyAddress(String companyAddress) {
            this.companyAddress = companyAddress;
        }

        public String getCompanyCode() {
            return companyCode;
        }

        public void setCompanyCode(String companyCode) {
            this.companyCode = companyCode;
        }

        public String getCompanyContactMan() {
            return companyContactMan;
        }

        public void setCompanyContactMan(String companyContactMan) {
            this.companyContactMan = companyContactMan;
        }

        public String getCompanyContactTell() {
            return companyContactTell;
        }

        public void setCompanyContactTell(String companyContactTell) {
            this.companyContactTell = companyContactTell;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCompanyType() {
            return companyType;
        }

        public void setCompanyType(String companyType) {
            this.companyType = companyType;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getManagerCompanyId() {
            return managerCompanyId;
        }

        public void setManagerCompanyId(String managerCompanyId) {
            this.managerCompanyId = managerCompanyId;
        }

        public String getOrgId() {
            return orgId;
        }

        public void setOrgId(String orgId) {
            this.orgId = orgId;
        }

        public int getOrgLevel() {
            return orgLevel;
        }

        public void setOrgLevel(int orgLevel) {
            this.orgLevel = orgLevel;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public String getOrgType() {
            return orgType;
        }

        public void setOrgType(String orgType) {
            this.orgType = orgType;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public String getRoleId() {
            return roleId;
        }

        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public int getSeqno() {
            return seqno;
        }

        public void setSeqno(int seqno) {
            this.seqno = seqno;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getStopTime() {
            return stopTime;
        }

        public void setStopTime(String stopTime) {
            this.stopTime = stopTime;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
