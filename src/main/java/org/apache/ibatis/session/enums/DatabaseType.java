package org.apache.ibatis.session.enums;

/**
 * <p>
 * 数据库类型
 * </p>
 */
public enum DatabaseType {
	
	/**
	 * MYSQL
	 */
	MYSQL("mysql", "`%s`", "MySql数据库"),
	/**
	 * ORACLE
	 */
	ORACLE("oracle", "", "Oracle数据库"),
	/**
	 * DB2
	 */
	DB2("db2", "", "DB2数据库"),
	/**
	 * H2
	 */
	H2("h2", "", "H2数据库"),
	/**
	 * HSQL
	 */
	HSQL("hsql", "", "HSQL数据库"),
	/**
	 * SQLITE
	 */
	SQLITE("sqlite", "`%s`", "SQLite数据库"),
	/**
	 * POSTGRE
	 */
	POSTGRE("postgresql", "", "Postgre数据库"),
	/**
	 * SQLSERVER2005
	 */
	SQLSERVER2005("sqlserver2005", "[%s]", "SQLServer2005数据库"),
	/**
	 * SQLSERVER
	 */
	SQLSERVER("sqlserver", "[%s]", "SQLServer数据库"),
	/**
	 * UNKONWN DB
	 */
	OTHER("other", "", "其他数据库");

	private final String db;

	private final String quote;

	private final String desc;

	DatabaseType(final String db, final String quote, final String desc) {
		this.db = db;
		this.quote = quote;
		this.desc = desc;
	}

	/**
	 * <p>
	 * 获取数据库类型（默认 MySql）
	 * </p>
	 * @param dbType 数据库类型字符串
	 * @return
	 */
	public static DatabaseType getDBType(String dbType) {
		DatabaseType[] dts = DatabaseType.values();
		for (DatabaseType dt : dts) {
			if (dt.getDb().equalsIgnoreCase(dbType)) {
				return dt;
			}
		}
		return MYSQL;
	}

	public String getDb() {
		return this.db;
	}

	public String getQuote() {
		return this.quote;
	}

	public String getDesc() {
		return this.desc;
	}

}
