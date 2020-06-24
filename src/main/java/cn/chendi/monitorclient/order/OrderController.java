package cn.chendi.monitorclient.order;


import cn.chendi.monitorclient.core.entity.JinfoEntity;
import cn.chendi.monitorclient.core.entity.JpsEntity;
import cn.chendi.monitorclient.core.entity.JstackEntity;
import cn.chendi.monitorclient.core.entity.KVEntity;
import cn.chendi.monitorclient.core.order.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Create by yster@foxmail.com 2018/12/30 0030 16:44
 */
@RestController
@RequestMapping(value = "${monitor.path}")
public class OrderController {

    @RequestMapping("/version")
    public String getVersion(){
        return Javav.version();
    }

    @RequestMapping("/info")
    public JinfoEntity getInfo(String id){
        return Jinfo.info(id);
    }

    @RequestMapping("/jstack")
    public JstackEntity getJstack(String id){
        return Jstack.jstack(id);
    }

    @RequestMapping("/jps")
    public Map<String, JpsEntity> getJps(){
        return Jps.jps();
    }

    @RequestMapping("/jstatclass")
    public List<KVEntity> getJstatClass(String id) throws Exception {
        return Jstat.jstatClass(id);
    }

    @RequestMapping("/jstatgc")
    public List<KVEntity> getJstatGc(String id) throws Exception {
        return Jstat.jstatGc(id);
    }

    @RequestMapping("/jstatutil")
    public List<KVEntity> getJstatUtil(String id) throws Exception {
        return Jstat.jstatUtil(id);
    }

}
