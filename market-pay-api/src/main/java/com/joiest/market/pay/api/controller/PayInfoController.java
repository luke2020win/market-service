package com.joiest.market.pay.api.controller;

import com.joiest.market.common.utils.JsonUtils;
import com.joiest.market.pay.api.exception.JpfInterfaceErrorInfo;
import com.joiest.market.pay.api.service.PayBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单详细信息Controller
 * @author zhouchaowei
 */
@RestController
@RequestMapping("/payInfo")
public class PayInfoController {

    private Logger logger = LoggerFactory.getLogger(PayInfoController.class);
    
    @Autowired(required = false)
    private PayBankService payBankService;
    
    /**
     * 获取支付信息详情列表
     * @param requestBase64Param
     * @return
     */
    @RequestMapping(value = "/getPayInfoList")
    public String getPayInfoList(String requestBase64Param){
        return JsonUtils.toJsonBase64(JpfInterfaceErrorInfo.FAIL.getCode(),"参数不能为空",null);
    }
}
