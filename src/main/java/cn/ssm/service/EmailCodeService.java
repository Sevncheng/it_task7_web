package cn.ssm.service;

import cn.ssm.entity.EmailCode;
import cn.ssm.entity.PhoneCode;


public interface EmailCodeService {
    EmailCode checkCode(EmailCode emailCode);
    void save(EmailCode emailCode);
    int count(EmailCode emailCode);
}
