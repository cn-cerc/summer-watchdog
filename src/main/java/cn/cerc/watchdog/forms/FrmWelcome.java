package cn.cerc.watchdog.forms;

import cn.cerc.jbean.form.IPage;
import cn.cerc.jmis.form.AbstractForm;
import cn.cerc.jmis.page.JspPage;
import cn.cerc.watchdog.tools.ECSControler;

public class FrmWelcome extends AbstractForm {

    @Override
    public IPage execute() {
        return new JspPage(this, "common/FrmWatchDog.jsp");
        
        ECSControler ecs = new ECSControler();
		ecs.reset("i-j6c2ct08gslpbxsxkqwo");
    }

    @Override
    public boolean logon() {
        return true;
    }
}
