package com.example.demo;

import com.example.demo.context.BatchMessageResultContext;
import com.example.demo.test.BuyContext;
import com.example.demo.test.Goods;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChainExecute implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ChainExecute.class);

    @Resource
    private FlowExecutor flowExecutor;

    @Override
    public void run(String... args) throws Exception {
        List<Goods> list=new ArrayList<>();
        list.add(new Goods("大衣",300.00));
        list.add(new Goods("T-SHIT",100.00));
        list.add(new Goods("帽子",200.00));
        list.add(new Goods("皮鞋",200.00));
        //list.add(new Goods("高级皮鞋",500.00));
        //第二个参数为流程入参，示例中没用到，所以传null，实际业务是有值的
        LiteflowResponse response = flowExecutor.execute2Resp("buyFlow", list, BuyContext.class);
        BuyContext context = response.getContextBean(BuyContext.class);

        if (response.isSuccess()){
            log.info("执行成功，最终支付的金额是{}", context.getAllCount());
        }else{
            log.error("执行失败", response.getCause());
        }
    }
}
