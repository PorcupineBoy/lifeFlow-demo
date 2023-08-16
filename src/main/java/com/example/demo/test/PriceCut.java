package com.example.demo.test;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

@LiteflowComponent(id="priceCut",name="priceCut")
public class PriceCut extends NodeComponent {
    private static final Logger log = LoggerFactory.getLogger(PriceCut.class);

    /**
     * @throws Exception
     */
    @Override
    public void process() throws Exception {

        log.info("构造了春季打折流程组件：延迟一秒");
        int time = new Random().nextInt(1000);
        Thread.sleep(time);
        BuyContext context = this.getContextBean(BuyContext.class);
        List<Goods>  goods = this.getRequestData();
        log.info("size={},购买大于3件,打折", goods.size());
        goods.forEach(o->{
            log.info("{}打折前：{}",o.getName(),o.getCost());
            o.setCost(o.getCost() * 0.9);
            log.info("{}打折前：{}",o.getName(),o.getCost());
        });
        context.setGoods(goods);
    }
}
