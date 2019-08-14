package com.yunmayi.app.baselibrary.view;

/**
 * View父接口，用于后面mvp架构
 *
 * Author: nanchen
 * Email: liushilin520@foxmail.com
 * Date: 2017-04-07  16:26
 */

public interface BaseView {

    /**显示*/
    void showProgress();
    /**隐藏*/
    void hideProgress();
    /**提示信息*/
    void showMessage(String message);

}
