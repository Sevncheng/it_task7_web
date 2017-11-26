package cn.ssm.dao;

import cn.ssm.entity.EmailCode;
import cn.ssm.entity.PhoneCode;

public interface EmailCodeDao {

    EmailCode checkCode(EmailCode emailCode);
    void save(EmailCode emailCode);
    int count(EmailCode emailCode);
}
