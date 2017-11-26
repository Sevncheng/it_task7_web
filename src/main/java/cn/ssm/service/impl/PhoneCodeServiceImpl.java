package cn.ssm.service.impl;

import cn.ssm.dao.PhoneCodeDao;
import cn.ssm.entity.PhoneCode;
import cn.ssm.service.PhoneCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("phoneCodeService")
public class PhoneCodeServiceImpl implements PhoneCodeService {

    @Autowired
    private PhoneCodeDao phoneCodeDao;



    @Override
    public PhoneCode checkCode(PhoneCode phoneCode) {
        return phoneCodeDao.checkCode(phoneCode);
    }

    @Override
    public void save(PhoneCode phoneCode) {
        phoneCodeDao.save(phoneCode);
    }

    @Override
    public int count(PhoneCode phoneCode) {
        return phoneCodeDao.count(phoneCode);
    }
}
