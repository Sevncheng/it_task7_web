package cn.ssm.dao;

import cn.ssm.entity.PhoneCode;

public interface PhoneCodeDao {

    PhoneCode checkCode(PhoneCode phoneCode);
    void save(PhoneCode phoneCode);
    int count(PhoneCode phoneCode);
}
