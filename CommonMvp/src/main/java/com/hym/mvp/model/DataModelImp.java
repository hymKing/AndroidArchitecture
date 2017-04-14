package com.hym.mvp.model;

/**
 * 针对于具体的业务的模型层实现
 *
 * @author hym
 * @version 1.0.0
 * @since 2017-04-10 17:41
 */

public class DataModelImp implements IDataModel {
    @Override
    public String getData() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "我是Modle层返回的数据";
    }
}
