package com.neuedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.entity.Teacher;
import io.minio.errors.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * 教师表 服务类
 * </p>
 *
 * @author 施子安
 * @since 2022-12-27
 */
public interface TeacherService extends IService<Teacher> {

    IPage<Teacher> list(int pageNo, int pageSize, Object val);

    Boolean add(String name, String tel, String email, Integer collegeId,String password, MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException;

    Boolean update(Integer id, String name, String tel, String email,Integer collegeId,  MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException;
}
