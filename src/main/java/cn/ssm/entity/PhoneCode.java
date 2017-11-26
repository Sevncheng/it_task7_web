package cn.ssm.entity;

public class PhoneCode {
    private Long codeTime;
    private String codeNumber;
    private String codePhone;

    public PhoneCode() {
    }

    public PhoneCode( String codeNumber, String codePhone) {
        this.codeNumber = codeNumber;
        this.codePhone = codePhone;
    }

    public PhoneCode(Long codeTime, String codeNumber, String codePhone) {
        this.codeTime = codeTime;
        this.codeNumber = codeNumber;
        this.codePhone = codePhone;
    }

    public Long getCodeTime() {
        return codeTime;
    }

    public void setCodeTime(Long codeTime) {
        this.codeTime = codeTime;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getCodePhone() {
        return codePhone;
    }

    public void setCodePhone(String codePhone) {
        this.codePhone = codePhone;
    }
}
