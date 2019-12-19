package org.wangyu.springcloud.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable//必须序列化
{
	private Long deptno;
	private String dname;
	private String db_source;  //一个微服务对应一个单独的数据库，统一信息储存到不同的数据库
}
