package cn.ssm.service.impl;

import cn.ssm.dao.EmailCodeDao;
import cn.ssm.dao.PhoneCodeDao;
import cn.ssm.entity.EmailCode;
import cn.ssm.entity.PhoneCode;
import cn.ssm.service.EmailCodeService;
import cn.ssm.service.PhoneCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("emailCodeService")
public class EmailCodeServiceImpl implements EmailCodeService {

    @Autowired
    private EmailCodeDao emailCodeDao;


    @Override
    public EmailCode checkCode(EmailCode emailCode) {
        return emailCodeDao.checkCode(emailCode);
    }

    @Override
    public void save(EmailCode emailCode) {
        emailCodeDao.save(emailCode);
    }

    @Override
    public int count(EmailCode emailCode) {
        return emailCodeDao.count(emailCode);
    }
}
