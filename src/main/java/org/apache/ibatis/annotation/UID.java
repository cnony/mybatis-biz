/**
 * Copyright (c) 2011-2014, hubin (jobob@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.ibatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.ibatis.session.enums.PKStrategy;

/**
 * <p>
 * 表主键标识
 * </p>
 * 
 * @author hubin
 * @Date 2016-01-23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UID {

	/*
	 * <p>
	 * 字段值（驼峰命名方式，该值可无）
	 * </p>
	 */
	String value() default "";

	/*
	 * <p>
	 * 主键ID，默认 INPUT
	 * </p>
	 * {@link IdType}
	 */
	PKStrategy type() default PKStrategy.INPUT;

}
