package com.ch.dao;

import com.ch.dto.SuccessCaseDTO;
import com.ch.entity.SuccessCase;
import com.ch.entity.SuccessCaseExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuccessCaseMapper {
    int countByExample(SuccessCaseExample example);

    int deleteByExample(SuccessCaseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SuccessCase record);

    int insertSelective(SuccessCase record);

    List<SuccessCase> selectByExample(SuccessCaseExample example);

    SuccessCase selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SuccessCase record, @Param("example") SuccessCaseExample example);

    int updateByExample(@Param("record") SuccessCase record, @Param("example") SuccessCaseExample example);

    int updateByPrimaryKeySelective(SuccessCase record);

    int updateByPrimaryKey(SuccessCase record);

    @Select(" SELECT p.id as storeId , p.tel as transferTel ,s.tel AS lookTel ,p.contacts AS transfer , s.contacts AS looker ,t.sys_user AS sysUser ,(SELECT city_name FROM bs_city WHERE city_id = p.city_id) as city , t.success_time as successTime FROM success_case t\n" +
            "    JOIN  transfer_shop p on p.id=t.transfer_shop_id\n" +
            "    JOIN look_shop s on s.id = t.look_shop_id order by t.success_time desc ")
    List<SuccessCaseDTO> findAll();

    List<SuccessCaseDTO> list(@Param("looker") String looker, @Param("lookTel")String lookTel, @Param("transfer")String transfer, @Param("transferTel") String transferTel);
}