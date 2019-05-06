package com.blessing.aisaka.constant;

import java.io.File;

/**
 * 常量
 *
 * @author zhou.peng
 * @date 2019/03/14
 */
public class Constant {
    /**
     * 用户角色
     */
    public static final String ROLE_ADMIN = "admin";

    public static final String ROLE_STUDENT = "student";

    /**
     * 文件上传路径
     */
    public static final String MATERIAL_PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "global" + File.separator + "material";
    public static final String PAPER_PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "global" + File.separator + "paper";
    /**
     * 文件访问路径
     */
    public static final String MATERIAL_URL = File.separator + "global" + File.separator + "material";
    public static final String PAPER_URL = File.separator + "global" + File.separator + "paper";


}
