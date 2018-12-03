package com.joiest.market.pay.api.service.impl;

import com.joiest.market.pay.api.entity.generate.PayBank;
import com.joiest.market.pay.api.mapper.PayBankMapper;
import com.joiest.market.pay.api.service.PayBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 银行类型业务接口实现类
 * @author zhouchaowei 
 */
public class PayBankServiceImpl implements PayBankService {
    
    private Logger logger = LoggerFactory.getLogger(PayBankServiceImpl.class);
    
    @Autowired
    private PayBankMapper payBankMapper;
}
