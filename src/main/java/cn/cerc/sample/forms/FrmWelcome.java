package cn.cerc.sample.forms;

import cn.cerc.jbean.form.IPage;
import cn.cerc.jmis.form.AbstractForm;
import cn.cerc.jmis.page.JspPage;

public class FrmWelcome extends AbstractForm {

    @Override
    public IPage execute() {
        return new JspPage(this, "common/FrmWatchDog.jsp");
    }

    @Override
    public boolean logon() {
        return true;
    }
}
