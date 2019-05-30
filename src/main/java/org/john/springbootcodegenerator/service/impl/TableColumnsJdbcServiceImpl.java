package org.john.springbootcodegenerator.service.impl;

import java.util.List;

import org.john.springbootcodegenerator.config.DatasourceConfig;
import org.john.springbootcodegenerator.entity.TableColumns;
import org.john.springbootcodegenerator.service.TableColumnsJdbcService;
import org.john.springbootcodegenerator.utils.DataBaseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TableColumnsJdbcServiceImpl  implements TableColumnsJdbcService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired 
	private DatasourceConfig datasourceSettings;

	/**
	 * 获取表结构
	 * 
	 * @author johnDeng
	 * @dataTime 2019年3月5日下午3:51:10
	 * @param tableName
	 * @return
	 */
	@Override
	public List<TableColumns> getListByTable(String tableName) {
		String sql = "SELECT TABLE_SCHEMA AS tableSchema,TABLE_NAME AS tableName,COLUMN_NAME AS columnName,"
				+ " ORDINAL_POSITION AS ordinalPosition,IS_NULLABLE AS notNullFlag,DATA_TYPE AS dataType,"
				+ " CHARACTER_MAXIMUM_LENGTH AS columnLength,COLUMN_KEY AS  cloumnKey,COLUMN_COMMENT AS cloumnComent "
				+ " FROM information_schema.columns WHERE table_schema = '"
				+ DataBaseUtils.getDatabaseName(datasourceSettings.getUrl()) + "'  AND table_name = '" + tableName + "' ";
		logger.debug("jdbc getListByTable:"+sql);
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<TableColumns>(TableColumns.class));
	}

}
