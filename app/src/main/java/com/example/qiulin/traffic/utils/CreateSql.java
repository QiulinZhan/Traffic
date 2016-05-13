package com.example.qiulin.traffic.utils;


import org.apache.commons.lang.StringEscapeUtils;

import java.lang.reflect.Field;
/**
 * @author zuoshiqi
 *
 */
public class CreateSql {
	/****
	 * 
	 * 
	 * @param obj     传入要生成的实体，生成 sql
	 * @author zsq
	 * @return 拼成的 sql 语句
	 */

	/****
	 * INSERT INTO table(field1,field2) VALUES('value1','value2');
	 * @param obj 传入要生成的实体
	 * @return 拼成的insert 语句
	 */
	public static String getSqlInset(Object obj) {
		try {
			Class<? extends Object> c = obj.getClass();
			//获取所有的字段
			Field[] fields = c.getDeclaredFields();

			//获取实体的类名，需与表名一致
			String tableName = c.getSimpleName();
			//生成INSERT INTO table(field1,field2) 部分
			StringBuffer sbField = new StringBuffer();
			//生成VALUES('value1','value2') 部分
			StringBuffer sbValue = new StringBuffer();
			sbField.append("INSERT INTO t" + converXTo_x(tableName) + "(");
			int fieldLength = fields.length;
			for(int i=0;i<fieldLength;i++){
				fields[i].setAccessible(true);
				if(fields[i].getName().equalsIgnoreCase("serialVersionUID")){
					continue;
				}
				if(fields[i].getName().equalsIgnoreCase("$change")){
					continue;
				}
				sbField.append(converXTo_x(fields[i].getName())+',');
				if(fields[i].get(obj)==null){
					sbValue.append("null,");
				}else{
					sbValue.append("'"+fields[i].get(obj).toString() +"',");
				}
				
			}
			return sbField.replace(sbField.length()-1, sbField.length(), ") VALUES(").append(sbValue.replace(sbValue.length()-1, sbValue.length(), ");")).toString();
		}catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	
	/****
	 * @param obj 传入要生成的实体
	 * @return 拼成的updatae语句
	 */
	public static String getSqlUpdate(Object obj) {
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			String tableName = obj.getClass().getSimpleName();
			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE  t"+ converXTo_x(tableName) +" SET ");
			int fieldLength = fields.length;
			for(int i=0;i<fieldLength;i++){
				if(fields[i].getName().equalsIgnoreCase("serialVersionUID")){
					continue;
				}else if(fields[i].getName().equalsIgnoreCase("id")){
					continue;
				}
				fields[i].setAccessible(true);
				String fieldName = "= null ,";
				if( fields[i].get(obj)!=null){
					fieldName = " = '"+fields[i].get(obj) +"' ,";
					sb.append(converXTo_x(fields[i].getName()) +  fieldName);
				}
				
			}
			return sb.replace(sb.length()-1, sb.length(), " ").toString();
		}catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	/****
	 * @param obj 传入要生成的实体
	 * @return 拼成的updatae语句
	 */
	public static String getSqlUpdateAllowNull(Object obj) {
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			String tableName = obj.getClass().getSimpleName();
			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE  t"+ converXTo_x(tableName) +" SET ");
			int fieldLength = fields.length;
			for(int i=0;i<fieldLength;i++){
				if(fields[i].getName().equalsIgnoreCase("serialVersionUID")){
					continue;
				}else if(fields[i].getName().equalsIgnoreCase("id")){
					continue;
				}
				fields[i].setAccessible(true);
				String fieldName = "= null ,";
				if( fields[i].get(obj) == null){
					fieldName = " = "+fields[i].get(obj) +" ,";
				}else{
					fieldName = " = '"+fields[i].get(obj) +"' ,";
				}
				sb.append(converXTo_x(fields[i].getName()) +  fieldName);
				
			}
			return sb.replace(sb.length()-1, sb.length(), " ").toString();
		}catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public static String getSqlUpdate(Object obj,String tableName) {
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE  "+ tableName +" SET ");
			int fieldLength = fields.length;
			for(int i=0;i<fieldLength;i++){
				if(fields[i].getName().equalsIgnoreCase("serialVersionUID")){
					continue;
				}else if(fields[i].getName().equalsIgnoreCase("id")){
					continue;
				}
				fields[i].setAccessible(true);
				String fieldName = "= null ,";
				if( fields[i].get(obj)!=null){
					fieldName = " = '"+fields[i].get(obj) +"' ,";
					sb.append(converXTo_x(fields[i].getName()) +  fieldName);
				}
				
			}
			return sb.replace(sb.length()-1, sb.length(), " ").toString();
		}catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	
	
	/****
	 * 生成查询语句 方式为=
	 * @param obj 传入要生成的实体
	 * @return 拼成的select语句
	 */
	
	public static String getSqlSelectEqual(Object obj) {
		StringBuffer sb = new StringBuffer();
		String tableName = obj.getClass().getSimpleName();
		sb.append("SELECT * FROM  t"+ converXTo_x(tableName) +" WHERE 1=1 ");
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			int fieldLength = fields.length;
			for(int i=0;i<fieldLength;i++){
				if(fields[i].getName().equalsIgnoreCase("serialVersionUID")){
					continue;
				}
				fields[i].setAccessible(true);
				if( fields[i].get(obj)==null){
					continue;
				}
				String fieldName = " = '"+ StringEscapeUtils.escapeSql(fields[i].get(obj).toString()) +"' ";
				sb.append(" AND "+converXTo_x(fields[i].getName()) +  fieldName);
			}
			return sb.replace(sb.length()-1, sb.length(), " ").toString();
		}catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		return sb.toString();
	}
	
	/****
	 * 生成模糊查询语句 方式为like
	 * @param obj 传入要生成的实体
	 * @return 拼成的select语句
	 */
	public static String getSqlSelectLike(Object obj) {
		StringBuffer sb = new StringBuffer();
		String tableName = obj.getClass().getSimpleName();
		sb.append("SELECT * FROM  t"+ converXTo_x(tableName) +" WHERE 1=1 ");
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			int fieldLength = fields.length;
			for(int i=0;i<fieldLength;i++){
				if(fields[i].getName().equalsIgnoreCase("serialVersionUID")){
					continue;
				}
				fields[i].setAccessible(true);
				if( fields[i].get(obj)==null){
					continue;
				}
				String fieldName = " like '%"+StringEscapeUtils.escapeSql(fields[i].get(obj).toString()) +"%' ,";
				sb.append(" AND "+converXTo_x(fields[i].getName()) +  fieldName);
			}
			
			return sb.replace(sb.length()-1, sb.length(), " ").toString();
		}catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		return sb.toString();
	}


	/**
	 * 得到全字段模糊搜索
	 * @param obj 要查询的实体类
	 * @param keyValue 关键字
	 * @return
	 */
	public static String getSqlSelectAllLike(Object obj,String keyValue) {
		StringBuffer sb = new StringBuffer();
		StringBuffer colum = new StringBuffer();
		String  javaName = obj.getClass().getSimpleName();
		String tableName =  "t"+ converXTo_x(javaName);
		
		if(keyValue == null||keyValue.equals("")){
			return "SELECT * FROM "+tableName ;
		}
	
		sb.append("SELECT  "+tableName +".* FROM (SELECT c.id, CONCAT(");
		Field[] fields = obj.getClass().getDeclaredFields();
		int fieldLength = fields.length;
		for(int i=0;i<fieldLength;i++){
			if(fields[i].getName().equalsIgnoreCase("serialVersionUID")){
				continue;
			}
			fields[i].setAccessible(true);
			sb.append(" IFNULL(c."+converXTo_x(fields[i].getName())+",'') ," );
			colum.append(converXTo_x(fields[i].getName())+"," );
		}
		sb.replace(sb.length()-1, sb.length(), " ").toString();
		sb.append(") allclomn FROM  "+tableName+" c ) allvalue ,"+tableName);
		sb.append(" WHERE allvalue.allclomn LIKE '%"+StringEscapeUtils.escapeSql(keyValue)+"%'");
		sb.append(" AND allvalue.id = "+tableName+".id");
		colum.replace(colum.length()-1, colum.length(), " ").toString();
		String aa = colum.toString();
		return sb.toString();
	}
	
	
	
	/**
	 * ‘大写’与‘_小写’转换
	 * @param name
	 * @return
	 */
	private static String converXTo_x(String name) {
		char[] chX  = name.toCharArray();
		char[] ch_x = new char[chX.length*2];
		if(chX.length == 0){
			return name;
		}
		int j=0;
		for (int i = 0;i < chX.length;i++) {
			if(chX[i] >= 'A' && chX[i] <= 'Z'){
				ch_x[j] = ('_');
				j++;
				ch_x[j] = (char)(chX[i] + 32);
				j++;
				continue;
			}
			ch_x[j] = chX[i];
			j++;
		}
		return new String(ch_x).trim();
	}

	public static void main(String[] args) {
		System.out.println(converXTo_x("abcDefG")+"--");
	}

}
