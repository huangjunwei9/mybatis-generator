package org.john.springbootcodegenerator.enums;

/**
 * 数据类型枚举
 * @author JohnDeng
 * @datatime 2019年1月17日上午9:49:04
 */
public enum DataTypeEnums {

	VARCHAR("VARCHAR","String"),
	CHAR("CHAR","String"),
	LONGVARCHAR("LONGVARCHAR","String"),
	NUMERIC("NUMERIC","java.math.BigDecimal"),
	DECIMAL("DECIMAL","java.math.BigDecimal"),
	
	BLOB("blob","byte[]"),
	TEXT("text","String"),
	INTEGER("integer","Integer"),
	TINYINT("tinyint","Integer"),
	SMALLINT("varchar","Integer"),
	MEDIUMINT("mediumint","Integer"),
	BIT("bit","Boolean"),
	BIGINT("varchar","BigInteger"),
	FLOAT("float","Float"),
	DOUBLE("double","Double"),
	
	BOOLEAN("varchar","Integer"),
	DATE("date","Date"),
	DATETIME("datetime","java.util.Date"),
	INT("int","int"),
	TIMESTAMP("timestamp","java.util.Date");
 	
	
	private final String mySqlDataType;
	private final String javaDataType;
	

	public static String getJavaDataTypeByMysqlDataType(String mySqlDataType) {
		
		for (DataTypeEnums e : DataTypeEnums.values()) {
			if (e.getMySqlDataType().contains(mySqlDataType)) {
				return e.getJavaDataType();
			}
		}
		return "";
	}
	
	
	private DataTypeEnums(String mySqlDataType, String javaDataType) {
		this.mySqlDataType = mySqlDataType;
		this.javaDataType = javaDataType;
	}
	public String getMySqlDataType() {
		return mySqlDataType;
	}
	public String getJavaDataType() {
		return javaDataType;
	}
}
