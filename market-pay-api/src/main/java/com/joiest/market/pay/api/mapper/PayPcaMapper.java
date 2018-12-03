package com.joiest.market.pay.api.mapper;

import com.joiest.market.pay.api.entity.generate.PayPca;
import com.joiest.market.pay.api.entity.generate.PayPcaExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 地区持久层接口
 * @author zhouchaowei 
 */
@Mapper
public interface PayPcaMapper {
    int countByExample(PayPcaExample example);

    int deleteByExample(PayPcaExample example);

    int deleteByPrimaryKey(Integer catid);

    int insert(PayPca record);

    int insertSelective(PayPca record);

    List<PayPca> selectByExample(PayPcaExample example);

    PayPca selectByPrimaryKey(Integer catid);

    int updateByExampleSelective(@Param("record") PayPca record, @Param("example") PayPcaExample example);

    int updateByExample(@Param("record") PayPca record, @Param("example") PayPcaExample example);

    int updateByPrimaryKeySelective(PayPca record);

    int updateByPrimaryKey(PayPca record);
}