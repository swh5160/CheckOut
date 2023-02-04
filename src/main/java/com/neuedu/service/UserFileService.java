package com.neuedu.service;

import com.neuedu.entity.UserFile;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 文件表 服务类
 * </p>
 *
 * @author 施子安
 * @since 2022-12-28
 */
public interface UserFileService extends IService<UserFile> {

    UserFile get(String md5,Long size,String extension);
}
