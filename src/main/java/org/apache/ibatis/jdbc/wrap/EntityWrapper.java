package org.apache.ibatis.jdbc.wrap;

import org.apache.ibatis.utils.ReflectionUtils;
import org.apache.ibatis.utils.StringUtils;

/**
 * <p>
 * Entity 对象封装操作类，定义T-SQL语法
 * </p>
 */
@SuppressWarnings("serial")
public class EntityWrapper<T> extends Wrapper<T> {

	/**
	 * 拼接WHERE后应该是AND还是OR
	 */
	private String AND_OR = "AND";
	/**
	 * 数据库表映射实体类
	 */
	protected T entity = null;

	public EntityWrapper() {
		/* 注意，传入查询参数 */
	}

	public EntityWrapper(T entity) {
		this.entity = entity;
	}

	public EntityWrapper(T entity, String sqlSelect) {
		this.entity = entity;
		this.sqlSelect = sqlSelect;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	/**
	 * <p>
	 * 添加OR条件
	 * </p>
	 *
	 * @param sqlOr
	 *            or 条件语句
	 * @param params
	 *            参数集
	 * @return this
	 */
	@Override
	public Wrapper<T> or(String sqlOr, Object... params) {
		if (StringUtils.isEmpty(transactSQL.toString())) {
			AND_OR = "OR";
		}
		super.or(sqlOr, params);
		return this;
	}

	/**
	 * <p>
	 * 使用OR换行，并添加一个带()的新的条件
	 * </p>
	 * <p>
	 * eg: ew.where("name='zhangsan'").and("id=11").orNew("statu=1"); 输出： WHERE
	 * (name='zhangsan' AND id=11) OR (statu=1)
	 * </p>
	 *
	 * @param sqlOr
	 *            AND 条件语句
	 * @param params
	 *            参数值
	 * @return this
	 */
	@Override
	public Wrapper<T> orNew(String sqlOr, Object... params) {
		if (StringUtils.isEmpty(transactSQL.toString())) {
			AND_OR = "OR";
		}
		super.orNew(sqlOr, params);
		return this;
	}

	/**
	 * SQL 片段
	 */
	@Override
	public String getSqlSegment() {
		/*
		 * 无条件
		 */
		String sqlWhere = transactSQL.toString();
		if (StringUtils.isEmpty(sqlWhere)) {
			return null;
		}

		/*
		 * 根据当前实体判断是否需要将WHERE替换成 AND 增加实体不为空但所有属性为空的情况
		 */
		sqlWhere = ReflectionUtils.checkFieldValueNotNull(entity) ? sqlWhere.replaceFirst("WHERE", AND_OR) : sqlWhere;
		return sqlWhere;
	}

}
