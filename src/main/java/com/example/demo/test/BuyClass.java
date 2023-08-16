package com.example.demo.test;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeIfComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@LiteflowComponent(id = "buy", name = "buyCar")
public class BuyClass extends NodeIfComponent {
    private static final Logger log = LoggerFactory.getLogger(BuyClass.class);


    /**
     * @return
     * @throws Exception
     */
    @Override
    public boolean processIf() throws Exception {
        List<Goods>  requestData = this.getRequestData();
        if (requestData.size() > 3) {
            log.info("购买的物品大于3，走打折流程");
            return true;
        } else {

            log.info("不打折");
            return false;
        }

    }

}
