package com.ratel.codegenerator.builders;

import freemarker.template.Template;

import java.io.File;
import java.util.Map;

/**
 * RatelCloud
 * @ClassName: BuilderFactory
 * @Package: com.ratel.codegenerator.builders
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 6/10/20
 * @Description: 构建对象的工厂
 * @Version: 1.0
 */
public class BuilderFactory {
    public static int POJO = 1;
    public static int DTO = 2;
    public static int VO = 3;
    public static int QUERYFORM = 4;
    public static int MAPPER = 5;
    public static int MAPPERXML = 6;
    public static int SERVICE = 7;
    public static int SERVICEIMPL = 8;
    public static int CONTROLLER = 9;
    public static int VUETBCOLUMN = 10;

    public static String buildPath;
    public static String templatePath;

    /**
     * @Author: Eric
     * @Date: 9:42 pm
     * @Description: 构建器
     * @Param:
     * @Return:
     */
    public static void builder(Map<String, Object> modelMap, int type) {
        try {
            switch (type) {
                case 1:
                    buildPOJO(modelMap);
                    break;
                case 2:
                    buildDTO(modelMap);
                    break;
                case 3:
                    buildVO(modelMap);
                    break;
                case 4:
                    buildQueryForm(modelMap);
                    break;
                case 5:
                    buildMapper(modelMap);
                    break;
                case 6:
                    buildMapperXML(modelMap);
                    break;
                case 7:
                    buildService(modelMap);
                    break;
                case 8:
                    buildServiceImpl(modelMap);
                    break;
                case 9:
                    buildController(modelMap);
                    break;
                case 10:
                    buildVueTBColumn(modelMap);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author: Eric
     * @Date: 9:43 pm
     * @Description: 构建POJO
     * @Param:
     * @Return:
     */
    private static void buildPOJO(Map<String, Object> modelMap) {
        String templateFilePath = templatePath + "/pojo";
        String suffix = ".java";
        String packageName = modelMap.get("package").toString()+".api.pojos";
        modelMap.put("pojoPackage",packageName);
        try {
            //获取模板对象
            Template template = TemplateUtil.loadTemplate(templateFilePath, "Pojo.java");

            //创建文件夹
            File file = new File(buildPath + "/pojos/");
            if (!file.exists()) {
                file.mkdirs();
            }
            //创建文件
            TemplateUtil.writer(template, modelMap, file.getAbsolutePath() + "/" + modelMap.get("Table") + suffix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author: Eric
     * @Date: 9:43 pm
     * @Description: 构建Mapper
     * @Param:
     * @Return:
     */
    private static void buildMapper(Map<String, Object> modelMap) {
        String templateFilePath = templatePath + "/mapper";
        String suffix = ".java";
        String packageName = modelMap.get("package").toString()+".mappers";
        modelMap.put("mapperPackage",packageName);
        try {
            //获取模板对象
            Template template = TemplateUtil.loadTemplate(templateFilePath, "Mapper.java");

            //创建文件夹
            File file = new File(buildPath + "/mappers/");
            if (!file.exists()) {
                file.mkdirs();
            }
            //创建文件
            TemplateUtil.writer(template, modelMap, file.getAbsolutePath() + "/" + modelMap.get("Table") + "Mapper" + suffix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author: Eric
     * @Date: 9:43 pm
     * @Description: 构建MapperXML
     * @Param:
     * @Return:
     */
    private static void buildMapperXML(Map<String, Object> modelMap) {
        String templateFilePath = templatePath + "/mapper";
        String suffix = ".xml";
        String packageName = modelMap.get("package").toString()+".mappers";
        modelMap.put("mapperXmlPackage",packageName);
        try {
            //获取模板对象
            Template template = TemplateUtil.loadTemplate(templateFilePath, "Mapper.xml");

            //创建文件夹
            File file = new File(buildPath + "/mappersxml/");
            if (!file.exists()) {
                file.mkdirs();
            }
            //创建文件
            TemplateUtil.writer(template, modelMap, file.getAbsolutePath() + "/" + modelMap.get("Table") + "Mapper" + suffix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author: Eric
     * @Date: 9:43 pm
     * @Description: 构建Service
     * @Param:
     * @Return:
     */
    private static void buildService(Map<String, Object> modelMap) {
        String templateFilePath = templatePath + "/service";
        String suffix = ".java";
        String packageName = modelMap.get("package").toString()+".services";
        modelMap.put("servicePackage",packageName);
        try {
            //获取模板对象
            Template template = TemplateUtil.loadTemplate(templateFilePath, "Service.java");

            //创建文件夹
            File file = new File(buildPath + "/services/");
            if (!file.exists()) {
                file.mkdirs();
            }
            //创建文件
            TemplateUtil.writer(template, modelMap, file.getAbsolutePath() + "/" + modelMap.get("Table") + "Service" + suffix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author: Eric
     * @Date: 9:43 pm
     * @Description: 构建ServiceImpl
     * @Param:
     * @Return:
     */
    private static void buildServiceImpl(Map<String, Object> modelMap) {
        String templateFilePath = templatePath + "/service/impl";
        String suffix = ".java";
        String packageName = modelMap.get("package").toString()+".services.impl";
        modelMap.put("serviceImplPackage",packageName);
        try {
            //获取模板对象
            Template template = TemplateUtil.loadTemplate(templateFilePath, "ServiceImpl.java");

            //创建文件夹
            File file = new File(buildPath + "/services/impl/");
            if (!file.exists()) {
                file.mkdirs();
            }
            //创建文件
            TemplateUtil.writer(template, modelMap, file.getAbsolutePath() + "/" + modelMap.get("Table") + "ServiceImpl" + suffix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author: Eric
     * @Date: 9:43 pm
     * @Description: 构建Controller
     * @Param:
     * @Return:
     */
    private static void buildController(Map<String, Object> modelMap) {
        String templateFilePath = templatePath + "/controller";
        String suffix = ".java";
        String packageName = modelMap.get("package").toString()+".controllers";
        modelMap.put("controllerPackage",packageName);
        try {
            //获取模板对象
            Template template = TemplateUtil.loadTemplate(templateFilePath, "Controller.java");

            //创建文件夹
            File file = new File(buildPath + "/controllers/");
            if (!file.exists()) {
                file.mkdirs();
            }
            //创建文件
            TemplateUtil.writer(template, modelMap, file.getAbsolutePath() + "/" + modelMap.get("Table") + "Controller" + suffix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void buildDTO(Map<String, Object> modelMap) {
        String templateFilePath = templatePath + "/dto";
        String suffix = ".java";
        String packageName = modelMap.get("package").toString()+".api.dtos";
        modelMap.put("dtoPackage",packageName);
        try {
            //获取模板对象
            Template template = TemplateUtil.loadTemplate(templateFilePath, "Dto.java");

            //创建文件夹
            File file = new File(buildPath + "/dtos/");
            if (!file.exists()) {
                file.mkdirs();
            }
            //创建文件
            TemplateUtil.writer(template, modelMap, file.getAbsolutePath() + "/" + modelMap.get("Table") + "DTO" + suffix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void buildVO(Map<String, Object> modelMap) {
        String templateFilePath = templatePath + "/vo";
        String suffix = ".java";
        String packageName = modelMap.get("package").toString()+".api.vos";
        modelMap.put("voPackage",packageName);
        try {
            //获取模板对象
            Template template = TemplateUtil.loadTemplate(templateFilePath, "Vo.java");

            //创建文件夹
            File file = new File(buildPath + "/vos/");
            if (!file.exists()) {
                file.mkdirs();
            }
            //创建文件
            TemplateUtil.writer(template, modelMap, file.getAbsolutePath() + "/" + modelMap.get("Table") + "VO" + suffix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void buildQueryForm(Map<String, Object> modelMap) {
        String templateFilePath = templatePath + "/form";
        String suffix = ".java";
        String packageName = modelMap.get("package").toString()+".api.forms";
        modelMap.put("formPackage",packageName);
        try {
            //获取模板对象
            Template template = TemplateUtil.loadTemplate(templateFilePath, "form.java");

            //创建文件夹
            File file = new File(buildPath + "/forms/");
            if (!file.exists()) {
                file.mkdirs();
            }
            //创建文件
            TemplateUtil.writer(template, modelMap, file.getAbsolutePath() + "/" + modelMap.get("Table") + "QueryForm" + suffix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void buildVueTBColumn(Map<String, Object> modelMap) {
        String templateFilePath = templatePath + "/vue";
        String suffix = ".js";
        try {
            //获取模板对象
            Template template = TemplateUtil.loadTemplate(templateFilePath, "column.js");

            //创建文件夹
            File file = new File(buildPath + "/vue/");
            if (!file.exists()) {
                file.mkdirs();
            }
            //创建文件
            TemplateUtil.writer(template, modelMap, file.getAbsolutePath() + "/tb" + modelMap.get("table") + "column" + suffix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
