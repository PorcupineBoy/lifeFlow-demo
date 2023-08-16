package com.example.demo.test;

import com.example.demo.cmp.BatchSenderCmp;
import com.example.demo.cmp.IF1SwitchCmp;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.core.NodeIfComponent;
import com.yomahub.liteflow.core.NodeSwitchComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            return true;
        } else {

            log.info("不打折");
            return false;
        }

    }

}
