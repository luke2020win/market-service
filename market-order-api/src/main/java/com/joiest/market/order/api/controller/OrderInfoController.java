package com.joiest.market.order.api.controller;

import com.joiest.market.common.exception.JpfInterfaceErrorInfo;
import com.joiest.market.common.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单详细信息Controller
 * @author zhouchaowei
 */
@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {

    private Logger logger = LoggerFactory.getLogger(OrderInfoController.class);

    /**
     * 获取订单列表接口
     * @param requestBase64Param
     * @return
     */
    @RequestMapping(value = "/getOrderList")
    public String getOrderList(String requestBase64Param){
        return JsonUtils.toJsonBase64(JpfInterfaceErrorInfo.FAIL.getCode(),"参数不能为空",null);
    }
}
