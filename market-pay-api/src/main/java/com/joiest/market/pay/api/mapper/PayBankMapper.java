package com.joiest.market.pay.api.mapper;

import java.util.List;

import com.joiest.market.pay.api.entity.generate.PayBank;
import com.joiest.market.pay.api.entity.generate.PayBankExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 银行类型实体持久层接口
 * @author zhouchaowei 
 */
@Mapper
public interface PayBankMapper {
    int countByExample(PayBankExample example);

    int deleteByExample(PayBankExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PayBank record);

    int insertSelective(PayBank record);

    List<PayBank> selectByExample(PayBankExample example);

    PayBank selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PayBank record, @Param("example") PayBankExample example);

    int updateByExample(@Param("record") PayBank record, @Param("example") PayBankExample example);

    int updateByPrimaryKeySelective(PayBank record);

    int updateByPrimaryKey(PayBank record);
}