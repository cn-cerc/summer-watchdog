package cn.cerc.watchdog.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.cerc.jbean.form.IPage;
import cn.cerc.jmis.form.AbstractForm;
import cn.cerc.jmis.page.JspPage;
import cn.cerc.watchdog.tools.ECSControler;
import cn.cerc.watchdog.tools.HttpClientUtil;

public class FrmWelcome extends AbstractForm {
    private static Logger log = Logger.getLogger(FrmWelcome.class);
    private static List<ServerItem> items = new ArrayList<>();
    private static String myToken = "123456";
    static {
        ServerItem item;

        item = new ServerItem("master-linux");
        item.instanceId = "i-j6c2hqbtt8ujtzblwb28";
        item.url = "http://47.52.210.166:8080/forms/FrmLogin";
        items.add(item);
    }

    @Override
    public IPage execute() {
        JspPage page = new JspPage(this, "common/FrmWelcome.jsp");
        String token = this.getRequest().getParameter("token");
        if (token == null || !token.equals(myToken)) {
            page.setJspFile("common/forBidden.jsp");
            return page;
        }
        for (ServerItem item : items) {
            if (getServerStatus(item.url)) {
                item.error = 0;
                item.status = "正常";
            } else {
                item.error += 1;
                if (item.error > 0)
                    item.status = "异常";
            }
            if (item.error > 3) {
                try {
                    ECSControler ecs = new ECSControler();
                    ecs.reset(item.getInstanceId());
                    item.status = "重启中";
                    item.error = -600;
                } catch (Exception e) {
                    item.status = e.getMessage();
                }
            }
        }
        page.add("items", items);
        return page;

    }

    private boolean getServerStatus(String url) {
        try {
            Map<String, String> paramsMap = new HashMap<String, String>();
            paramsMap.put("token", "0");
            String result1 = HttpClientUtil.get(url, paramsMap, "UTF-8");
            return result1 != null;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean logon() {
        return true;
    }
}
