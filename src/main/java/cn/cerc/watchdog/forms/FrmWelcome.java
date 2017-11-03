package cn.cerc.watchdog.forms;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.cerc.jbean.form.IPage;
import cn.cerc.jmis.form.AbstractForm;
import cn.cerc.jmis.page.JspPage;
import cn.cerc.watchdog.tools.HttpClientUtil;

public class FrmWelcome extends AbstractForm {
    private static Logger log = Logger.getLogger(HttpClientUtil.class);
    private static int times = 0;
    boolean flag1 = true;
    boolean flag2 = true;

    @Override
    public IPage execute() {
        JspPage page = new JspPage(this, "common/FrmWatchDog.jsp");
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("token", "0");
        String result1 = HttpClientUtil.get("http://47.91.199.67/forms/FrmLogin", paramsMap, "UTF-8");
        if (result1 == null) {
            flag1 = false;
        }
        if (!flag1) {
            log.info("服务器一异常");
            // ECSControler ecs = new ECSControler();
            // ecs.reset("i-j6c2ct08gslpbxsxkqwo");
        } else {
            log.info("服务器一正常");
        }
        String result2 = HttpClientUtil.get("", paramsMap, "UTF-8");
        if (result2 == null) {
            flag2 = false;
        }
        if (!flag2) {
            log.info("服务器二异常");
            // ECSControler ecs = new ECSControler();
            // ecs.reset("i-j6c2ct08gslpbxsxkqwo");
        } else {
            log.info("服务器二正常");
        }
        page.add("flag1", flag1);
        page.add("flag2", flag2);
        times++;
        return page;

    }

    public static void main(String[] args) {
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("token", "0");
        String result = HttpClientUtil.get("http://47.91.199.67/forms/FrmLogin", paramsMap, "UTF-8");
        System.out.println(result);
    }

    @Override
    public boolean logon() {
        return true;
    }
}
