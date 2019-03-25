package org.apache.test.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author meijunjie
 * @date 2019/1/29
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application implements Serializable{
    private Integer id;
    private String applicationName;
    private String owner;
    private String createTime;
    private String modifyTime;



}
