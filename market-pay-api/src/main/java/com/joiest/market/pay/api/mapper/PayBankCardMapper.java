package com.joiest.market.pay.api.mapper;

import com.joiest.market.pay.api.entity.generate.PayBankCard;
import com.joiest.market.pay.api.entity.generate.PayBankCardExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author zhouchaowei 
 */
@Mapper
public interface PayBankCardMapper {
    int countByExample(PayBankCardExample example);

    int deleteByExample(PayBankCardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayBankCard record);

    int insertSelective(PayBankCard record);

    List<PayBankCard> selectByExample(PayBankCardExample example);

    PayBankCard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayBankCard record, @Param("example") PayBankCardExample example);

    int updateByExample(@Param("record") PayBankCard record, @Param("example") PayBankCardExample example);

    int updateByPrimaryKeySelective(PayBankCard record);

    int updateByPrimaryKey(PayBankCard record);
}