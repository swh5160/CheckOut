package com.neuedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.entity.Teacher;
import com.neuedu.vo.TeacherVo;
import io.minio.errors.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * <p>
 * 教师表 服务类
 * </p>
 *
 * @author 施子安
 * @since 2022-12-27
 */
public interface TeacherService extends IService<Teacher> {

    IPage<Teacher> list(int pageNo, int pageSize,Object val);

    Boolean add(String name, String tel, String email, Integer collegeId, String password, MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException;

    Boolean update(Integer id, String name, String tel, String email, Integer collegeId, MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException;


    IPage<TeacherVo> teacherlist(Integer pageNo, Integer pageSize, String val);

    List<Teacher> findByIds();

//    Map<String, Object> login(String name, String password) throws Exception;
    Teacher login(String name, String password) throws Exception;

    List<Teacher> getActive();

}
