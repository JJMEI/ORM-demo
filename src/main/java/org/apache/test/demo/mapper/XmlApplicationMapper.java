package org.apache.test.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.test.demo.pojo.Application;

import java.util.List;

/**
 * Created by meijunjie on 2019/2/13.
 */
@Mapper
public interface XmlApplicationMapper {

    /**
     * 查询所有的Application
     * @return
     */
    List<Application> findAllApplications();
}
