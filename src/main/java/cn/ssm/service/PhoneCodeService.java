package cn.ssm.service;

import cn.ssm.entity.PhoneCode;


public interface PhoneCodeService {

    PhoneCode checkCode(PhoneCode phoneCode);
    void save(PhoneCode phoneCode);
    int count(PhoneCode phoneCode);
}
