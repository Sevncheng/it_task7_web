package cn.ssm.entity;

public class EmailCode {
    private Long codeTime;
    private String codeNumber;
    private String codeEmail;

    public EmailCode() {
    }

    public EmailCode(Long codeTime, String codeNumber, String codeEmail) {
        this.codeTime = codeTime;
        this.codeNumber = codeNumber;
        this.codeEmail = codeEmail;
    }

    public EmailCode(String codeNumber, String codeEmail) {
        this.codeNumber = codeNumber;
        this.codeEmail = codeEmail;
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

    public String getCodeEmail() {
        return codeEmail;
    }

    public void setCodeEmail(String codeEmail) {
        this.codeEmail = codeEmail;
    }
}
