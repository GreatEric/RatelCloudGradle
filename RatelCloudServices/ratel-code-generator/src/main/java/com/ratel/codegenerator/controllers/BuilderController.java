package com.ratel.codegenerator.controllers;

import com.ratel.codegenerator.builders.*;
import com.ratel.codegenerator.entities.DBConnection;
import com.ratel.codegenerator.entities.Rsp;
import com.ratel.codegenerator.entities.forms.DBConnectionForm;
import com.ratel.codegenerator.entities.table.JavaTypes;
import com.ratel.codegenerator.entities.table.ModelInfo;
import com.ratel.codegenerator.repositories.DBConnectionRepository;
import com.ratel.codegenerator.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@CrossOrigin
@Api(tags = "构建器Controller")
@RestController
@RequestMapping("/codegenerate")
public class BuilderController {
    @Autowired
    private DBConnectionRepository dbConnectionRepository;

    @ApiOperation(value = "添加基础配置")
    @PostMapping(value = "/connectdb")
    public Rsp connectDB(@RequestBody DBConnectionForm dbconnForm) {
        Connection conn = null;
        ArrayList<Map<String, Object>> tableList = null;

        switch (dbconnForm.getDbType()) {
            case 1: {
                //连接Mysql数据库
                conn = connectMysql(dbconnForm);
                DBConnection optDBConnect = dbConnectionRepository.findBySchemaName(dbconnForm.getSchemaName());
                if (optDBConnect == null) {
                    //设置数据库连接配置
                    DBConnection dbConnection = new DBConnection();
                    dbConnection.setConfigName(dbconnForm.getConfigName());
                    dbConnection.setDbType(dbconnForm.getDbType());
                    dbConnection.setHostName(dbconnForm.getHostName());
                    dbConnection.setPort(dbconnForm.getPort());
                    dbConnection.setUserName(dbconnForm.getUserName());
                    dbConnection.setPwd(dbconnForm.getPwd());
                    dbConnection.setSchemaName(dbconnForm.getSchemaName());
                    dbConnection.setSaveConfig(dbconnForm.getSaveConfig());
                    dbConnectionRepository.save(dbConnection);
                }

                try {
                    //获取数据库表信息
                    tableList = getTables(conn);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
                break;
            }
            case 2:
                break;
            case 3:
                break;
        }

        //获取数据库类型：MySQL
        return Rsp.builder()
                .success()
                .add("list", tableList)
                .build();
    }

    @ApiOperation(value = "测试连接")
    @PostMapping(value = "/testConnection")
    public Rsp testConnection(@RequestBody DBConnectionForm dbconnForm) {
        Connection conn = null;

        switch (dbconnForm.getDbType()) {
            case 1: {
                conn = connectMysql(dbconnForm);
                DatabaseMetaData metaData = null;
                try {
                    metaData = conn.getMetaData();
                    String databaseType = metaData.getDatabaseProductName();
                    if (databaseType.equals("MySQL")) {
                        String database = conn.getCatalog();
                        return Rsp.builder().success().add("result", "Connect to mysql database " + database + " successfully.").build();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
                break;
            }
            case 2:
                break;
            case 3:
                break;
        }

        return Rsp.builder()
                .error(500, "Failed to connect database!")
                .build();
    }

    @ApiOperation(value = "获取数据库连接配置")
    @GetMapping(value = "/listDBConnectConfig")
    public Rsp listDBConnectConfig() {
        List<DBConnection> list = dbConnectionRepository.findAll();
        return Rsp.builder()
                .success()
                .add("list", list)
                .build();
    }

    @ApiOperation(value = "构建")
    @PostMapping(value = "/build")
    public Rsp build(@RequestBody Map<String, Object> params) {
        String company = params.get("company").toString();
        String templatePath = params.get("templatePath").toString();
        String buildPath = params.get("buildPath").toString();
        String packageName = params.get("packageName").toString();
        ArrayList<Map<String, Object>> modalMap = (ArrayList<Map<String, Object>>) params.get("buildTables");

        /*Debugger.printJson("构建参数-template path:",templatePath);
        Debugger.printJson("构建参数-build path:",buildPath);
        Debugger.printJson("构建参数-package name:",packageName);*/

        modalMap.forEach(item -> {
            //Map<String, Object> map = (Map<String, Object>)item.get("models");
            //Debugger.sysprint("构建参数-build table:",item.get("TableName").toString());
            //Debugger.printJson("构建数据:",item);

            item.put("company",company);
            item.put("package",packageName);
            LocalDateTime time=LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String timeStr = dtf.format(time);
            item.put("createTime", timeStr);

            BuilderFactory.buildPath = buildPath;
            BuilderFactory.templatePath = templatePath;

            PojoBuilder.build(item, BuilderFactory.POJO);

            DTOBuilder.build(item,BuilderFactory.DTO);

            VOBuilder.build(item,BuilderFactory.VO);

            QueryFormBuilder.build(item,BuilderFactory.QUERYFORM);

            MapperBuilder.build(item, BuilderFactory.MAPPER);

            MapperXMLBuilder.build(item, BuilderFactory.MAPPERXML);

            ServiceBuilder.build(item, BuilderFactory.SERVICE);

            ServiceImplBuilder.build(item, BuilderFactory.SERVICEIMPL);

            ControllerBuilder.build(item, BuilderFactory.CONTROLLER);

            VueTBColumnsBuilder.build(item,BuilderFactory.VUETBCOLUMN);

        });

        return Rsp.builder()
                .success()
                .build();
    }

    private Connection connectMysql(DBConnectionForm dbconnForm) {
        Connection conn = null;
        StringBuffer sb = new StringBuffer();
        sb.append("jdbc:mysql://");
        sb.append(dbconnForm.getHostName() + ":");
        sb.append(dbconnForm.getPort() + "/");
        sb.append(dbconnForm.getSchemaName() + "?");
        sb.append("useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false");

        DatabaseMetaData metaData = null;
        try {
            conn = DriverManager.getConnection(sb.toString(), dbconnForm.getUserName(), dbconnForm.getPwd());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    private ArrayList<Map<String, Object>> getTables(Connection conn) throws SQLException {
        DatabaseMetaData databaseMetaData = conn.getMetaData();
        ResultSet tableSet = databaseMetaData.getTables(conn.getCatalog(), "%", "%", new String[]{"TABLE"});
        ArrayList<Map<String, Object>> tablesList = new ArrayList<Map<String, Object>>();

        while (tableSet.next()) {
            //获取表名
            String tableName = tableSet.getString("TABLE_NAME");
            //名字操作,去掉tab_,tb_，去掉_并转驼峰
            String table = StringUtils.replace_(StringUtils.replaceTab(tableName));
            //大写对象
            String Table = StringUtils.firstUpper(table);

            Map<String, Object> modelInfoMap = getColumns(conn, tableName);

            List<ModelInfo> models = (List) modelInfoMap.get("models");
            Set<String> typeSet = (Set) modelInfoMap.get("typeSet");
            String key = (String) modelInfoMap.get("key");
            String keyType = (String) modelInfoMap.get("keyType");

            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("table", table);
            modelMap.put("Table", Table);
            modelMap.put("swagger", false);
            modelMap.put("TableName", tableName);
            modelMap.put("models", models);
            modelMap.put("typeSet", typeSet);
            //主键操作
            modelMap.put("keySetMethod", "set" + StringUtils.firstUpper(StringUtils.replace_(key)));
            modelMap.put("keyType", keyType);

            //Debugger.printJson("原始数据:",modelMap);

            tablesList.add(modelMap);
        }
        return tablesList;
    }

    private Map<String, Object> getColumns(Connection conn, String tableName) throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet rs = metaData.getColumns(conn.getCatalog(), null, tableName, null);

        Map<String, Object> modelInfoMap = new HashMap<>();

        List<ModelInfo> columns = new ArrayList<ModelInfo>();
        //所有需要导包的类型
        Set<String> typeSet = new HashSet<String>();

        //获取主键
        ResultSet keySet = metaData.getPrimaryKeys(conn.getCatalog(), null, tableName);
        String key = "", keyType = "";
        while (keySet.next()) {
            String primaryKeyColumnName = keySet.getString("COLUMN_NAME");
            key = keySet.getString(4);
        }

        while (rs.next()) {
            //列的描述
            String desc = rs.getString("REMARKS");
            //获取列名
            String columnName = rs.getString("COLUMN_NAME");
            //处理列名
            String propertyName = StringUtils.replace_(columnName);
            //获取类型，并转成JavaType
            String javaType = JavaTypes.getType(rs.getInt("DATA_TYPE"));
            //是否自增
            String identity = rs.getString("IS_AUTOINCREMENT");

            ModelInfo columnInfo = new ModelInfo();
            columnInfo.setType(javaType);
            columnInfo.setSimpleType(JavaTypes.simpleName(javaType));
            columnInfo.setName(propertyName);
            columnInfo.setUpperName(StringUtils.firstUpper(propertyName));
            columnInfo.setDesc(desc);
            columnInfo.setId(key.equals(columnName));
            columnInfo.setColumn(columnName);
            columnInfo.setIdentity(identity);

            columns.add(columnInfo);

            typeSet.add(javaType);

            //主键类型
            if (columnName.equals(key)) {
                keyType = JavaTypes.simpleName(javaType);
            }
        }
        modelInfoMap.put("models", columns);
        modelInfoMap.put("typeSet", typeSet);
        modelInfoMap.put("key", key);
        modelInfoMap.put("keyType", keyType);
        return modelInfoMap;
    }
}
