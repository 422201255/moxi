package com.moxi.dao;

import com.moxi.pojo.PersonalInfomation;
import com.moxi.pojo.Tester;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 插入应试者的信息
 *  应试者相关的信息
 * Created by yangfeng on 19/08/2018.
 */
@Mapper
public interface TesterMapper {

    /**
     * 插入应试者信息
     * @param tester
     */
    void insertTester(Tester tester);


    /**
     * 查询该用户是否已经注册
     * @return
     */
    int selectTesterExists(@Param("series_number") String series_number,
                           @Param("id_number") String id_number);

    /**
     * 查看用户账号是否存在
     * @param account
     * @return
     */
    int selectAccountExists(@Param("account") String account);


    /**
     * 通过账号密码选取用户
     * @param account
     * @param password
     * @return
     */
    Tester selectTesterByAccountAndPassword(@Param("account") String account,
                                            @Param("password") String password);

    /**
     * 获取个人存储的信息
     * @param personalInfomation
     */
    void saveTesterInfo(PersonalInfomation personalInfomation);

    /**
     * 查看是否存在信息录入
     * @param series_number
     * @param id_number
     * @return
     */
    int getIfPersonalInfoExit(@Param("series_number") String series_number,
                              @Param("id_number") String id_number);

    /**
     * 修改密码
     * @param userName
     * @param seriesNumber
     * @param password
     */
    void updatePassword(@Param("account") String userName,
                        @Param("series_number") String seriesNumber,
                        @Param("password") String password);

    /**
     * 通过两个字段查找考生信息，为打印做准备
     * @param series_number
     * @param id_number
     * @return
     */
    PersonalInfomation getPersonalInfo(@Param("series_number") String series_number,
                                       @Param("id_number") String id_number);

    /**
     * 根据身份证号码，更新考生的照片信息不符合要求
     * @param idNumber
     */
    void updatePicFailure(@Param("id_number") String idNumber,
                          @Param("check_status") int checkStatus);

    /**
     * 更新图片的存储位置
     * @param photo
     */
    void updatePicLoad(@Param("photo") String photo,
                       @Param("id_number") String idNumber);
}
